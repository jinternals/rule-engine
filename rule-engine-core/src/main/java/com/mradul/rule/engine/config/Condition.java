package com.mradul.rule.engine.config;

/**
 * Created by mradul on 10/03/17.
 */
public class Condition {

    private String left;
    private String op;
    private String right;

    public Condition(){

    }


    public Condition(String left, String op, String right) {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
