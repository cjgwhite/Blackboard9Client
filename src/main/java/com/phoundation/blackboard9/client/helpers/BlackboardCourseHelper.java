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
public class BlackboardCourseHelper {
    private static Log log = LogFactory.getLog(BlackboardCourseHelper.class);
    
    public static CourseVO getCourseByMleId(ClientWrapper client, String mleId) {
        List<CourseVO> courseList = getCoursesByMleIds(client, Arrays.asList(new String[] { mleId }));
        if (!courseList.isEmpty()) {
          return courseList.get(0);
        } else
          return null;
    }
    
    public static List<CourseVO> getCoursesByMleIds(ClientWrapper client, Collection<String> mleId) {
        CourseFilter filter = new CourseFilter();
        filter.setFilterType(FilterTypes.Course_GET_COURSE_BY_COURSEID);
        filter.getCourseIds().addAll(mleId);
        List<CourseVO> courseList = new ArrayList<CourseVO>();
        try {
            courseList.addAll(client.getCourseService().getCourse(filter));
        } catch (Exception ex) {
            log.error(ex);
        }
        return courseList;
    }
    
    
    public static CourseVO getCourseById(ClientWrapper client, String id) {
        List<String> ids = new ArrayList<String>();
        ids.add(id);
        List<CourseVO> courses = getCourseByIds(client, ids);
        if (!courses.isEmpty())
            return courses.get(0);
        else
            return null;
    }
    public static List<CourseVO> getCourseByIds(ClientWrapper client, Collection<String> ids) {
        
        CourseFilter filter = new CourseFilter();
        filter.setFilterType(FilterTypes.Course_GET_COURSE_BY_ID);
        filter.getIds().addAll(ids);
        log.debug(filter.getIds().size() + " IDs set");
        List<CourseVO> courseList = new ArrayList<CourseVO>();
        try {
            courseList.addAll(client.getCourseService().getCourse(filter));
            log.debug("Found "+courseList.size()+" COURSES");
        } catch (Exception e) {
            log.error(e);
        }
        
        return courseList;
        
        
    }
}
