package com.tao.hana.controller;
import com.alibaba.fastjson.JSONObject;
import com.tao.hana.bean.GLN_BODY;
import com.tao.hana.bean.GLN_HEADER;
import com.tao.hana.bean.JsonRootBean;
import com.tao.hana.util.RestUtil;
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
    public ResponseEntity<String> paymentApproval(@RequestBody GLN_BODY glnBody) {

        GLN_HEADER gln_header = new GLN_HEADER();
        gln_header.setGLN_TX_NO("");
        gln_header.setREQ_ORG_AREA("");
        gln_header.setREQ_ORG_CODE("GSKOUP");
        gln_header.setREQ_ORG_TX_DATE("20190501");
        gln_header.setREQ_ORG_TX_NO("201905010002221");
        gln_header.setREQ_ORG_TX_TIME("101010");
        gln_header.setRES_CODE("");
        gln_header.setRES_ORG_TX_NO("");

        JsonRootBean  jsonRootBean = new JsonRootBean();
        jsonRootBean.setGLN_HEADER(gln_header);
        jsonRootBean.setGLN_BODY(glnBody);

        String url="https://test-api.glnpay.com:9000/api/v2/payments/cpm/approval";



        HttpHeaders httpHeaders= new HttpHeaders ();
        httpHeaders.add("Authorization", "Basic " + "R1NLT1VQOjVGQTZGMkIwNzA1MUU0Qzk5ODAxMjdBMjEyRUUyMUU4RjRBNzkwNEMxNzA1OTk5RDdCMzMxMzBBNzY5MzVGNTY=");
        httpHeaders.add("X-Auth-Type","GLN");
        httpHeaders.add("Timestamp","1550540705307");
        httpHeaders.add("Content-Type","application/json");
        return restUtil.restPost(url,jsonRootBean,httpHeaders);
    }












}
