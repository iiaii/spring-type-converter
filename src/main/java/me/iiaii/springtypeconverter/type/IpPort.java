package me.iiaii.springtypeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class IpPort {

    private static final String DELIMITER = ":";
    private final String ip;
    private final int port;

    private IpPort(final String ip, final int port) {
        this.ip = ip;
        this.port = port;
    }

    public static IpPort from(final String source) {
        String[] ipPort = source.split(DELIMITER);
        return new IpPort(ipPort[0], Integer.parseInt(ipPort[1]));
    }

    public static IpPort of(final String ip, final int port) {
        return new IpPort(ip, port);
    }

    public String toSource() {
        return ip + DELIMITER + port;
    }
}
