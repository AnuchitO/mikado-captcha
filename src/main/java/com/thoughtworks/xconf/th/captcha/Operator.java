package com.thoughtworks.xconf.th.captcha;

public abstract class Operator {
    private final String symbol;

    public Operator(String symbol) {
        this.symbol = symbol;
    }

    static Operator multiply() {
        return new Operator("*") {
            @Override
            public Integer compute(Node left, Node right) {
                return left.compute() * right.compute();
            }
        };
    }

    static Operator plus() {
        return new Operator("+") {
            @Override
            public Integer compute(Node left, Node right) {
                return left.compute() + right.compute();
            }
        };
    }

    static Operator minus() {
        return new Operator("-") {
            @Override
            public Integer compute(Node left, Node right) {
                return left.compute() - right.compute();
            }
        };
    }

    public String getSymbol() {
        return symbol;
    }

    public String display(Node leftOperand, Node rightOperand) {
        return leftOperand.display() + " " + this.symbol + " " + rightOperand.display();
    }

    public abstract Integer compute(Node left, Node right);
}
