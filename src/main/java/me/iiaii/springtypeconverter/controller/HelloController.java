package me.iiaii.springtypeconverter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello-v1")
    public String helloV1(final HttpServletRequest request) {
        String data = request.getParameter("data");
        Integer integer = Integer.valueOf(data);
        log.info("intValue = {}", integer);
        return "ok";
    }
}
