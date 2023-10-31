package steptracking.backend.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import steptracking.backend.demo.data.model.UserStepDay;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public interface UserStepDailyRepository extends JpaRepository<UserStepDay, UUID> {

    UserStepDay findByUserIdAndDate(UUID userId, Date date);

    Page<UserStepDay> findAllByDate(LocalDate date, Pageable pageable);
}
