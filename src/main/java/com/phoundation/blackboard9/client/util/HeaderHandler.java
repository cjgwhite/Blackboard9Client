package com.phoundation.blackboard9.client.util;

import com.phoundation.blackboard9.client.SessionHandler;
import com.sun.xml.wss.core.Timestamp;
import java.util.Set;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
 *
 * @author www.javadb.com
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {
            
    private Timestamp ts;
    private final long ONE_MINUTE = 60000;
    private final long WS_TIMEOUT = 120000;
    
    public boolean handleMessage(SOAPMessageContext smc) {

        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {

            SOAPMessage message = smc.getMessage();

            try {

                SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = envelope.addHeader();

                SOAPElement security =
                        header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");

                //SOAPElement timestamp = security.addChildElement("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Timestamp", "wsu");
                
                QName timeStampQName = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd", "Timestamp", "wsu");
                //SOAPElement timestamp = soapFactory.createElement(timeStampQName);

                SOAPElement timestamp = security.addChildElement(timeStampQName);
                
                if (ts == null) {
                    ts = new Timestamp(timestamp);
                    ts.setTimeout(WS_TIMEOUT + ONE_MINUTE);
                }

                // We need time in UTC...
                final long currentTimeUtc = System.currentTimeMillis() - TimeZone.getDefault().getRawOffset();
                ts.setCreated(Timestamp.calendarFormatter2.format(currentTimeUtc - ONE_MINUTE));
                ts.setExpires(Timestamp.calendarFormatter2.format(currentTimeUtc + WS_TIMEOUT));

                //security.addChildElement(ts.getAsSoapElement());
                
                SOAPElement usernameToken =
                        security.addChildElement("UsernameToken", "wsse");
                usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");

                SOAPElement username =
                        usernameToken.addChildElement("Username", "wsse");
                username.addTextNode("session");

                SOAPElement password =
                        usernameToken.addChildElement("Password", "wsse");
                password.setAttribute("Type", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText");
                password.addTextNode(SessionHandler.getPassword());


            } catch (Exception e) {
                e.printStackTrace();
            }

        } 
        


        return outboundProperty;

    }

    public Set getHeaders() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    public boolean handleFault(SOAPMessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

    public void close(MessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
