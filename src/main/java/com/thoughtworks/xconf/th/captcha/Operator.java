package com.thoughtworks.xconf.th.captcha;

public class Operator {
    private final String symbol;

    public Operator(String symbol) {
        this.symbol = symbol;
    }

    static Operator multiply() {
        return new Operator("*");
    }

    static Operator plus() {
        return new Operator("+");
    }

    static Operator minus() {
        return new Operator("-");
    }

    public String getSymbol() {
        return symbol;
    }

    public String display(Node leftOperand, Node rightOperand) {
        return leftOperand.display() + " " + this.symbol + " " + rightOperand.display();
    }
}
