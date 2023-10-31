package steptracking.backend.demo.data.response;

import lombok.Data;

import java.util.UUID;

@Data
public class UserStepResult {
    private Long steps;
    private UUID userId;
}
