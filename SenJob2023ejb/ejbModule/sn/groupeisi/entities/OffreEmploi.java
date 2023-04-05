package sn.groupeisi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class OffreEmploi implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String titre;
	@Column
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateExpiration;
	@ManyToOne  
	@JoinColumn( name="idRecruteur" )
    private Recruteur recruteur;
	@ManyToMany
    @JoinTable( name = "OffreEmploi_Categoriesoffres",
                         joinColumns = @JoinColumn( name = "idOffreEmploi" ),
                         inverseJoinColumns = @JoinColumn( name = "idCategoriesoffres" ) )
    private List<Categoriesoffres> categoriesoffres = new ArrayList<>();
	
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getTitre() {return titre;}
	public void setTitre(String titre) {this.titre = titre;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public Date getDateExpiration() {return dateExpiration;}
	public void setDateExpiration(Date dateExpiration) {this.dateExpiration = dateExpiration;}
	public Recruteur getRecruteur() {return recruteur;}
	public void setRecruteur(Recruteur recruteur) {this.recruteur = recruteur;}
	

	public List<Categoriesoffres> getCategoriesoffres() {return categoriesoffres;}
	public void setCategoriesoffres(List<Categoriesoffres> categoriesoffres) {this.categoriesoffres = categoriesoffres;}
	
	
	
}
