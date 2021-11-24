package me.iiaii.springtypeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import me.iiaii.springtypeconverter.type.IpPort;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {

    @Override
    public IpPort convert(final String source) {
        log.info("converter source={}", source);
        // "127.0.0.1:8080
        return IpPort.from(source);
    }

}
