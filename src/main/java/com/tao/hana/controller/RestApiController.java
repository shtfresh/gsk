package com.tao.hana.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tao.hana.bean.*;
import com.tao.hana.mapper.MerchantsMapper;
import com.tao.hana.mapper.TransationsMapper;
import com.tao.hana.util.GLN_Auth_Sample;
import com.tao.hana.util.RestUtil;
import com.tao.hana.util.UtilTime;
import org.apache.log4j.Logger;
import org.apache.tomcat.jni.Mmap;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/getRest")
public class RestApiController {



    @Autowired
    RestUtil restUtil;

    @Autowired
    TransationsMapper transationsMapper;
    @Autowired
    MerchantsMapper merchantsMapper;

    private static Logger log= Logger.getLogger("firstLogger");;



    @RequestMapping(value="/merchant/login",method=RequestMethod.POST)
    public JSONObject login(@RequestBody MerchantBean merchantBean) throws NoSuchAlgorithmException {
        String message="success";
        String password = merchantBean.getMerchantPassWord();
        log.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
log.debug(merchantBean.getMerchantId());
        //java自带工具包MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");
        String endcodePassWord = MD5Encoder.encode(md.digest(password.getBytes()));

        System.out.println(endcodePassWord);
        merchantBean.setMerchantPassWord(endcodePassWord);


        MerchantBean merchantBeanFromDB=null;
        JSONObject jsonObject=new JSONObject();
        try{
           List<MerchantBean> listMerchantBean = merchantsMapper.login(merchantBean);
            log.debug("---------------------------------");

           if(listMerchantBean == null || listMerchantBean.size()<=0){
               message="false";
           }else{
                merchantBeanFromDB= listMerchantBean.get(0);
                jsonObject = JSONObject.parseObject(JSON.toJSONString(merchantBeanFromDB));

                log.debug("hhhhh:"+jsonObject);

               jsonObject.put("code","N0000000");
               jsonObject.put("message","Okay");



           }
        }catch(Exception e){
            message=e.getMessage();
            System.out.println("++++++++"+message);
        }
        //JSONObject.parseObject(JSON.toJSONString(glnBody));
        if(message.equals("false")){
            jsonObject.put("message",message);
            jsonObject.put("code","RSP00002");
        }

        return jsonObject;
    }


