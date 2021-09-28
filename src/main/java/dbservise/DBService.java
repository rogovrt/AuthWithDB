package dbservise;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;
import java.security.Provider;

public class DBService {

    private final SessionFactory sessionFactory;

    public DBService() {
        sessionFactory = createSessionFactory(getConfiguration());
    }

    private static Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(DataSet.class);

        String url = "jdbc:h2:./h2db";
        String name = "test";
        String pass = "test";

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.connection.username", name);
        configuration.setProperty("hibernate.connection.password", pass);
        configuration.setProperty("hibernate.show_sql", "false");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        return configuration;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public long add(String login, String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        DAO dao = new DAO(session);
        long id = dao.insert(login, password);
        transaction.commit();;
        session.close();
        return id;
    }

    public long getId(String login, String password) throws IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        DAO dao = new DAO(session);
        long id = dao.getId(login, password);
        transaction.commit();;
        session.close();
        return id;
    }
}
