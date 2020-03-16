package ma.ensa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.ensa.entities.Conference;
import ma.ensa.entities.ConferenceEvent;

public interface ConfRepo extends JpaRepository<Conference, Long> {
	
   Conference save(Conference conference);
   List<Conference> findAll();
   Conference findByIdConference(Long idConference);
   Conference findByTitle(String title);
   void delete(Conference conference);
   @Query("select ev from ConferenceEvent ev where ev.conference.idConference =:idConference ")
   List<ConferenceEvent> findEventsById(@Param("idConference")Long idConference);
   
	

}
