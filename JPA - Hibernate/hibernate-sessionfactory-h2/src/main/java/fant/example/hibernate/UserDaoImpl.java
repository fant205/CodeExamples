package fant.example.hibernate;

import org.hibernate.Session;

import java.util.List;

public class UserDaoImpl implements UserDao{

    private SessionFactoryUtils sessionFactoryUtils;

    public UserDaoImpl(SessionFactoryUtils sessionFactoryUtils){
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public User findById(Long id) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.getTransaction().commit();
            return user;
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<User> users = session.createQuery("select u from User u").getResultList();
            session.getTransaction().commit();
            return users;
        }
    }

    @Override
    public User findByName(String name) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            User users = session.createQuery("select u from User u where u.name = :name", User.class)
                    .setParameter("name", name)
                    .getSingleResult();
            session.getTransaction().commit();
            return users;
        }
    }

    @Override
    public void save(User user) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Long id, String name) {
        try (Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            User user = session.get(User.class, id);
            user.setName(name);
            session.getTransaction().commit();
        }
    }

    @Override
    public void testCache() {
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(User.class, 1L);
            session.get(User.class, 1L);
            session.get(User.class, 1L);
            session.getTransaction().commit();
        }
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            session.get(User.class, 1L);
            session.get(User.class, 1L);
            session.get(User.class, 1L);
            session.getTransaction().commit();
        }
    }


}
