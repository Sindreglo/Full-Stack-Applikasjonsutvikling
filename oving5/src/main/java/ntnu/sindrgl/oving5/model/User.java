package ntnu.sindrgl.oving5.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class User {
    private String password;
    @Id
    private String username;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Set<Expression> expressions;


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    /**
     * public Set<Expression> getExpressions() {
     *         return expressions;
     *     }
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
