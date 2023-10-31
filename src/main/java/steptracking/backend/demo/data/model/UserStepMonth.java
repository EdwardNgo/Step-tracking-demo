package steptracking.backend.demo.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class UserStepMonth {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private Long steps;
    private Integer month;
    private Integer year;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
