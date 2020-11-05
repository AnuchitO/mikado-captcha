package com.thoughtworks.xconf.th.captcha;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NodeTest {

    @Test
    public void display_ValueNode_printsTheValue() {
        Node valueNode = GodNode.valueNode(1);
        assertEquals("1", valueNode.display());
    }

    @Test
    public void display_OperatorNode_printsTheEquation() {
        Node operatorNode = GodNode.opNode("+", GodNode.valueNode(1), GodNode.valueNode(2));
        assertEquals("1 + 2", operatorNode.display());
    }

    @Test
    public void display_complexOperatorNodes() {
        Node f = GodNode.opNode("*", GodNode.valueNode(2), GodNode.valueNode(5));
        Node g = GodNode.opNode("+", f, GodNode.valueNode(3));

        assertEquals("2 * 5 + 3", g.display());
    }

    @Test
    public void compute_ValueNode_givesTheValueBack() {
        Node valueNode = GodNode.valueNode(2);
        assertEquals(2, valueNode.compute().intValue());
    }

    @Test
    public void compute_OperatorNode_givesTheComputedResult() {
        Node opsNode = GodNode.opNode("-", GodNode.valueNode(5), GodNode.valueNode(3));
        assertEquals(2, opsNode.compute().intValue());
    }

    @Test
    public void compute_complexOperatorNodes() {
        Node f = GodNode.opNode("*", GodNode.valueNode(2), GodNode.valueNode(5));
        Node g = GodNode.opNode("+", f, GodNode.valueNode(3));

        assertEquals(13, g.compute().intValue());
    }
}
