package voting_app.voting_app_model;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
public class Poll {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String question;

  @ElementCollection
  private List<String> options = new ArrayList<>();

  @ElementCollection
  private List<Long> votes = new ArrayList<>();
}
