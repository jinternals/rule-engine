package com.mradul.rule.engine.api;

import com.mradul.rule.engine.config.RulesConfig;
import com.mradul.rule.engine.exceptions.RuleEngineException;

import java.util.Map;

/**
 * Created by mradul on 09/03/17.
 */
public interface RuleEngineContext {

    void loadRules(String path) throws RuleEngineException;

    void put(String key,Object value);

    boolean execute() throws RuleEngineException;


}
