package sn.groupeisi.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import sn.groupeisi.entities.Recruteur;
import sn.groupeisi.repositiry.Irecruteur;

@Stateless
public class RecruteurImpl extends RepositoryImpl<Recruteur>implements Irecruteur{
	
	@PersistenceContext(unitName="SenEuleuk")
	protected EntityManager em;

}
