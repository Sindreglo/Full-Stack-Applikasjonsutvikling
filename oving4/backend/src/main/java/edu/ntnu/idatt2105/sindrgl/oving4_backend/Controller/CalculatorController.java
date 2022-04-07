package edu.ntnu.idatt2105.sindrgl.oving4_backend.Controller;

import edu.ntnu.idatt2105.sindrgl.oving4_backend.Model.Calculation;
import edu.ntnu.idatt2105.sindrgl.oving4_backend.Service.CalculatorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @PostMapping("/calculation")
    public Calculation postCalculation(@RequestBody Calculation calculation){

        logger.trace("PostMapping");

        return calculatorService.calculate(calculation);
    }
}
