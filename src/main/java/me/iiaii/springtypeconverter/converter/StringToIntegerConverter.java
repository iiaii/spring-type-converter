package me.iiaii.springtypeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> {

    @Override
    public Integer convert(final String source) {
        log.info("convert source={}", source);
        return Integer.valueOf(source);
    }

}
