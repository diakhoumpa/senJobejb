package sn.groupeisi.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sn.groupeisi.entities.Categoriesoffres;
import sn.groupeisi.repositiry.Icategoriesoffres;

@Stateless
public class CategoriesOffresImpl extends RepositoryImpl<Categoriesoffres> implements Icategoriesoffres {
	
	@PersistenceContext(unitName="SenEuleuk")
	protected EntityManager em;

}
