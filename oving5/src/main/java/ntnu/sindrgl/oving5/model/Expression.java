package ntnu.sindrgl.oving5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Expression {
    @Id
    @GeneratedValue
    private int expression_id;
    private String expression;
    private String answer;
    private String username;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "username", insertable = false, updatable = false)
    private User user;


    public Expression(){
    }

    public User getUser() {
        return user;
    }

    public String getExpression() {
        return expression;
    }

    public String getAnswer() {
        return answer;
    }

    public int getExpression_id() {
        return expression_id;
    }

    public String getUsername() {
        return username;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
