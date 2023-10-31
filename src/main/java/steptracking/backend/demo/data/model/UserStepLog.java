package steptracking.backend.demo.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
public class UserStepLog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private UUID activityId;
    private Timestamp startAt;
    private Timestamp endAt;
    private Long steps;


}
