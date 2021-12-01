package me.iiaii.springtypeconverter.formatter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Locale.KOREA;
import static org.assertj.core.api.Assertions.assertThat;

class MyNumberFormatterTest {

    MyNumberFormatter formatter = new MyNumberFormatter();

    @Test
    @DisplayName("parse")
    public void parse() throws Exception {
        // given

        // when
        Number result = formatter.parse("1,000", KOREA);

        // then
        assertThat(result).isEqualTo(1000L);
    }

    @Test
    @DisplayName("print")
    public void print() {
        // given

        // when
        String result = formatter.print(1000, KOREA);

        // then
        assertThat(result).isEqualTo("1,000");
    }

}