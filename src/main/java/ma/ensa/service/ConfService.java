package ma.ensa.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.ensa.entities.Conference;
import ma.ensa.entities.ConferenceEvent;
import ma.ensa.repositories.ConfRepo;

@Service
public class ConfService implements IConfService{
	
	Logger logger = Logger.getLogger("ma");

	@Autowired
	ConfRepo confRepo;

	@Override
	public Conference save(Conference conference) {
		logger.info("entité");
		return confRepo.save(conference);
	}

	@Override
	public List<Conference> findAll() {
		// TODO Auto-generated method stub
		return confRepo.findAll();
	}

	@Override
	public Conference findByIdConference(Long idConference) {
		// TODO Auto-generated method stub
		return confRepo.findByIdConference(idConference);
	}

	@Override
	public Conference findByTitle(String title) {
		// TODO Auto-generated method stub
		return confRepo.findByTitle(title);
	}

	@Override
	public void delete(Conference conference) {
		confRepo.delete(conference);		
	}

	@Override
	public List<ConferenceEvent> findEventsById(Long idConference) {
		// TODO Auto-generated method stub
		return confRepo.findEventsById(idConference);
	}

}
