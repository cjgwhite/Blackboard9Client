/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phoundation.blackboard9.client.helpers;

import com.blackboard.coursemembership.CourseMembershipRoleVO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.phoundation.blackboard9.client.ClientWrapper;

/**
 *
 * @author chris
 */
public class BlackboardRolesHelper {
    
    private static Log log = LogFactory.getLog(ClientWrapper.class);
    
    public static Map<String,String> getCourseRoles(ClientWrapper client) {
        
        Map<String,String> roles = new HashMap<String,String>();
        try {
            List<CourseMembershipRoleVO> roleList = client.getCourseMembershipService().getCourseRoles(null);
            for (CourseMembershipRoleVO role : roleList) {
                roles.put(role.getRoleIdentifier().getValue(), role.getCourseRoleDescription().getValue());
            }
        } catch (Exception ex) {
            log.debug(ex);
        }
        
        return roles;
        
    }
    
    public static Map<String,String> getOrganisationRoles(ClientWrapper client) {
        
        Map<String,String> roles = new HashMap<String,String>();
        try {
            List<CourseMembershipRoleVO> roleList = client.getCourseMembershipService().getCourseRoles(null);
            for (CourseMembershipRoleVO role : roleList) {
                roles.put(role.getRoleIdentifier().getValue(), role.getOrgRoleDescription().getValue());
            }
        } catch (Exception ex) {
            log.debug(ex);
        }
        
        return roles;
        
    }
}
