/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phoundation.blackboard9.client.exception;

/**
 *
 * @author mfgsscw2
 */
public class BlackboardTimeOutException extends Exception {

    public BlackboardTimeOutException() {
    }

    public BlackboardTimeOutException(String message) {
        super(message);
    }

    public BlackboardTimeOutException(Throwable cause) {
        super(cause);
    }

    public BlackboardTimeOutException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
