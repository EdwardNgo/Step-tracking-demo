package steptracking.backend.demo.service;

import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import steptracking.backend.demo.data.model.UserStepLog;
import steptracking.backend.demo.data.model.UserStepMonth;
import steptracking.backend.demo.data.model.UserStepWeek;
import steptracking.backend.demo.data.request.FinishActivityRequest;
import steptracking.backend.demo.data.response.UserStepMonthResponse;
import steptracking.backend.demo.data.response.UserStepResponse;
import steptracking.backend.demo.data.response.UserStepWeekResponse;
import steptracking.backend.demo.repository.UserStepLogRepository;
import steptracking.backend.demo.repository.UserStepMonthlyRepository;
import steptracking.backend.demo.repository.UserStepWeeklyRepository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserStepService {

    private final UserStepMonthlyRepository userStepMonthlyRepository;
    private final UserStepWeeklyRepository userStepWeeklyRepository;
    private final UserStepLogRepository userStepLogRepository;

    public UserStepWeekResponse getUserStepWeek(UUID userId, Integer week, Integer year){
        UserStepWeek userStepWeek = userStepWeeklyRepository.findByUserIdAndWeekAndYear(userId, week, year);
        //TOOD: mapper to map the model to response not good to do like this but I'm kinda lazy
        UserStepWeekResponse userStepResponse = new UserStepWeekResponse();
        userStepResponse.setSteps(userStepResponse.getSteps());
        userStepResponse.setUserId(userId);
        return userStepResponse;
    }

    public UserStepMonthResponse getUserStepMonth(UUID userId, Integer month, Integer year){
        UserStepMonth userStepMonth = userStepMonthlyRepository.findByUserIdAndMonthAndYear(userId, month, year);
        //SAME as user step week so just ignore
        //TODO: implement later

        return new UserStepMonthResponse();
    }

    public String submitActivityResult(FinishActivityRequest request){
        //TODO: should be a mapper for it
        UserStepLog userStepLog = new UserStepLog();
        userStepLog.setActivityId(request.getActivityId());
        userStepLog.setSteps(request.getSteps());
        //Should be from input or in service ??
        userStepLog.setEndAt(request.getEndAt());
        userStepLog.setUserId(request.getUserId());
        userStepLog.setStartAt(request.getStartAt());
        userStepLogRepository.save(userStepLog);
        //Should be in constant
        return "SUCCESS";
    }
}
