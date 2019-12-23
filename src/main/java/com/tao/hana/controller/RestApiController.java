package com.tao.hana.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tao.hana.bean.GLN_BODY;
import com.tao.hana.bean.GLN_HEADER;
import com.tao.hana.bean.JsonRootBean;
import com.tao.hana.util.GLN_Auth_Sample;
import com.tao.hana.util.RestUtil;
import com.tao.hana.util.UtilTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/getRest")
public class RestApiController {



    @Autowired
    RestUtil restUtil;






    @RequestMapping(value="/payment_approval",method=RequestMethod.POST)
    public ResponseEntity<String> paymentApproval(@RequestBody String json) {
        GLN_BODY glnBody=  JSON.parseObject(json,GLN_BODY.class);
        System.out.println(JSON.toJSONString(glnBody));
        GLN_HEADER gln_header = new GLN_HEADER();

//         gln_header.setREQ_ORG_TX_NO(UtilTime.getStringfomatDate("yyyymmddhhmmss"));
//        gln_header.setREQ_ORG_CODE("GSKOUP");
//        gln_header.setREQ_ORG_TX_DATE(UtilTime.getStringfomatDate("yyyymmdd"));
//        gln_header.setREQ_ORG_TX_TIME(UtilTime.getStringfomatDate("hhmmss"));


        gln_header.setREQ_ORG_TX_NO("GSKOUP201912230009");
        gln_header.setREQ_ORG_CODE("GSKOUP");
        gln_header.setREQ_ORG_TX_DATE("20191223");
        gln_header.setREQ_ORG_TX_TIME("144000");
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

        return restUtil.restPost(url,jsonString,httpHeaders);
    }












}
