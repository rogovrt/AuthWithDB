package dbservise;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;

public class DAO {

    private final Session session;

    public DAO(Session session) {
        this.session = session;
    }

    public long getId(String login, String password) throws IOException {
        Criteria criteria = session.createCriteria(DataSet.class);
        Criterion criterion = Restrictions.and(Restrictions.eq("login", login), Restrictions.eq("password", password));
        Object user = criteria.add(criterion).uniqueResult();
        if (user != null) {
            return ((DataSet)user).getId();
        }
        else throw new IOException("Wrong login or password was passed\n");
    }

    public long insert(String login, String password) {
        return (Long) session.save(new DataSet(login, password));
    }
}
