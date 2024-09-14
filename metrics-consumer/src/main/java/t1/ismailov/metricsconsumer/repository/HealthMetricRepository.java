package t1.ismailov.metricsconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import t1.ismailov.metricsconsumer.model.HealthMetricEntity;

/**
 * Репозиторий для получения записей из health_metric.
 */
public interface HealthMetricRepository extends JpaRepository<HealthMetricEntity, Long> {
}
