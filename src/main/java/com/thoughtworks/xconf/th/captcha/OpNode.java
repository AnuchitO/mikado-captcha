package com.thoughtworks.xconf.th.captcha;

public class OpNode implements Node {

    private Operator operator;

    private Node leftOperand;
    private Node rightOperand;

    private OpNode(Operator operator, Node leftOperand, Node rightOperand) {
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public static Node valueNode(Integer value) {
        return new ValueNode(value);
    }

    public static Node opNode(Operator operator1, Node leftOperand, Node rightOperand) {
        return new OpNode(operator1, leftOperand, rightOperand);
    }

    @Override
    public Integer compute() {
        return this.operator.compute(leftOperand, rightOperand);
    }

    @Override
    public String display() {
        return this.operator.display(leftOperand, rightOperand);
    }

}
