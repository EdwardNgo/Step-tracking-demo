package steptracking.backend.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import steptracking.backend.demo.data.domain.LeaderBoardFilter;
import steptracking.backend.demo.data.model.UserStepDay;
import steptracking.backend.demo.data.model.UserStepLog;
import steptracking.backend.demo.data.model.UserStepMonth;
import steptracking.backend.demo.data.model.UserStepWeek;
import steptracking.backend.demo.data.response.UserStepResult;
import steptracking.backend.demo.repository.UserStepDailyRepository;
import steptracking.backend.demo.repository.UserStepLogRepository;
import steptracking.backend.demo.repository.UserStepMonthlyRepository;
import steptracking.backend.demo.repository.UserStepWeeklyRepository;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LeaderBoardService {
    private final UserStepMonthlyRepository userStepMonthlyRepository;
    private final UserStepWeeklyRepository userStepWeeklyRepository;
    private final UserStepDailyRepository userStepDailyRepository;
    public Page<UserStepResult> getUserLeaderBoardDaily(Integer page, Integer size, LocalDate date){
        if (date == null) {
            date = LocalDate.now() ;
        }
        Pageable pageable = PageRequest.of(page, size,Sort.by("steps"));
        Page<UserStepDay> userStepResultDayPage = userStepDailyRepository.findAllByDate(date, pageable);

        return (Page<UserStepResult>) userStepResultDayPage.getContent().stream().map(userStepDay -> {
            UserStepResult result = new UserStepResult();
            result.setUserId(userStepDay.getUserId());
            result.setSteps(userStepDay.getSteps());
            return result;
        }).collect(Collectors.toList());

    }

    public Page<UserStepResult> getUserLeaderBoardWeekly(Integer page, Integer size, Integer week, Integer year) {
        Pageable pageable = PageRequest.of(page, size,Sort.by("steps"));
        Page<UserStepWeek> userStepResultWeekPage = userStepWeeklyRepository.findAllByWeekAndYear(week,year, pageable);
        //Mapper same as above

        return (Page<UserStepResult>) userStepResultWeekPage.stream().map(userStep -> {
            UserStepResult result = new UserStepResult();
            result.setUserId(userStep.getUserId());
            result.setSteps(userStep.getSteps());
            return result;
        }).collect(Collectors.toList());
    }

    public Page<UserStepResult> getUserLeaderBoardMonthly(Integer page, Integer size, Integer month, Integer year) {
        Pageable pageable = PageRequest.of(page, size,Sort.by("steps"));
        Page<UserStepMonth> userStepResultMonthPage = userStepMonthlyRepository.findAllByMonthAndYear(month,year, pageable);
        //Mapper same as above

        return (Page<UserStepResult>) userStepResultMonthPage.stream().map(userStep -> {
            UserStepResult result = new UserStepResult();
            result.setUserId(userStep.getUserId());
            result.setSteps(userStep.getSteps());
            return result;
        }).collect(Collectors.toList());
    }


    }
