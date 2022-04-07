package edu.ntnu.idatt2105.sindrgl.oving4_backend.Service;

import edu.ntnu.idatt2105.sindrgl.oving4_backend.Model.Calculation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public Calculation calculate(Calculation calculation){
        String expression = calculation.getCalculation();

        String operators[]=expression.split("[0-9]+");
        String operands[]=expression.split("[+-/*]");
        int agregate = Integer.parseInt(operands[0]);
        for (int i = 1; i < operands.length; i++){
            if (operators[i].equals("+")){
                agregate += Integer.parseInt(operands[i]);
            } else if (operators[i].equals("-")){
                agregate -= Integer.parseInt(operands[i]);
            } else if (operators[i].equals("*")){
                agregate *= Integer.parseInt(operands[i]);
            } else if (operators[i].equals("/")){
                agregate /= Integer.parseInt(operands[i]);
            } else {
                logger.warn("calculation cannot be solved.");
            }
        }
        calculation.setAnswer(agregate);
        return calculation;
    }
}
