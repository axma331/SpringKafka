package t1.ismailov.metricsproducer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Создание топиков для отправки в брокер сообщений Kafka.
 */
@Configuration
public class KafkaConfiguration {

    @Bean
    public NewTopic newTopic() {
        return new NewTopic(
                "health-metrics-topic",
                1,
                (short) 1
        );
    }
}
