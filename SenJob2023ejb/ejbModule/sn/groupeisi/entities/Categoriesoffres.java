package sn.groupeisi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Categoriesoffres implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@ManyToMany
    @JoinTable( name = "OffreEmploi_Categoriesoffres",
                         joinColumns = @JoinColumn( name = "idCategoriesoffres" ),
                         inverseJoinColumns = @JoinColumn( name = "idOffreEmploi" ) )
    private List<OffreEmploi> offreEmploi = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<OffreEmploi> getOffreEmploi() {
		return offreEmploi;
	}
	public void setOffreEmploi(List<OffreEmploi> offreEmploi) {
		this.offreEmploi = offreEmploi;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
	
}
