package t1.ismailov.metricsproducer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Класс для работы с Producer в Kafka.
 */
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String healthMetric) {
        kafkaTemplate.send("health-metrics-topic", healthMetric);
    }
}
