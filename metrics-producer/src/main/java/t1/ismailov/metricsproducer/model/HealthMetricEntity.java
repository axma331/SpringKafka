package t1.ismailov.metricsproducer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Справочник метрики health.
 * Представление записи справочника health в базе данных.
 */
@Entity
@Table(name = "health_metric")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class HealthMetricEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String metric;
}
