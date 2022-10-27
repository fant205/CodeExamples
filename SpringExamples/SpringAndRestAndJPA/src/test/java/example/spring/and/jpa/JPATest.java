package example.spring.and.jpa;

import example.spring.and.jpa.config.DesktopConfig;
import example.spring.and.jpa.dao.PersonalizationRepository;
import example.spring.and.jpa.model.Personalization;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class JPATest {

    private GenericApplicationContext ctx;
    private PersonalizationRepository personalizationRepository;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(DesktopConfig.class);
        personalizationRepository = ctx.getBean(PersonalizationRepository.class);
        assertNotNull(personalizationRepository);
    }

    @Test
//    @Ignore
    public void testFindAll() {
        List<Personalization> all = personalizationRepository.findAll();
        assertNotNull(all);
        assertTrue(all.size() > 0);
    }

    @After
    public void tearDown() {
        ctx.close();
    }
}
