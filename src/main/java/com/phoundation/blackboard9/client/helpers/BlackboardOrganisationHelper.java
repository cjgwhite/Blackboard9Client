/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phoundation.blackboard9.client.helpers;

import com.blackboard.course.CourseFilter;
import com.blackboard.course.CourseVO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.phoundation.blackboard9.client.ClientWrapper;
import com.phoundation.blackboard9.client.FilterTypes;

/**
 *
 * @author chris
 */
public class BlackboardOrganisationHelper {
    private static Log log = LogFactory.getLog(BlackboardOrganisationHelper.class);
    
    public static CourseVO getOrganisationByMleId(ClientWrapper client, String mleId) {
        List<CourseVO> courseList = getOrganisationsByMleIds(client, Arrays.asList(new String[] { mleId }));
        if (!courseList.isEmpty()) {
          return courseList.get(0);
        } else
          return null;
    }
    
    public static List<CourseVO> getOrganisationsByMleIds(ClientWrapper client, Collection<String> mleId) {
        CourseFilter filter = new CourseFilter();
        filter.setFilterType(FilterTypes.Course_GET_COURSE_BY_COURSEID);
        filter.getCourseIds().addAll(mleId);
        List<CourseVO> orgList = new ArrayList<CourseVO>();
        try {
            orgList.addAll(client.getCourseService().getOrg(filter));
        } catch (Exception ex) {
            log.error(ex);
        }
        return orgList;
    }
    
    
    public static CourseVO getOrganisationById(ClientWrapper client, String id) {
        List<String> ids = new ArrayList<String>();
        ids.add(id);
        List<CourseVO> courses = getOrganisationByIds(client, ids);
        if (!courses.isEmpty())
            return courses.get(0);
        else
            return null;
    }
    public static List<CourseVO> getOrganisationByIds(ClientWrapper client, Collection<String> ids) {
        
        CourseFilter filter = new CourseFilter();
        filter.setFilterType(FilterTypes.Course_GET_COURSE_BY_ID);
        filter.getIds().addAll(ids);
        log.debug(filter.getIds().size() + " IDs set");
        List<CourseVO> orgList = new ArrayList<CourseVO>();
        try {
            orgList.addAll(client.getCourseService().getOrg(filter));
            log.debug("Found "+orgList.size()+" ORGANISATIONS");
        } catch (Exception e) {
            log.error(e);
        }
        
        return orgList;
        
        
    }
}
