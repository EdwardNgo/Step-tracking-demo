package steptracking.backend.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import steptracking.backend.demo.data.request.FinishActivityRequest;
import steptracking.backend.demo.data.response.UserStepMonthResponse;
import steptracking.backend.demo.data.response.UserStepWeekResponse;
import steptracking.backend.demo.service.UserStepService;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/userStep")
public class UserStepController {
    private final UserStepService userStepService;
    @PostMapping("/create")
    public ResponseEntity<String> saveActivity(@RequestBody FinishActivityRequest request) {
        return ResponseEntity.ok(userStepService.submitActivityResult(request));
    }

    @GetMapping("/{userId}/weekly")
    public ResponseEntity<UserStepWeekResponse> getUserStepWeekly(@PathVariable UUID userId,
                                                                  @RequestParam Integer week,
                                                                  @RequestParam Integer year){
        return ResponseEntity.ok(userStepService.getUserStepWeek(userId,week, year));
    }

    @GetMapping("/{userId}/monthly")
    public ResponseEntity<UserStepMonthResponse> getUserStepMonthly(@PathVariable UUID userId,
                                                                   @RequestParam Integer month,
                                                                   @RequestParam Integer year){
        return ResponseEntity.ok(userStepService.getUserStepMonth(userId,month, year));
    }
}
