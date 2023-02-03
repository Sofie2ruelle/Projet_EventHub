package fr.dawan.eventhub.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String type;
	
	private String titre;
	private String description;
	private String resume;
	private LocalDateTime date_event;
	private String lieu;
	private Double prix;
	
	@ManyToOne
	private User user;
	
	
	
	public Event() {
		super();
		
	}
	
	public Event(String type, String titre, String description, String resume, LocalDateTime date_event, String lieu,
			Double prix) {
		super();
		this.type = type;
		this.titre = titre;
		this.description = description;
		this.resume = resume;
		this.date_event = date_event;
		this.lieu = lieu;
		this.prix = prix;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public LocalDateTime getDate_event() {
		return date_event;
	}
	public void setDate_event(LocalDateTime date_event) {
		this.date_event = date_event;
	}
	
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	

}
