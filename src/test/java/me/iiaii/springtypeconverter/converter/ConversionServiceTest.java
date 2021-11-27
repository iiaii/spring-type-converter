package me.iiaii.springtypeconverter.converter;

import me.iiaii.springtypeconverter.type.IpPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConversionServiceTest {

    @Test
    @DisplayName("conversionService")
    void conversionService() {
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        assertThat(conversionService.convert("10", Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");

        assertThat(conversionService.convert("127.0.0.1:8080", IpPort.class)).isEqualTo(IpPort.of("127.0.0.1", 8080));
        assertThat(conversionService.convert(IpPort.of("127.0.0.1", 8080), String.class)).isEqualTo("127.0.0.1:8080");
    }

}
