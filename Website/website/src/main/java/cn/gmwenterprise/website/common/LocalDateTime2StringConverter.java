package cn.gmwenterprise.website.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LocalDateTime2StringConverter implements Converter<LocalDateTime, String> {
    @Override
    public String convert(LocalDateTime date) {
        return date.toString().replace("T", " ");
    }
}
