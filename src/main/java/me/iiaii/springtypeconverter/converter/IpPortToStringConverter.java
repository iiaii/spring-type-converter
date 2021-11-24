package me.iiaii.springtypeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import me.iiaii.springtypeconverter.type.IpPort;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IpPortToStringConverter implements Converter<IpPort, String> {

    @Override
    public String convert(final IpPort ipPort) {
        log.info("converter source={}", ipPort);
        // "127.0.0.1:8080
        return ipPort.toSource();
    }

}
