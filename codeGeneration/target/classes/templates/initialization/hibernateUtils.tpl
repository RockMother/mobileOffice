package ${settings.utilsPackageName};

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
    !!!! AUTOGENERATED !!!!!
*/
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
            <#list model as table>
            cfg.addResource("hibernate/${table.className}.hbm.xml");
            </#list>
            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
