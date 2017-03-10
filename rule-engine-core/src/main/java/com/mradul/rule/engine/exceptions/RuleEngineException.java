package com.mradul.rule.engine.exceptions;

/**
 * Created by mradul on 09/03/17.
 */
public class RuleEngineException extends Exception {

    public RuleEngineException() {
    }

    public RuleEngineException(String message) {
        super(message);
    }

    public RuleEngineException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuleEngineException(Throwable cause) {
        super(cause);
    }

    public RuleEngineException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
