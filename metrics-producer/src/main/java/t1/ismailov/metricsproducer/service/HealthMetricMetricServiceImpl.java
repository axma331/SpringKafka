package t1.ismailov.metricsproducer.service;

import lombok.RequiredArgsConstructor;
import t1.ismailov.metricsproducer.dto.HealthMetricDto;
import t1.ismailov.metricsproducer.model.HealthMetricEntity;
import t1.ismailov.metricsproducer.repository.HealthMetricRepository;
import org.springframework.stereotype.Service;

/**
 * Класс для работы со справочником health-metric.
 */
@Service
@RequiredArgsConstructor
public class HealthMetricMetricServiceImpl implements HealthMetricService {

    private final HealthMetricRepository healthMetricRepository;

    @Override
    public HealthMetricEntity createHealthMetric(HealthMetricDto healthMetricDto) {

        HealthMetricEntity healthMetricEntity = new HealthMetricEntity();
        healthMetricEntity.setMetric(healthMetricDto.getMetric());

      return  healthMetricRepository.save(healthMetricEntity);
    }
}
