package t1.ismailov.metricsproducer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import t1.ismailov.metricsproducer.model.HealthMetricEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Репозиторий для получения записей из health_metric.
 */
public interface HealthMetricRepository extends JpaRepository<HealthMetricEntity, Long> {
}
