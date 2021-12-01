package me.iiaii.springtypeconverter.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.iiaii.springtypeconverter.type.IpPort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConverterController {

    @GetMapping("/converter-view")
    public String converterView(final Model model) {
        model.addAttribute("number", 10000);
        model.addAttribute("ipPort", IpPort.of("127.0.0.1", 8080));
        return "converter-view";
    }

    @GetMapping("/converter/edit")
    public String converterForm(final Model model) {
        IpPort ipPort = IpPort.of("127.0.0.1", 8080);
        Form form = new Form(ipPort);
        model.addAttribute("form", form);
        return "converter-form";
    }

    @PostMapping("/converter/edit")
    public String converterEdit(@ModelAttribute final Form form, final Model model) {
        IpPort ipPort = form.getIpPort();
        model.addAttribute("ipPort", ipPort);
        return "converter-view";
    }

    @Data
    @AllArgsConstructor
    static class Form {
        private IpPort ipPort;
    }
}
