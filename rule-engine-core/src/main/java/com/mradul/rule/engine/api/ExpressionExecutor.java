package com.mradul.rule.engine.api;

import com.mradul.rule.engine.config.Condition;
import com.mradul.rule.engine.config.RuleConfig;
import com.mradul.rule.engine.exceptions.RuleEngineException;

import java.util.Map;

/**
 * Created by mradul on 09/03/17.
 */
public interface ExpressionExecutor {

    public Object execute(Map<String,Object> metaData, RuleConfig ruleConfig) throws RuleEngineException;

}
