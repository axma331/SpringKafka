package t1.ismailov.metricsproducer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import t1.ismailov.metricsproducer.dto.HealthMetricDto;
import t1.ismailov.metricsproducer.service.HealthMetricService;
import t1.ismailov.metricsproducer.service.KafkaProducerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Контроллер для работы со справочником метрики health и отправки сообщений в
 * брокер Kafka.
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Metrics Producer", description = "API для отправки метрик в Kafka")
public class KafkaHealthMetricProducerController {

    private final KafkaProducerService kafkaProducerService;
    private final RestTemplate restTemplate;
    private final HealthMetricService healthMetricService;


    @PostMapping("/send-metric")
    @Operation(summary = "Отправка метрик", description = "Отправляет метрики работы приложения в Kafka топик для дальнейшего анализа")
    public void sendMetric() {
        String healthMetric = restTemplate.getForObject("http://localhost:8080/actuator/health", String.class);
        kafkaProducerService.sendMessage(healthMetric);

        HealthMetricDto metric = new HealthMetricDto();
        metric.setMetric(healthMetric);
        healthMetricService.createHealthMetric(metric);

        log.info("Health metric sent in kafka");
    }
}
