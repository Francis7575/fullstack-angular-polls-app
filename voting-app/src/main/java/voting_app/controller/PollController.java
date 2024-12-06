package voting_app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping
  public List<Poll> getAllPolls() {
    return pollService.getAllPolls();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Poll> getPoll(@PathVariable Long id) {
    return pollService.getPollById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  
}
