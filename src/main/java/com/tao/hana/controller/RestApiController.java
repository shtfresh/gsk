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
import java.util.List;
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



    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(@RequestBody MerchantBean merchantBean) throws NoSuchAlgorithmException {
        String message="success";
        String password = merchantBean.getMerchantPassWord();

        //java自带工具包MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");
        String endcodePassWord = MD5Encoder.encode(md.digest(password.getBytes()));

        System.out.println(endcodePassWord);
        merchantBean.setMerchantPassWord(endcodePassWord);







        try{
           List<MerchantBean> listMerchantBean = merchantsMapper.login(merchantBean);
           if(listMerchantBean == null || listMerchantBean.size()<=0){
               message="false";
           }
        }catch(Exception e){
            message=e.getMessage();
        }
        return message;
    }


    @RequestMapping(value="/registMerchant",method=RequestMethod.POST)
    public String insertMerchant(@RequestBody MerchantBean merchantBean) throws NoSuchAlgorithmException {
        String message="success";
        String password = merchantBean.getMerchantPassWord();

        //java自带工具包MessageDigest
        MessageDigest md = MessageDigest.getInstance("MD5");
        String endcodePassWord = MD5Encoder.encode(md.digest(password.getBytes()));

        System.out.println(endcodePassWord);
        merchantBean.setMerchantPassWord(endcodePassWord);


        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        merchantBean.setMerchantId(uuid);


        System.out.println(merchantBean.getMerchantName());

        try{
            merchantsMapper.insertMerchant(merchantBean);
        }catch(Exception e){
            message=e.getMessage();
        }
    return message;
    }

    @RequestMapping(value="/payment_approval",method=RequestMethod.POST)
    public String paymentApproval(@RequestBody String json) {
        log.debug("this is  parameter from  http request");
        log.debug(json);


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

        transationsMapper.insertTransations(transactionsBean);

        System.out.println(RES_MSG);
        return RES_MSG;
    }












}
