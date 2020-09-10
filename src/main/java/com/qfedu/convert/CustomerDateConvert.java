package com.qfedu.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description 自定义转换器类，实现了Converter类型
 * @className: CustomerDateConvert
 * @package: com.qfedu.convert
 * @author: Stephen Shen
 * @date: 2020/9/10 上午10:25
 */

public class CustomerDateConvert implements Converter<String, Date> {

    SimpleDateFormat[] sdfs = new SimpleDateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("yyyy年MM月dd日")
    };

    //方法的目的就是把字符串类型的数据转换为时间日期对象
    @Override
    public Date convert(String s) {

        if (s == null || s.isEmpty()) {

            return null;
        }
        for (SimpleDateFormat sdf : sdfs) {
            try {
                //把字符串转为日期对象
                return sdf.parse(s);
            } catch (ParseException e) {
                //e.printStackTrace();
                continue;
            }

        }


        return null;
    }
}
