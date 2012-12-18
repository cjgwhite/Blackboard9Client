package com.phoundation.blackboard9.client;

/**
 *
 * @author chris
 */
public class SessionHandler {
    private static ThreadLocal<String> sessionPassword = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "nosession";
        }
    };
    
    public static String getPassword() {
        return sessionPassword.get();
    }
    
    public static void setPassword(String pw) {
        sessionPassword.set(pw);
    }
    
    public static void reset() {
        sessionPassword.remove();
    }
}
