package cn.gmwenterprise.website.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LocalDate2StringConverter implements Converter<LocalDate, String> {
    @Override
    public String convert(LocalDate date) {
        return date.toString();
    }
}
