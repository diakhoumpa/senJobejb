package sn.groupeisi.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import sn.groupeisi.entities.Candidature;
import sn.groupeisi.repositiry.Icandidature;

@Stateless
public class CandidatureImpl extends RepositoryImpl<Candidature> implements Icandidature {
	
	@PersistenceContext(unitName="SenEuleuk")
	protected EntityManager em;

}
