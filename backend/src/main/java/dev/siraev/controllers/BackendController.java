package dev.siraev.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {
    @RequestMapping(value = "{_:^(?!index\\.html|api).$}")
    public String redirect() {
        // Forward to home page so that route is preserved.
        return "forward:/";
    }
}
