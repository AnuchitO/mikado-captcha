package com.thoughtworks.xconf.th.captcha;

class Plus extends Operator {
    public Plus() {
        super("+");
    }

    @Override
    public Integer compute(Node left, Node right) {
        return left.compute() + right.compute();
    }
}
