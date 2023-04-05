package sn.groupeisi.entities;

import java.io.Serializable;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Candidature implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date dateCandidature;
	@ManyToOne
	@JoinColumn( name="Candidat_id",nullable=false)
	private Candidat candidats;
	
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public Date getDateCandidature() {return dateCandidature;}
	public void setDateCandidature(Date dateCandidature) {this.dateCandidature = dateCandidature;}
	public Candidat getCandidat() {return candidats;}
	public void setCandidat(Candidat candidats) {this.candidats = candidats;}
	//public OffreEmploi getOffreEmploi() {return offreEmploi;}
	//public void setOffreEmploi(OffreEmploi offreEmploi) {this.offreEmploi = offreEmploi;}
	
	

}
