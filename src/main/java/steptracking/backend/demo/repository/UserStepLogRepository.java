package steptracking.backend.demo.repository;

import org.springframework.data.repository.CrudRepository;
import steptracking.backend.demo.data.model.UserStepLog;

import java.util.UUID;

public interface UserStepLogRepository extends CrudRepository<UserStepLog, UUID> {
}
