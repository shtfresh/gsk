package com.tao.hana.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilTime {

        public static void main(String[] args) {


            System.out.println(UtilTime.getStringfomatDate("yyyymmdd"));
            System.out.println(UtilTime.getStringfomatDate("hhmmss"));

    }

    public static String getStringfomatDate(String format){



        /* 日期格式化类 SimpleDateFormat
         * 作用1： 可以把日期转换转指定格式的字符串 format()
         * 作用2： 可以把一个 字符转换成对应的日期。 parse()
         */
        Date date = new Date(); //获取当前的系统时间。
        SimpleDateFormat dateFormat = new SimpleDateFormat(format) ; //使用了默认的格式创建了一个日期格式化对象。
        String time = dateFormat.format(date); //可以把日期转换转指定格式的字符串
        System.out.println("当前的系统时间："+ time);

//        String birthday = "2000年12月26日 11:29:08";
//        Date date2 = dateFormat.parse(birthday); //注意:指定的字符串格式必须要与SimpleDateFormat的模式要一致。

        return time;
    }

}
