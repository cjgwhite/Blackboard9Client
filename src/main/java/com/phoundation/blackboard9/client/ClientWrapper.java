package com.phoundation.blackboard9.client;

import com.blackboard.announcements.AnnouncementWSPortType;
import com.blackboard.calendar.CalendarWSPortType;
import com.blackboard.content.ContentWSPortType;
import com.blackboard.context.ContextWSPortType;
import com.blackboard.course.CourseWSPortType;
import com.blackboard.coursemembership.CourseMembershipWSPortType;
import com.blackboard.gradebook.GradebookWSPortType;
import com.blackboard.notificationdistributoroperations.NotificationDistributorOperationsWSPortType;
import com.blackboard.user.UserWSPortType;
import com.blackboard.util.UtilWSPortType;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Chris White
 */
public class ClientWrapper {

    private static Log log = LogFactory.getLog(ClientWrapper.class);
    private static final String SECURITY_NAMESPACE =
            "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";

    private static final int TOOL_SESSION = 0;
    private static final int USER_SESSION = 1;
    private static final int TICKET_SESSION = 2;
    
    private int sessionType = TOOL_SESSION;    
    public void setSessionType(int sessionType) {
        this.sessionType = sessionType;
    }
    
    

    public void initSession() throws Exception {
        log.debug("RE-INITIALISING SESSION");
        SessionHandler.reset();
        
        String password = contextWS.initialize().getReturn().getValue();
        
        SessionHandler.setPassword(password);
       
        /*
        switch (sessionType) {
            case TOOL_SESSION:
                loginTool();
                break;
            case USER_SESSION:
                login();
                break;
            case TICKET_SESSION:
                loginTicket();
        }
        */
    }
    
    
    
    private AnnouncementWSPortType announcementWS = null;
    @Autowired
    public void setAnnouncementWSPortType(AnnouncementWSPortType port) {
        announcementWS = (AnnouncementWSPortType) ClientServiceProxy.newInstance(AnnouncementWSPortType.class, port, this);
    }
    public AnnouncementWSPortType getAnnouncementService() throws Exception {
        return  announcementWS;
    }

    
    private CalendarWSPortType calendarWS = null;
    @Autowired
    public void setCalendarWSPortType(CalendarWSPortType port){
        calendarWS = (CalendarWSPortType) ClientServiceProxy.newInstance(CalendarWSPortType.class, port, this);
    }
    public CalendarWSPortType getCalendarService() throws Exception {            
        return calendarWS;
    }
    
    
    private ContentWSPortType contentWS = null;
    @Autowired
    public void setContentWSPortType(ContentWSPortType port) {
        contentWS = (ContentWSPortType) ClientServiceProxy.newInstance(ContentWSPortType.class, port, this);
    }
    public ContentWSPortType getContentService() throws Exception {
        return contentWS;
    }

    
    private ContextWSPortType contextWS = null;
    @Autowired
    public void setContextPortType(ContextWSPortType port) {
        contextWS = port;
    }
    public ContextWSPortType getContextService() throws Exception {
        return (ContextWSPortType)ClientServiceProxy.newInstance(ContextWSPortType.class, contextWS, this);
    }

    
    private CourseMembershipWSPortType courseMembershipWS = null;
    @Autowired
    public void setCourseMembershipWSPortType(CourseMembershipWSPortType port) {
        courseMembershipWS = (CourseMembershipWSPortType) ClientServiceProxy.newInstance(CourseMembershipWSPortType.class, port, this);
    }
    public CourseMembershipWSPortType getCourseMembershipService() throws Exception {
        return courseMembershipWS;
    }

    
    private CourseWSPortType courseWS = null;
    @Autowired
    public void setCourseWSPortType(CourseWSPortType port) {
        courseWS = (CourseWSPortType) ClientServiceProxy.newInstance(CourseWSPortType.class, port, this);
    }
    public CourseWSPortType getCourseService() throws Exception {
        return courseWS;
    }

    
    private GradebookWSPortType gradebookWS = null;
    @Autowired
    public void setGradebookWSPortType(GradebookWSPortType port) {
        gradebookWS = (GradebookWSPortType) ClientServiceProxy.newInstance(GradebookWSPortType.class, port, this);
    }
    public GradebookWSPortType getGradebookService() throws Exception {
        return gradebookWS;
    }

    
    private NotificationDistributorOperationsWSPortType notificationWS = null;
    @Autowired
    public void setNotificationDistributorOperationsWSPortType(NotificationDistributorOperationsWSPortType port) {
        notificationWS = (NotificationDistributorOperationsWSPortType) ClientServiceProxy.newInstance(NotificationDistributorOperationsWSPortType.class, port, this);
    }
    public NotificationDistributorOperationsWSPortType getNotificationService() throws Exception {
        return notificationWS;
    }

    
    private UserWSPortType userWS = null;
    @Autowired
    public void setUserWSPortType(UserWSPortType port) {
        userWS = (UserWSPortType) ClientServiceProxy.newInstance(UserWSPortType.class, port, this);
    }
    public UserWSPortType getUserService() throws Exception {
        return userWS;
    }

    
    private UtilWSPortType utilWS = null;
    @Autowired
    public void setUtilWSPortType(UtilWSPortType port) {
        utilWS = (UtilWSPortType) ClientServiceProxy.newInstance(UtilWSPortType.class, port, this);
    }
    public UtilWSPortType getUtilService() throws Exception {
        return utilWS;
    }

