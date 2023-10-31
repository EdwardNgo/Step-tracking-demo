package steptracking.backend.demo.data.request;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class FinishActivityRequest {

    private UUID userId;
    private UUID activityId;
    private Timestamp startAt;
    private Timestamp endAt;
    private Long steps;
}
