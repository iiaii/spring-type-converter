package me.iiaii.springtypeconverter.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class FormatterController {

    @GetMapping("/formatter/edit")
    public String formatterForm(final Model model) {
        Form form = new Form(10000, LocalDateTime.now());
        model.addAttribute("form", form);
        return "formatter-form";
    }

    @PostMapping("formatter/edit")
    public String formatterEdit(@ModelAttribute final Form form) {
        return "formatter-view";
    }

    @Data
    @RequiredArgsConstructor
    static class Form {
        @NumberFormat(pattern = "###,###")
        private final Integer number;

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private final LocalDateTime localDateTime;
    }
}
