package steptracking.backend.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import steptracking.backend.demo.data.model.UserStepMonth;

import java.util.UUID;

public interface UserStepMonthlyRepository extends JpaRepository<UserStepMonth, UUID> {

    UserStepMonth findByUserIdAndMonthAndYear(UUID userId, Integer month, Integer year);

    Page<UserStepMonth> findAllByMonthAndYear(Integer month, Integer year, Pageable pageable);

}
