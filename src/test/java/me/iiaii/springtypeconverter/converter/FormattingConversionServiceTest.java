package me.iiaii.springtypeconverter.converter;

import me.iiaii.springtypeconverter.formatter.MyNumberFormatter;
import me.iiaii.springtypeconverter.type.IpPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FormattingConversionServiceTest {
    
    @Test
    @DisplayName("formattingConversionService")
    public void formattingConversionService() {
        // given
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        // 컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 포메터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        // when
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        String numberFormat = conversionService.convert(1000, String.class);
        Long number = conversionService.convert("1,000", Long.class);

        // then
        assertThat(ipPort).isEqualTo(IpPort.of("127.0.0.1", 8080));
        assertThat(numberFormat).isEqualTo("1,000");
        assertThat(number).isEqualTo(1000);
    }
}
