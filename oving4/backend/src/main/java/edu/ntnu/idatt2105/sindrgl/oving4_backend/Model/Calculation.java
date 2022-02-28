package edu.ntnu.idatt2105.sindrgl.oving4_backend.Model;

public class Calculation {
    private String calculationString;
    private Object answer;

    public Calculation() {}

    public String getCalculation() {
        return calculationString;
    }

    public void setCalculationString(String calculationString) {
        this.calculationString = calculationString;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }
}
