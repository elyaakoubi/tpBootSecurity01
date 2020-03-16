package ma.ensa.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.lang.NonNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Conference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConference;
    private String title;
	private String subject;
	@OneToMany(mappedBy = "conference",fetch=FetchType.LAZY)
	@JsonIgnore
	List<ConferenceEvent> events;

	public Conference() {
		super();
	}	
	
	public Conference(String title, String subject) {
		super();
		this.title = title;
		this.subject = subject;
	}

	public Long getIdConference() {
		return idConference;
	}
	
	public void setIdConference(Long idConference) {
		this.idConference = idConference;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<ConferenceEvent> getEvents() {
		return events;
	}

	public void setEvents(List<ConferenceEvent> events) {
		this.events = events;
	}
	
}
