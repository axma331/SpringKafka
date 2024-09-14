package t1.ismailov.metricsproducer.service;

import t1.ismailov.metricsproducer.dto.HealthMetricDto;
import t1.ismailov.metricsproducer.model.HealthMetricEntity;
import org.springframework.transaction.annotation.Transactional;

public interface HealthMetricService {

    @Transactional
    HealthMetricEntity createHealthMetric(HealthMetricDto healthMetricDto);
}
