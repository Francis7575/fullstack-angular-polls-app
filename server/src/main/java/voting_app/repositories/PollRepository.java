package voting_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voting_app.voting_app_model.Poll;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long>{

}