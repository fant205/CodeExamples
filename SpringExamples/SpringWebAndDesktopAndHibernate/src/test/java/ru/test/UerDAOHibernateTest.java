package ru.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import ru.config.DesktopConfig;
import ru.test.dao.UerDAO;
import ru.test.model.Material;


public class UerDAOHibernateTest {
	
    private static final Logger LOG = LogManager.getLogger(UerDAOHibernateTest.class);
	
	private GenericApplicationContext applicationContext;
	private UerDAO mtrLiteDAO;

	@Before
	public void setUp() {

		applicationContext = new AnnotationConfigApplicationContext(DesktopConfig.class);
		mtrLiteDAO = applicationContext.getBean(UerDAO.class);
		assertNotNull(mtrLiteDAO);
	}

	@Test
	public void findGidsTest() {

		List<Material> list = mtrLiteDAO.findByShortName("Уголь");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Material material = (Material) iterator.next();
			LOG.debug(material.toString());
		}
		assertTrue(list.size() > 0);
	}
}