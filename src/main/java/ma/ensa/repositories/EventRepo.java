package ma.ensa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ma.ensa.entities.ConferenceEvent;

public interface EventRepo extends JpaRepository<ConferenceEvent, Long> {

}
