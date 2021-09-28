package dbservise;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name = "users")
public class DataSet implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name = "password", unique = true, updatable = true)
    private String password;

    @SuppressWarnings("UnusedDeclaration")
    public DataSet() {
    }

    @SuppressWarnings("UnusedDeclaration")
    public DataSet(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }
}
