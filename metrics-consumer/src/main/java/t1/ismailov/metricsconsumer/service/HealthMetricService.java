package t1.ismailov.metricsconsumer.service;

import org.springframework.transaction.annotation.Transactional;
import t1.ismailov.metricsconsumer.model.HealthMetricEntity;

import java.util.Optional;

public interface HealthMetricService {
    Iterable<HealthMetricEntity> getAllHealthMetrics();

    @Transactional(readOnly = true)
    Optional<HealthMetricEntity> getById(Long id);
}
