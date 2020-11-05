package com.thoughtworks.xconf.th.captcha;

public class Node {

    private String operator = "#";
    private Integer value = 0;

    private Node leftOperand;
    private Node rightOperand;

    private Node(String operator, Node leftOperand, Node rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    private Node(Integer value) {
        this.value = value;
    }

    public static Node valueNode(Integer value) {
        return new Node(value);
    }

    public static Node opNode(String operator, Node leftOperand, Node rightOperand) {
        return new Node(operator, leftOperand, rightOperand);
    }

    public Integer compute() {
        switch (this.operator) {
            case "+" : return leftOperand.compute() + rightOperand.compute();
            case "-" : return leftOperand.compute() - rightOperand.compute();
            case "*" : return leftOperand.compute() * rightOperand.compute();
            case "#" : return this.value;
            default  : throw new UnsupportedOperationException();
        }
    }

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
