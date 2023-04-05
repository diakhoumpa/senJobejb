package sn.groupeisi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Recruteur implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String email;
	@Column
	private String password;
	@OneToMany( targetEntity=OffreEmploi.class, mappedBy="recruteur" )
    private List<OffreEmploi> mesoffres = new ArrayList<>();
	
	
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getFirstname() {return firstname;}
	public void setFirstname(String firstname) {this.firstname = firstname;}
	public String getLastname() {return lastname;}
	public void setLastname(String lastname) {this.lastname = lastname;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public List<OffreEmploi> getMesoffres() {return mesoffres;}
	public void setMesoffres(List<OffreEmploi> mesoffres) {this.mesoffres = mesoffres;}

}
