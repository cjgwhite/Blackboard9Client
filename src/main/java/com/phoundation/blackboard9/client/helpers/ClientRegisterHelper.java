/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phoundation.blackboard9.client.helpers;

import com.blackboard.context.ContextWSPortType;
import java.util.List;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.phoundation.blackboard9.client.ClientWrapper;

/**
 *
 * @author Chris White <christopher.white@manchester.ac.uk>
 */
public class ClientRegisterHelper {
    
   
    private String registerPw;
    
    public void setRegisterPw(String pw) {
        registerPw = pw;
    }

    private List<String> methods;
    public void setMethods(List<String> methods) {
        this.methods = methods;
    }
    public List<String> getMethods() {
        return methods;
    }
    
    private String description;
    public void setApplicationDescription(String desc) {
        description = desc;
    }
    public String getDescription() {
        return description;
    }
    
    
    private String endPointUrl;
    public void setEndPointUrl(String url) {
        endPointUrl = url;
    }
    
    private String vendorId;
    public void setVendorId(String vendId) {
        vendorId = vendId;
    }
    
    private String programId;
    public void setProgramId(String progId) {
        programId = progId;
    }
    
    private String sharedSecret = RandomStringUtils.randomAscii(18);
    public void setSharedSecret(String secret) {
        sharedSecret = secret;
    }
    
    private ClientWrapper client;
    public void setClient(ClientWrapper client) {
        this.client = client;
    }
    
    private ContextWSPortType context;
    @Autowired
    public void setContextWS(ContextWSPortType port) {
        context = port;
    }
    
    public boolean registerTool() throws Exception {
        
        ClientWrapper client = new ClientWrapper();
        client.setPassword(sharedSecret);
        client.setProgramId(programId);
        client.setVendorId(vendorId);
        client.setContextPortType(context);
        
        client.initSession();

        return client.registerTool(registerPw, description, methods, null);
    }
    
}
