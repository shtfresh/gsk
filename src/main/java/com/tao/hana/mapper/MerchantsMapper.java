package com.tao.hana.mapper;

import com.tao.hana.bean.MerchantBean;
import com.tao.hana.bean.TransactionsBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface MerchantsMapper {


    @Insert({ "insert into MERCHANTS(MERCHANT_ID, MERCHANT_NAME,MERCHANT_PASSWORD) values(#{merchantId}, #{merchantName},#{merchantPassWord})" })
    public int insertMerchant(MerchantBean merchantBean);



    @Select("select * from MERCHANTS where MERCHANT_NAME = #{merchantName} and MERCHANT_PASSWORD = #{merchantPassWord}")
    @Results(id = "merchantMap",value = {

            @Result(property = "merchantName",column = "MERCHANT_NAME"),
            @Result(property = "merchantId",column = "MERCHANT_ID"),
            @Result(property = "merchantPassWord",column = "MERCHANT_PASSWORD")


    })
    public List<MerchantBean> login(MerchantBean merchantBean);
}
