package com.mradul.rule.engine.condition;

import com.mradul.rule.Person;
import com.mradul.rule.engine.api.RuleEngineContext;
import com.mradul.rule.engine.exceptions.RuleEngineException;
import com.mradul.rule.engine.impl.JSExpressionExecutorImpl;
import com.mradul.rule.engine.impl.RuleEngineContextImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mradul on 09/03/17.
 */
public class ConditionExecutorTest {
    Person person = new Person(25,"Mradul Pandey");

    @Test
    public void execute() throws RuleEngineException {
        RuleEngineContext context = new RuleEngineContextImpl(new JSExpressionExecutorImpl());
        context.loadRules("rules.json");
        context.put("person",person);
       Boolean result = context.execute();
        Assert.assertEquals(true,result);
    }

}