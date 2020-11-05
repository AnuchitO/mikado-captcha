package com.thoughtworks.xconf.th.captcha;

class Minus extends Operator {
    public Minus() {
        super("-");
    }

    @Override
    public Integer compute(Node left, Node right) {
        return left.compute() - right.compute();
    }
}
