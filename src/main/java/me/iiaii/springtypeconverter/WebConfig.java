package me.iiaii.springtypeconverter;

import me.iiaii.springtypeconverter.converter.IntegerToStringConverter;
import me.iiaii.springtypeconverter.converter.IpPortToStringConverter;
import me.iiaii.springtypeconverter.converter.StringToIntegerConverter;
import me.iiaii.springtypeconverter.converter.StringToIpPortConverter;
import me.iiaii.springtypeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(final FormatterRegistry registry) {
        // 우선순위 때문에 주석처리
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());

        // Formatter 추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
