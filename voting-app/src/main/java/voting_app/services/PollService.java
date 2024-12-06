package voting_app.services;

import org.springframework.stereotype.Service;

import voting_app.repositories.PollRepository;
import voting_app.voting_app_model.Poll;

@Service
public class PollService {

  private final PollRepository pollRepository;

  public PollService(PollRepository pollRepository) {
    this.pollRepository = pollRepository;
  }

  public Poll createPoll (Poll poll) {
    return pollRepository.save(poll);
  }
}
