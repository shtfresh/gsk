package com.tao.hana.mapper;

import com.tao.hana.bean.MerchantBean;
import com.tao.hana.bean.TransactionsBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MerchantsMapper {


    @Insert({ "insert into MERCHANTS(MERCHANT_ID, MERCHANT_NAME,MERCHANT_PASSWORD,MERCHANT_CATEGORY_CODE,MERCHANT_LOCATION) values(#{merchantId}, #{merchantName},#{merchantPassWord},#{merchantCategoryCode},#{merchantLocation})" })
    public int insertMerchant(MerchantBean merchantBean);



    @Select("select * from MERCHANTS where MERCHANT_ID = #{merchantId} and MERCHANT_PASSWORD = #{merchantPassWord}")
    @Results(id = "merchantMap",value = {

            @Result(property = "merchantName",column = "MERCHANT_NAME"),
            @Result(property = "merchantId",column = "MERCHANT_ID"),
            @Result(property = "merchantPassWord",column = "MERCHANT_PASSWORD"),
            @Result(property = "merchantCategoryCode",column = "MERCHANT_CATEGORY_CODE"),
            @Result(property = "merchantLocation",column = "MERCHANT_LOCATION")

    })
    public List<MerchantBean> login(MerchantBean merchantBean);




    @Select("select * from MERCHANTS where MERCHANT_ID = #{MERCHANT_ID}")
    @Results(id = "checkMerchantMap",value = {

            @Result(property = "merchantName",column = "MERCHANT_NAME"),
            @Result(property = "merchantId",column = "MERCHANT_ID"),
            @Result(property = "merchantPassWord",column = "MERCHANT_PASSWORD"),
            @Result(property = "merchantCategoryCode",column = "MERCHANT_CATEGORY_CODE"),
            @Result(property = "merchantLocation",column = "MERCHANT_LOCATION")

    })
    public List<MerchantBean> checkMerchant(String MERCHANT_ID);


}
