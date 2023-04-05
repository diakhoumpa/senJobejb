package sn.groupeisi.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import sn.groupeisi.entities.OffreEmploi;
import sn.groupeisi.repositiry.Ioffreemploi;

@Stateless
public class OffreemploiImpl extends RepositoryImpl<OffreEmploi>implements Ioffreemploi {
	
	@PersistenceContext(unitName="SenEuleuk")
	protected EntityManager em;

}
