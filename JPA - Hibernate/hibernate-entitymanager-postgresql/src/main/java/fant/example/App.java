package fant.example;

import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        // Получаем фабрику менеджеров сущностей
        EntityManagerFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // Из фабрики создаем EntityManager
        EntityManager em = factory.createEntityManager();
        Person person = new Person("Ivan", "Ivanov");
        // Открываем транзакцию
        em.getTransaction().begin();
        // Create (сохраняем в базе данных, и благодаря этому сущность
        // становится управляемой Hibernate и заносится в контекст постоянства)
        em.persist(person);
        // Подтверждаем транзакцию
        em.getTransaction().commit();
        em.getTransaction().begin();
        // Read (читаем сущность из базы данных по id)
        Person anotherPerson = em.find(Person.class, 1L);
        em.getTransaction().commit();
        anotherPerson.setFirstname("Artem");
        em.getTransaction().begin();
        // Update
        em.merge(anotherPerson);
        em.getTransaction().commit();
    }
}
