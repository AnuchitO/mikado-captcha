package com.thoughtworks.xconf.th.captcha;

public abstract class Operator {
    private final String symbol;

    public Operator(String symbol) {
        this.symbol = symbol;
    }

    static Operator multiply() {
        return new Multiply();
    }

    static Operator plus() {
        return new Plus();
    }

    static Operator minus() {
        return new Minus();
    }

    public String getSymbol() {
        return symbol;
    }

    public String display(Node leftOperand, Node rightOperand) {
        return leftOperand.display() + " " + this.symbol + " " + rightOperand.display();
    }

    public abstract Integer compute(Node left, Node right);

    private static class Plus extends Operator {
        public Plus() {
            super("+");
        }

        @Override
        public Integer compute(Node left, Node right) {
            return left.compute() + right.compute();
        }
    }

    private static class Minus extends Operator {
        public Minus() {
            super("-");
        }

        @Override
        public Integer compute(Node left, Node right) {
            return left.compute() - right.compute();
        }
    }
}