    public boolean registerTool(String registrationPassword, String description, List<String> toolMethods, List<String> ticketMethods) {
        return registerTool(this.vendorId, this.programId, registrationPassword, description,this.password, toolMethods, ticketMethods);
    }
    public boolean registerTool(String clientVendorId, String clientProgramId, String registrationPassword, String description, String initialSharedSecret, List<String> toolMethods, List<String> ticketMethods) {
        boolean success = false;
        try {
            success = contextWS.registerTool(clientVendorId, clientProgramId, registrationPassword, description, initialSharedSecret, toolMethods, ticketMethods).isStatus();
        } catch (Exception e) {
            log.error("Tool registration failed", e);
            return false;
        }
        return success;
    }

    public boolean loginTool() {
        return loginTool(password, vendorId, programId, null, sessionLife);
    }

    public boolean loginTool(String password, String clientVendorId, String clientProgramId, String loginExtraInfo, Long expectedLifeInSeconds) {
        
        boolean success = false;
        try {
            initSession();
            success = contextWS.loginTool(password, clientVendorId, clientProgramId, loginExtraInfo, expectedLifeInSeconds);
        } catch (Exception e) {
            log.error("Operation failed", e);
            return false;
        }
        return success;
    }

    public boolean loginTicket() {
        return loginTicket(ticket, vendorId, programId, null, sessionLife);
    }

    public boolean loginTicket(String ticket, String clientVendorId, String clientProgramId, String loginExtraInfo, Long expectedLifeInSeconds) {
        boolean success = false;
        try {
            initSession();
            success = contextWS.loginTicket(ticket, clientVendorId, clientProgramId, loginExtraInfo, expectedLifeInSeconds);
        } catch (Exception e) {
            log.error("Operation failed", e);
            return false;
        }
        return success;
    }

    public boolean login() {
        return login(userId, password, vendorId, programId, null, sessionLife);
    }

    public boolean login(String userid, String password, String clientVendorId, String clientProgramId, String loginExtraInfo, Long expectedLifeSeconds) {
        boolean success = false;
        try {
            initSession();
            success = contextWS.login(userid, password, clientVendorId, clientProgramId, loginExtraInfo, expectedLifeSeconds);
        } catch (Exception e) {
            log.error("Operation failed", e);
            return false;
        }
        return success;
    }
    
    public boolean logout() {
        boolean success = false;
        ContextWSPortType context = null;
        try {
            context = getContextService();
            success = context.logout().isReturn();
        } catch (Exception e) {
            log.error("Operation failed", e);
            return false;
        }
        return success;
    }
    
    protected String userId;

    public void setUserId(String id) {
        userId = id;
    }
    protected String ticket;

    public void setTicket(String t) {
        ticket = t;
    }
    protected String password;

    public void setPassword(String pw) {
        password = pw;
    }
    protected String vendorId;

    public void setVendorId(String id) {
        vendorId = id;
    }
    protected String programId;

    public void setProgramId(String id) {
        programId = id;
    }
    protected Long sessionLife = new Long(3000);

    public void setSessionLife(long life) {
        sessionLife = new Long(life);
    }
    
    private int connectTimeout = 1000;
    public void setConnectTimeout(int timeout) {
        connectTimeout = timeout;
    }
    private int requestTimeout = 3000;
    public void setRequestTimeout(int timeout) {
        requestTimeout = timeout;
    }
    
}
