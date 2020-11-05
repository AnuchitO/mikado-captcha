package com.thoughtworks.xconf.th.captcha;

class Multiply extends Operator {
    public Multiply() {
        super("*");
    }

    @Override
    public Integer compute(Node left, Node right) {
        return left.compute() * right.compute();
    }
}
