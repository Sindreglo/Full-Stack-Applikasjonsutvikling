package ntnu.sindrgl.oving5.controller;

import ntnu.sindrgl.oving5.model.Expression;
import ntnu.sindrgl.oving5.repository.ExpressionRepo;
import ntnu.sindrgl.oving5.service.CalcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ExpressionController {
    ArrayList<Expression> arrayList = new ArrayList<>();

    public ExpressionController(){
    }

    @Autowired
    private CalcService service;
    @Autowired
    private ExpressionRepo expressionRepo;

    @GetMapping("/header")
    public String hello() {
        return "Calculator Application";
    }

    Logger logger = LoggerFactory.getLogger(ExpressionController.class);

    @PostMapping("/calculate")
    public Object postExpression(@RequestBody Expression expression, HttpServletRequest request) {
        arrayList.add(expression);
        logger.info("Calculating...");
        Expression calculatedExpression = service.calculate(expression);
        expression.setUsername(request.getUserPrincipal().getName());
        expressionRepo.save(expression);
        return calculatedExpression;
    }

    @GetMapping("/calculate")
    public Object getAnswer() {
        return arrayList.get(arrayList.size()-1).getAnswer();
    }

    @GetMapping("/expressions")
    public Object getExpressions(HttpServletRequest request){
        arrayList = (ArrayList<Expression>) expressionRepo.findAll();
        ArrayList<Expression> userExpressions = new ArrayList<>();
        for (int i = 0; i<arrayList.size(); i++){
            if (arrayList.get(i).getUsername().equals(request.getRemoteUser())){
                userExpressions.add(arrayList.get(i));
            }
        }
        return userExpressions;
    }

}
