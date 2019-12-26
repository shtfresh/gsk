package com.tao.hana.mapper;

import com.tao.hana.bean.TransactionsBean;
import org.apache.ibatis.annotations.Insert;

public interface TransationsMapper {


    @Insert({ "insert into TRANSACTIONS(GLN_TX_NUMBER, LOCAL_TX_NUMBER, AMOUNT, CURRENCY, STATUS,MERCHANT_ID," +
            "RES_MSG,ADDITIVE_MSG,RCVR_TX_DATETIME,SETTLEMENT_DATE,TX_AMOUNT,RCVR_SETTLEMENT_AMOUNT,TX_LOCAL_AMOUNT," +
            "RCVR_SETTLEMENT_LOCAL_AMOUNT,RCVR_CUR_CODE,FX_TICKER_NO,USD_BASIC_RATE,USD_BUY_RATE,USER_NAME,USER_NAT_CODE," +
            "SNDR_LOCALGLN_CODE,LOCALGLN_UUID)" +
            " values(#{glnTxNumber}, #{localTxNumber}, #{amount}, #{currency}, #{status},#{merchantId}," +
            "#{resMsg},#{additiveMsg},#{rcvrTxDatetime},#{settlementDate},#{txAmount},#{rcvrSettlementAmount},#{txLocalAmount}," +
            "#{rcvrSettlementLocalAmount},#{rcvrCurCode},#{fxTickerNo},#{usdBasicRate},#{usdBuyRate},#{userName},#{userNatCode}," +
            "#{sndrLocalglnCode},#{localglnUuid})" })
    public int insertTransations(TransactionsBean transactionsBean);

}
