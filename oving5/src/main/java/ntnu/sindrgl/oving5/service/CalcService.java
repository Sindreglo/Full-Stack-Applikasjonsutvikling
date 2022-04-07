package ntnu.sindrgl.oving5.service;

import ntnu.sindrgl.oving5.model.Expression;
import org.springframework.stereotype.Service;

@Service
public class CalcService {
    public Expression calculate(Expression inputExpression) {
        String expression = inputExpression.getExpression();
        String operators[]=expression.split("[0-9]+");
        String operands[]=expression.split("[+-/*]");
        int answer = Integer.parseInt(operands[0]);
        for (int i = 1; i < operands.length; i++){
            if (operators[i].equals("+")){
                answer += Integer.parseInt(operands[i]);
            } else if (operators[i].equals("-")){
                answer -= Integer.parseInt(operands[i]);
            } else if (operators[i].equals("*")){
                answer *= Integer.parseInt(operands[i]);
            } else if (operators[i].equals("/")){
                answer /= Integer.parseInt(operands[i]);
            }
        }
        inputExpression.setAnswer(String.valueOf(answer));
        return inputExpression;
    }
}
