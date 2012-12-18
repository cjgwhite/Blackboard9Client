package com.phoundation.blackboard9.client.helpers;

import com.blackboard.coursemembership.CourseMembershipVO;
import com.blackboard.coursemembership.MembershipFilter;
import com.blackboard.user.UserFilter;
import com.blackboard.user.UserVO;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.phoundation.blackboard9.client.ClientWrapper;
import com.phoundation.blackboard9.client.FilterTypes;

/**
 *
 * @author chris
 */
public class BlackboardUserHelper {

    private static Log log = LogFactory.getLog(ClientWrapper.class);

    public static String getInternalUserId(ClientWrapper client, String username) {
        String id = "";

        try {
            UserFilter filter = new UserFilter();
            filter.setFilterType(FilterTypes.User_GET_USER_BY_NAME_WITH_AVAILABILITY);
            filter.setAvailable(Boolean.TRUE);
            filter.getName().add(username);

            List<UserVO> user = client.getUserService().getUser(filter);

            if (!user.isEmpty()) {
                id = user.get(0).getId().getValue();
            } else {
                throw new RuntimeException("No matching user found");
            }

        } catch (Exception ex) {
            log.error("Failed to get user", ex);
            throw new RuntimeException("Failed to get user", ex);
        }

        return id;
    }

    public static String getUserRoleOnCourse(ClientWrapper client, String userId, String courseId) {
        Map<String, String> roles = getUserRoleOnCourses(client, userId, Arrays.asList(new String[]{courseId}));

        if (roles.containsKey(courseId)) {
            return roles.get(courseId);
        } else {
            throw new RuntimeException("User not enrolled on course : " + courseId);
        }

    }

    public static Map<String, String> getUserRoleOnCourses(ClientWrapper client, String userId, Collection<String> courseIds) {

        Map<String, String> roles = new HashMap<String, String>();

        try {


            MembershipFilter filter = new MembershipFilter();
            //filter.setFilterType(FilterTypes.Membership_GET_COURSE_MEMBERSHIP_BY_COURSEID_AND_USER_ID);
            filter.setFilterType(FilterTypes.Membership_GET_COURSE_MEMBERSHIP_BY_USER_ID);
            //filter.getCourseIds().addAll(courseIds);
            filter.getUserIds().add(userId);

            for (String cId : courseIds) {
                List<CourseMembershipVO> memberships = client.getCourseMembershipService().getCourseMembership(cId, filter);

                for (CourseMembershipVO membership : memberships) {
                    roles.put(membership.getCourseId().getValue(), membership.getRoleId().getValue());
                }
            }


        } catch (Exception e) {
            log.error("Failed to get role", e);
            throw new RuntimeException("Failed to get role", e);
        }


        return roles;

    }

    public static List<UserVO> getUsersOnCourse(ClientWrapper client, String courseId) throws Exception {

        UserFilter uFilter = new UserFilter();
        uFilter.setFilterType(FilterTypes.User_GET_USER_BY_COURSE_ID_WITH_AVAILABILITY);
        uFilter.getCourseId().add(courseId);
        uFilter.setAvailable(Boolean.TRUE);

        List<UserVO> courseUsers = client.getUserService().getUser(uFilter);

        return courseUsers;

    }
}
