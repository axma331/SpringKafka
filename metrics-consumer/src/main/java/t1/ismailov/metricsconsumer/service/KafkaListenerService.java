package t1.ismailov.metricsconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import t1.ismailov.metricsconsumer.model.HealthMetricEntity;
import t1.ismailov.metricsconsumer.repository.HealthMetricRepository;

/**
 * Класс для работы с Consumer в Kafka.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaListenerService {

    private final HealthMetricRepository healthMetricRepository;

    @KafkaListener(topics = "health-metrics-topic", groupId = "group_id")
    public void listenHealth(String healthMetric) {
        HealthMetricEntity metric = new HealthMetricEntity();
        metric.setMetric(healthMetric);
        healthMetricRepository.save(metric);
        log.info("Received healthMetric: {}", healthMetric);
    }
}
