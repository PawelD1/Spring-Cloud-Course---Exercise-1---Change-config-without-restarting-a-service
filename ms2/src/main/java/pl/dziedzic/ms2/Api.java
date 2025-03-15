package pl.dziedzic.ms2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Api {

    @Value("${message}")
    private String message;

    @GetMapping("/hello")
    public String get() {
        return message;
    }
}
