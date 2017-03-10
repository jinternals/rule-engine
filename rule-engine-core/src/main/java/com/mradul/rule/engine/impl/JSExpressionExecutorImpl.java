package com.mradul.rule.engine.impl;

import com.mradul.rule.engine.api.ExpressionExecutor;
import com.mradul.rule.engine.config.Condition;
import com.mradul.rule.engine.config.RuleConfig;
import com.mradul.rule.engine.exceptions.RuleEngineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.*;
import java.util.Map;

/**
 * Created by mradul on 09/03/17.
 */
public class JSExpressionExecutorImpl implements ExpressionExecutor{


    private static final Logger logger = LoggerFactory.getLogger(JSExpressionExecutorImpl.class);

    public  Object execute(Map<String,Object> metaData, RuleConfig ruleConfig) throws RuleEngineException {
        logger.info("Executing rule: {}",ruleConfig.getId());
        try {
          ScriptEngineManager factory = new ScriptEngineManager();
          ScriptEngine engine = factory.getEngineByName("JavaScript");
          Bindings bindings = engine.getBindings(ScriptContext.GLOBAL_SCOPE);

          metaData.forEach((k, v) -> {
              logger.info("Binding {} for rule: {}",k,ruleConfig.getId());
              bindings.put(k, v);
          });

          return engine.eval(ruleConfig.getCondition().getLeft()+" "+ruleConfig.getCondition().getOp()+" "+ruleConfig.getCondition().getRight(), bindings);

      }catch (Exception e){
          throw new RuleEngineException(e.getMessage(),e);
      }
    }
}
