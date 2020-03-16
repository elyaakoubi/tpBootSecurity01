package ma.ensa.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ConferenceEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConferenceEvent;
	private String subTitle;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "idConference")
	private Conference conference;
	
	public ConferenceEvent() {
		super();
	}
	public ConferenceEvent(String subTitle, Date date) {
		super();
		this.subTitle = subTitle;
		this.date = date;
	}
	public Long getIdConferenceEvent() {
		return idConferenceEvent;
	}
	public void setIdConferenceEvent(Long idConferenceEvent) {
		this.idConferenceEvent = idConferenceEvent;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Conference getConference() {
		return conference;
	}
	public void setConference(Conference conference) {
		this.conference = conference;
	}
	
	
	
	
	
}
