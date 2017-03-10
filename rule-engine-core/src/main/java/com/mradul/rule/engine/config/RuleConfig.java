package com.mradul.rule.engine.config;

import java.util.List;

/**
 * Created by mradul on 09/03/17.
 */
public class RuleConfig {

    private String id;
    private Condition condition;
    private String action;

    public RuleConfig() {
    }

    public RuleConfig(String id, Condition condition, String action) {
        this.id = id;
        this.condition = condition;
        this.action = action;
    }

    public String getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
