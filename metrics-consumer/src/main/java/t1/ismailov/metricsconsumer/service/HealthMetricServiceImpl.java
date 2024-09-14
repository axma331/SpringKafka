package t1.ismailov.metricsconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import t1.ismailov.metricsconsumer.model.HealthMetricEntity;
import t1.ismailov.metricsconsumer.repository.HealthMetricRepository;

import java.util.Optional;

/**
 * Класс для работы со справочником health-metric.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class HealthMetricServiceImpl implements HealthMetricService {

    private final HealthMetricRepository healthMetricRepository;

    @Override
    public Iterable<HealthMetricEntity> getAllHealthMetrics() {
        return healthMetricRepository.findAll();
    }

    @Override
    public Optional<HealthMetricEntity> getById(Long id) {
        log.info("Health metric get by id: {}", id);
        Optional<HealthMetricEntity> healthMetric = healthMetricRepository.findById(id);
        log.info("Health metric get record received: {}", healthMetric);
        return healthMetric;
    }
}
