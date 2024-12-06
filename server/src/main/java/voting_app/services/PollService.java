package voting_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import voting_app.repositories.PollRepository;
import voting_app.voting_app_model.OptionVote;
import voting_app.voting_app_model.Poll;

@Service
public class PollService {

  private final PollRepository pollRepository;

  public PollService(PollRepository pollRepository) {
    this.pollRepository = pollRepository;
  }

  public Poll createPoll(Poll poll) {
    return pollRepository.save(poll);
  }

  public List<Poll> getAllPolls() {
    return pollRepository.findAll();
  }

  public Optional<Poll> getPollById(Long id) {
    return pollRepository.findById(id);
  }

  public void vote (Long pollId, int optionIndex) {
    // Get poll from DB
    Poll poll = pollRepository.findById(pollId)
          .orElseThrow(() -> new RuntimeException("Poll not found"));
    // Get All options
    List<OptionVote> options = poll.getOptions();
    // If index for vote is not valid, throw error
    if (optionIndex < 0 || optionIndex >= options.size()) {
      throw new IllegalArgumentException("Invalid option index");
    }
    // Get selected option
    OptionVote selectedOption = options.get(optionIndex);
    // Increment vote for selected option 
    selectedOption.setVoteCount(selectedOption.getVoteCount() + 1);
    // Save incremented option into the database
    pollRepository.save(poll);
  }
}