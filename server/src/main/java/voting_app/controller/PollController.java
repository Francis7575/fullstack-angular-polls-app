package voting_app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import voting_app.request.Vote;
import voting_app.services.PollService;
import voting_app.voting_app_model.Poll;

@RestController
@RequestMapping("/api/polls")
@CrossOrigin(origins = "http://localhost:4200")
public class PollController {
  private final PollService pollService;

  public PollController(PollService pollService) {
    this.pollService = pollService;
  } 

  @PostMapping
  public ResponseEntity<Poll> createPoll(@RequestBody Poll poll) {
    try {
      Poll createdPoll = pollService.createPoll(poll);
      return ResponseEntity.status(201).body(createdPoll);
    } catch (Exception e) {
      e.printStackTrace(); 
      return ResponseEntity.status(500).build(); 
    }
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

  @PostMapping("/vote")
  public void vote(@RequestBody Vote vote) {
    pollService.vote(vote.getPollId(), vote.getOptionIndex());
  }
}
