package t1.ismailov.metricsconsumer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import t1.ismailov.metricsconsumer.model.HealthMetricEntity;
import t1.ismailov.metricsconsumer.service.HealthMetricService;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@Tag(name = "Metrics Consumer", description = "API для работы с метриками")
public class HealthController {

    private final HealthMetricService healthMetricService;

    @Operation(summary = "Получение метрики по ID", description = "Возвращает метрику приложения по ее уникальному идентификатору.")
    @GetMapping("/metric/{id}")
    public ResponseEntity<Optional<HealthMetricEntity>> getById(
            @Parameter(description = "Идентификатор метрики", example = "1") @PathVariable Long id
    ) {
        Optional<HealthMetricEntity> result = healthMetricService.getById(id);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Получение всех метрик", description = "Возвращает все метрики приложения.")
    @GetMapping("/metric")
    public Iterable<HealthMetricEntity> getAllHealthMetrics() {
        return healthMetricService.getAllHealthMetrics();
    }
}
