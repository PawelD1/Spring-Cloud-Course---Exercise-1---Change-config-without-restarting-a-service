package pl.dziedzic.ms1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//aktualizacja plików konfiguracyjnych w razie załadowania nowych beanów
@RefreshScope
@RestController
public class Api {

    @Value("${message: we are without config server}")
    private String message;

    @GetMapping("/hello")
    public String get() {
        return message;
    }
}
