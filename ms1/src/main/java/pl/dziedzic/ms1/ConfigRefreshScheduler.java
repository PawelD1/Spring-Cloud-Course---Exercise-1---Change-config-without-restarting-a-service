package pl.dziedzic.ms1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConfigRefreshScheduler {

    private static final Logger logger = LoggerFactory.getLogger(ConfigRefreshScheduler.class);
    private final RestTemplate restTemplate;

    public ConfigRefreshScheduler() {
        this.restTemplate = new RestTemplate();
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void refreshConfig() throws Exception {
        String actuatorRefreshUrl = "http://localhost:9999/actuator/refresh";
        try {
            restTemplate.postForObject(actuatorRefreshUrl, null, String.class);
            logger.info("Request '{}' was successful", actuatorRefreshUrl);
        } catch (Exception e) {
            logger.error("Error during executing request {}: {}", actuatorRefreshUrl, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}