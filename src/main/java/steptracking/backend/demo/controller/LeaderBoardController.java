package steptracking.backend.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import steptracking.backend.demo.data.domain.LeaderBoardFilter;
import steptracking.backend.demo.data.response.UserStepResult;
import steptracking.backend.demo.data.response.UserStepWeekResponse;
import steptracking.backend.demo.service.LeaderBoardService;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/leaderBoard")
public class LeaderBoardController {

    private final LeaderBoardService leaderBoardService;
    //TODO: need to look about date
    @GetMapping("/weekly")
    public ResponseEntity<Page<UserStepResult>> geLeaderBoardDaily(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                                                                  @RequestParam(defaultValue = "0") Integer page,
                                                                  @RequestParam(defaultValue = "10") Integer limit){
        return ResponseEntity.ok(leaderBoardService.getUserLeaderBoardDaily(page,limit, date));
    }
}
