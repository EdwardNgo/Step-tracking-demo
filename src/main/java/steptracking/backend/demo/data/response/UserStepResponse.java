package steptracking.backend.demo.data.response;

import lombok.Data;

import java.util.UUID;

@Data
public class UserStepResponse {
    private UUID userId;
    private Long steps;
}
