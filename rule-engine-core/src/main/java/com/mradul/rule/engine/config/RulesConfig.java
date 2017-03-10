package com.mradul.rule.engine.config;

import java.util.List;

/**
 * Created by mradul on 09/03/17.
 */
public class RulesConfig {

    private String name;

    private List<RuleConfig> rules;

    public RulesConfig(){}

    public RulesConfig(String name,List<RuleConfig> rules){
        this.name = name;
        this.rules = rules;
    }

    public List<RuleConfig> getRules() {
        return rules;
    }

    public void setRules(List<RuleConfig> rules) {
        this.rules = rules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
