package steptracking.backend.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import steptracking.backend.demo.data.model.UserStepMonth;
import steptracking.backend.demo.data.model.UserStepWeek;

import java.util.UUID;

public interface UserStepWeeklyRepository extends JpaRepository<UserStepWeek, UUID> {

    UserStepWeek findByUserIdAndWeekAndYear(UUID userId, Integer month, Integer year);

    Page<UserStepWeek> findAllByWeekAndYear(Integer week, Integer year, Pageable pageable);

}
