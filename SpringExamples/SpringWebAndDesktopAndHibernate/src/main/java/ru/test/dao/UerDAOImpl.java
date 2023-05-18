package ru.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.test.model.Material;

@Service
@Transactional
@Repository("UerDAO")
public class UerDAOImpl implements UerDAO {

	private SessionFactory sessionFactory;

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Material> findByShortName(String shortName) {

		String hsql = "select m from Material m where m.shortName like :shortName";

//		getSessionFactory().getCurrentSession().setJdbcBatchSize(1);
		Query query = getSessionFactory().getCurrentSession().createQuery(hsql, Material.class);

		query.setParameter("shortName", "%" + shortName + "%");

		List result = query.list();
		return result;

	}

	// @PersistenceContext
	// private EntityManager em;
	//
	// @Override
	// @Transactional(readOnly = true)
	// public List<Material> findByShortName(String shortName) {
	//
	// em.setProperty("hibernate.jdbc.fetch_size", 1);
	// String hsql = "select m from Material m where m.shortName like :shortName";
	// TypedQuery<Material> query = em.createQuery(hsql, Material.class);
	// query.setParameter("shortName", "%" + shortName + "%");
	// return query.getResultList();
	// }
}
