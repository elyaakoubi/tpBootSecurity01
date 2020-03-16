package ma.ensa.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ma.ensa.entities.Conference;
import ma.ensa.entities.ConferenceEvent;

public interface IConfService {
	Conference save(Conference conference);
	   List<Conference> findAll();
	   Conference findByIdConference(Long idConference);
	   Conference findByTitle(String title);
	   void delete(Conference conference);
	   List<ConferenceEvent> findEventsById(Long idConference);
}
