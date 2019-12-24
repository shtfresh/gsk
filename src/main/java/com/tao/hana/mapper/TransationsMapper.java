package com.tao.hana.mapper;

import com.tao.hana.bean.TransactionsBean;
import org.apache.ibatis.annotations.Insert;

public interface TransationsMapper {


    @Insert({ "insert into TRANSACTIONS(GLN_TX_NUMBER, LOCAL_TX_NUMBER, AMOUNT, CURRENCY, STATUS) values(#{glnTxNumber}, #{localTxNumber}, #{amount}, #{currency}, #{status})" })
    public int insertTransations(TransactionsBean transactionsBean);

}
