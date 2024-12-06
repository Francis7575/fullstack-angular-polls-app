package voting_app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import voting_app.services.PollService;
import voting_app.voting_app_model.Poll;

@RestController
@RequestMapping("/api/polls")
public class PollController {
  private final PollService pollService;
  
  public PollController(PollService pollService) {
    this.pollService = pollService;
  }

  @PostMapping
  public Poll createPoll(@RequestBody Poll  poll) {
    return pollService.createPoll(poll);
  }
}
