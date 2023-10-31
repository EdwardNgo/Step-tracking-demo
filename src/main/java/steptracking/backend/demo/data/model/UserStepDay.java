package steptracking.backend.demo.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class UserStepDay {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private Long steps;
    private LocalDate date;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
