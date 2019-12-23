package com.tao.hana.util;

import org.springframework.http.HttpHeaders;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Base64;
import java.util.Date;


/**
 * <b>GLN Auth Sample</b>
 * @author Taewook.Choi
 * @date 2019. 12. 12.
 * <hr>
 * <pre>
 * GLN Auth Sample
 *
 */
public class GLN_Auth_Sample {

    public static void main(String[] args) {

        String authId = "GSKOUP";
        String authSecret = "6D386E4B3475417430725379656869747275304838413079764279536D6E764E";
        GLN_Auth_Sample.getHttpHeaders();

    }


    //public static void setHttpheader(String authId, String authSecret) {
    public static HttpHeaders getHttpHeaders() {

        HttpHeaders httpHeaders = new HttpHeaders();
        try {

            String authId = "GSKOUP";
            String authSecret = "6D386E4B3475417430725379656869747275304838413079764279536D6E764E";
            //header 1.
            //set httpheader name : Timestamp
            //String timestamp = String.valueOf(System.currentTimeMillis());
			String timestamp =  new Date().getTime()+"";
System.out.println(timestamp);
            //header 2.
            //set httpheader name : Authorization
            String hashValue = HMACSHA256.generate(timestamp, authSecret);
			System.out.printf("hashValue: %s\n",hashValue);
            String authorization = authId + ":" + hashValue;
            authorization = "Basic " + Base64.getEncoder().encodeToString(authorization.getBytes());

            System.out.printf("authorization: %s\n",authorization);

            //header 3.
            //set httpheader name : X-Auth-Type = GLN
            //header 4.
            //set httpheader name : Accept = application/json
            //header 5.
            //set httpheader name : Content-Type = application/json


            httpHeaders.add("Authorization", authorization);
            httpHeaders.add("Timestamp", timestamp);
            httpHeaders.add("X-Auth-Type", "GLN");
            httpHeaders.add("Content-Type", "application/json");




        } catch (InvalidKeyException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return httpHeaders;
    }




    public static class HMACSHA256	{
        final private static String ALGORITHM = "HmacSHA256";

        public static String generate(String in, String apikey)
                throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException
        {
            byte[]	key = HexaString.decode(apikey);
            SecretKeySpec keySpec = new SecretKeySpec(key, ALGORITHM);
            Mac		mac = Mac.getInstance(ALGORITHM);
            mac.init(keySpec);

            byte[] out = mac.doFinal(in.getBytes("UTF-8"));
            return HexaString.encode(out);
        }
    }


    public static class HexaString {
        public static String encode(byte[] in)	{
            return DatatypeConverter.printHexBinary(in);
        }
        public static byte[] decode(String in)	{
            return DatatypeConverter.parseHexBinary(in);
        }
    }

}
