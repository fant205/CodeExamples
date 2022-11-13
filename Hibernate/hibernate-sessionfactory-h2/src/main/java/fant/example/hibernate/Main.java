package fant.example.hibernate;

public class Main {

    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
            try {
                UserDao userDao = new UserDaoImpl(sessionFactoryUtils);
                System.out.println(userDao.findById(1L));
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                sessionFactoryUtils.shotdown();
            }
    }
}
