package org.selina.ptj.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ Author : Selina
 * @ Date : 2020/5/2
 * @ Description : org.selina.ptj.converter
 * @ version : 1.0
 * 自定义日期
 */
@Component
public class DateConverter implements Converter<String,Date> {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
