package com.thoughtworks.xconf.th.captcha;

public class OpNode implements Node {

    private String operator = "#";

    private Node leftOperand;
    private Node rightOperand;

    private OpNode(String operator, Node leftOperand, Node rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public static Node valueNode(Integer value) {
        return new ValueNode(value);
    }

    public static Node opNode(String operator, Node leftOperand, Node rightOperand) {
        return new OpNode(operator, leftOperand, rightOperand);
    }

    @Override
    public Integer compute() {
        switch (this.operator) {
            case "+" : return leftOperand.compute() + rightOperand.compute();
            case "-" : return leftOperand.compute() - rightOperand.compute();
            case "*" : return leftOperand.compute() * rightOperand.compute();
            default  : throw new UnsupportedOperationException();
        }
    }

    @Override
    public String display() {
        switch (this.operator) {
            case "+" : return leftOperand.display() + " + " + rightOperand.display();
            case "-" : return leftOperand.display() + " - " + rightOperand.display();
            case "*" : return leftOperand.display() + " * " + rightOperand.display();
            default  : throw new UnsupportedOperationException();
        }
    }

}
