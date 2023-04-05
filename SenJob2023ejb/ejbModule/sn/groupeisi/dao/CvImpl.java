package sn.groupeisi.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import sn.groupeisi.entities.Cv;
import sn.groupeisi.repositiry.Icv;

@Stateless
public class CvImpl extends RepositoryImpl<Cv>implements Icv {
	
	@PersistenceContext(unitName="SenEuleuk")
	protected EntityManager em;

}
