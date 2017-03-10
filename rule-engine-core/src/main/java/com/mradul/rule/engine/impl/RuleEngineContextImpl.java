package com.mradul.rule.engine.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mradul.rule.engine.api.ExpressionExecutor;
import com.mradul.rule.engine.api.RuleEngineContext;
import com.mradul.rule.engine.config.RuleConfig;
import com.mradul.rule.engine.config.RulesConfig;
import com.mradul.rule.engine.exceptions.RuleEngineException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mradul on 09/03/17.
 */
public class RuleEngineContextImpl implements RuleEngineContext{
    private static final Logger logger = LoggerFactory.getLogger(JSExpressionExecutorImpl.class);

    private Map<String, Object> mapping = new HashMap<>();
    private RulesConfig rulesConfig;
    private ExpressionExecutor expressionExecutor;
    public RuleEngineContextImpl(ExpressionExecutor expressionExecutor){
        this.expressionExecutor = expressionExecutor;
    }


   public void loadRules(String path)throws RuleEngineException {
       try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(path).getFile());
            byte[] jsonData = Files.readAllBytes(Paths.get(file.toURI()));
            rulesConfig = objectMapper.readValue(jsonData, RulesConfig.class);
        }catch (Exception e){
           throw new RuleEngineException(e);
        }
    }

    public void put(String key,Object value) {
        mapping.put(key,value);
    }

    public boolean execute() throws RuleEngineException{
        logger.info("Executing rule set: {}",rulesConfig.getName());
        boolean res = true;
        Map<String,Boolean> results = new HashMap<>();
         try {
           for (RuleConfig ruleConfig:rulesConfig.getRules()) {
               logger.info("Executing rule: {} of rule set: {}",ruleConfig.getId(),rulesConfig.getName());
               Object result = expressionExecutor.execute(mapping,ruleConfig);
               if(result instanceof  Boolean && (Boolean)result)
               {
                   logger.info("Rule: {} executed successfully",ruleConfig.getId());
                   results.put(ruleConfig.getId(),true);
               }else
               {
                   logger.info("Rule: {} execution failed",ruleConfig.getId());
                   res = false;
                   results.put(ruleConfig.getId(),false);
               }
           }

           if(res)
           {
               logger.info("Rule set: {} executed successfully",rulesConfig.getName());
           }
           else {
               logger.info("Rule set: {} failed",rulesConfig.getName());
           }

             return res;
       }catch (Exception e){
           e.printStackTrace();
           throw new RuleEngineException(e);
       }
    }
}