    @RequestMapping(value="/merchant/register",method=RequestMethod.POST)
    public JSONObject  insertMerchant(@RequestBody MerchantBean merchantBean) throws NoSuchAlgorithmException {
        String message="false";
        String code ="N0000000";
        String password = merchantBean.getMerchantPassWord();

        //java自带工具包MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");
        String endcodePassWord = MD5Encoder.encode(md.digest(password.getBytes()));

        System.out.println(endcodePassWord);
        merchantBean.setMerchantPassWord(endcodePassWord);


//        String uuid = UUID.randomUUID().toString().replaceAll("-","");
//        merchantBean.setMerchantId(uuid);




        try{
            if(merchantsMapper.checkMerchant(merchantBean.getMerchantId()).size()<=0){
                merchantsMapper.insertMerchant(merchantBean);
                message="success";
            }else{
                message="merchant id already exists";
                code="RSP00001";
            }
        }catch(Exception e){
            message=e.getMessage();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message",message);
        jsonObject.put("code",code);
        return jsonObject;
    }

    @RequestMapping(value="/payment/approval",method=RequestMethod.POST)
    public JSONObject paymentApproval(@RequestBody String json) {
        log.debug("this is  parameter from  http request");
        log.debug(json);
        String code ="N0000000";

        GLN_BODY glnBody=  JSON.parseObject(json,GLN_BODY.class);
        System.out.println(JSON.toJSONString(glnBody));
        GLN_HEADER gln_header = new GLN_HEADER();

        gln_header.setREQ_ORG_TX_NO(UtilTime.getStringfomatDate("yyyyMMddhhmmss"));
        gln_header.setREQ_ORG_CODE("GSKOUP");
        gln_header.setREQ_ORG_TX_DATE(UtilTime.getStringfomatDate("yyyyMMdd"));
        gln_header.setREQ_ORG_TX_TIME(UtilTime.getStringfomatDate("hhmmss"));

        log.debug("this is  gln_header");
        log.debug(gln_header.getREQ_ORG_TX_NO());
        log.debug(gln_header.getREQ_ORG_CODE());
        log.debug(gln_header.getREQ_ORG_TX_DATE());
        log.debug(gln_header.getREQ_ORG_TX_TIME());

//        gln_header.setREQ_ORG_TX_NO("GSKOUP201912230009");
//        gln_header.setREQ_ORG_CODE("GSKOUP");
//        gln_header.setREQ_ORG_TX_DATE("20191223");
//        gln_header.setREQ_ORG_TX_TIME("144000");
       // gln_header.setREQ_ORG_TX_NO("GSKOUP"+UtilTime.getStringfomatDate("yyyymmddhhmmss"));

        gln_header.setGLN_TX_NO("");
        gln_header.setRES_ORG_TX_NO("");
        //gln_header.setREQ_ORG_TX_TIME("101010");
        gln_header.setREQ_ORG_AREA("");
        gln_header.setRES_CODE("");
        gln_header.setRES_ORG_TX_NO("");

        JsonRootBean  jsonRootBean = new JsonRootBean();
        jsonRootBean.setGLN_HEADER(gln_header);
        jsonRootBean.setGLN_BODY(glnBody);

        String url="https://test-api.glnpay.com:9000/api/v2/payments/cpm/approval";








        

        String jsonString = JSON.toJSONString(jsonRootBean);
        HttpHeaders httpHeaders= GLN_Auth_Sample.getHttpHeaders();


        ResponseEntity<String> responseEntity = restUtil.restPost(url,jsonString,httpHeaders);


        Object response = JSONObject.parse(responseEntity.getBody());
        JSONObject  myJson = JSONObject.parseObject(responseEntity.getBody());

        String  RES_MSG =  myJson.getJSONObject("GLN_BODY").getString("RES_MSG");
        String GLN_TX_NUMBER = myJson.getJSONObject("GLN_HEADER").getString("GLN_TX_NO");
        TransactionsBean transactionsBean = new TransactionsBean();
        int status=0;
        if(RES_MSG.equals("Okay")){
            status=1;
        }

        transactionsBean.setAmount(glnBody.getREQ_AMOUNT());
        transactionsBean.setCurrency(glnBody.getMERCHANT_NAT_CODE());
        transactionsBean.setGlnTxNumber(GLN_TX_NUMBER);
        transactionsBean.setLocalTxNumber("local_"+GLN_TX_NUMBER);
        transactionsBean.setStatus(status);
        transactionsBean.setMerchantId(glnBody.getMERCHANT_ID());

        ResponseJsonbody responseJsonbody=  JSON.parseObject(myJson.getJSONObject("GLN_BODY").toJSONString(),ResponseJsonbody.class);

        transactionsBean.setResMsg(responseJsonbody.getRES_MSG()==null ? "":responseJsonbody.getRES_MSG());
        transactionsBean.setAdditiveMsg(responseJsonbody.getADDITIVE_MSG()==null ? "":responseJsonbody.getADDITIVE_MSG());
        transactionsBean.setRcvrTxDatetime(responseJsonbody.getRCVR_TX_DATETIME()==null ? "":responseJsonbody.getRCVR_TX_DATETIME());
        transactionsBean.setSettlementDate(responseJsonbody.getSETTLEMENT_DATE()==null ? "":responseJsonbody.getSETTLEMENT_DATE());
        transactionsBean.setTxAmount(responseJsonbody.getTX_AMOUNT()==null ? "":responseJsonbody.getTX_AMOUNT());

        transactionsBean.setRcvrSettlementAmount(responseJsonbody.getRCVR_SETTLEMENT_AMOUNT()==null ? "":responseJsonbody.getRCVR_SETTLEMENT_AMOUNT());
        transactionsBean.setTxLocalAmount(responseJsonbody.getTX_LOCAL_AMOUNT()==null ? "":responseJsonbody.getTX_LOCAL_AMOUNT());
        transactionsBean.setRcvrSettlementLocalAmount(responseJsonbody.getRCVR_SETTLEMENT_LOCAL_AMOUNT()==null ? "":responseJsonbody.getRCVR_SETTLEMENT_LOCAL_AMOUNT());
        transactionsBean.setRcvrCurCode(responseJsonbody.getRCVR_CUR_CODE()==null ? "":responseJsonbody.getRCVR_CUR_CODE());

        transactionsBean.setFxTickerNo(responseJsonbody.getFX_TICKER_NO()==null ? "":responseJsonbody.getFX_TICKER_NO());
        transactionsBean.setUsdBasicRate(responseJsonbody.getUSD_BASIC_RATE()==null ? "":responseJsonbody.getUSD_BASIC_RATE());
        transactionsBean.setUsdBuyRate(responseJsonbody.getUSD_BUY_RATE()==null ? "":responseJsonbody.getUSD_BUY_RATE());
        transactionsBean.setUserName(responseJsonbody.getUSER_NAME()==null ? "":responseJsonbody.getUSER_NAME());
        transactionsBean.setUserNatCode(responseJsonbody.getUSER_NAT_CODE()==null ? "":responseJsonbody.getUSER_NAT_CODE());
        transactionsBean.setUserNatCode(responseJsonbody.getUSER_NAT_CODE()==null ? "":responseJsonbody.getUSER_NAT_CODE());
        transactionsBean.setSndrLocalglnCode(responseJsonbody.getSNDR_LOCALGLN_CODE()==null ? "":responseJsonbody.getSNDR_LOCALGLN_CODE());
        transactionsBean.setLocalglnUuid(responseJsonbody.getLOCALGLN_UUID()==null ? "":responseJsonbody.getLOCALGLN_UUID());



        System.out.println("--------------------------------");
        System.out.println(transactionsBean.getResMsg());

        System.out.println(transactionsBean.getRcvrSettlementAmount());


        transationsMapper.insertTransations(transactionsBean);

        System.out.println(RES_MSG);
        JSONObject jsonObject;
        if(RES_MSG.equals("Okay")){

             jsonObject = myJson.getJSONObject("GLN_BODY");
            jsonObject.put("code",code);
        }else{
             jsonObject = new JSONObject();
            jsonObject.put("message",RES_MSG);
            code ="BOFP0001";

            jsonObject.putIfAbsent("code",code);
        }


        return jsonObject;
    }












}
