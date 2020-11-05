package com.thoughtworks.xconf.th.captcha;

public class GodNode extends ValueNode implements Node {

    private String operator = "#";

    private Node leftOperand;
    private Node rightOperand;

    private GodNode(String operator, Node leftOperand, Node rightOperand) {
        super(0);
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    private GodNode(Integer value) {
        super(value);
    }

    public static Node valueNode(Integer value) {
        return new GodNode(value);
    }

    public static Node opNode(String operator, Node leftOperand, Node rightOperand) {
        return new GodNode(operator, leftOperand, rightOperand);
    }

    @Override
    public Integer compute() {
        switch (this.operator) {
            case "+" : return leftOperand.compute() + rightOperand.compute();
            case "-" : return leftOperand.compute() - rightOperand.compute();
            case "*" : return leftOperand.compute() * rightOperand.compute();
            case "#" : return this.value;
            default  : throw new UnsupportedOperationException();
        }
    }

    @Override
    public String display() {
        switch (this.operator) {
            case "+" : return leftOperand.display() + " + " + rightOperand.display();
            case "-" : return leftOperand.display() + " - " + rightOperand.display();
            case "*" : return leftOperand.display() + " * " + rightOperand.display();
            case "#" : return this.value + "";
            default  : throw new UnsupportedOperationException();
        }
    }

}
