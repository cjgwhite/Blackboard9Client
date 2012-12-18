/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phoundation.blackboard9.client.helpers;

import com.blackboard.coursemembership.CourseMembershipVO;
import com.blackboard.coursemembership.MembershipFilter;
import java.util.List;
import com.phoundation.blackboard9.client.ClientWrapper;
import com.phoundation.blackboard9.client.FilterTypes;

/**
 *
 * @author chris
 */
public class BlackboardMembershipHelper {

    public static List<CourseMembershipVO> getCourseMemberships(ClientWrapper client, String courseId) throws Exception {

        MembershipFilter mFilter = new MembershipFilter();
        mFilter.setFilterType(FilterTypes.Membership_GET_BY_COURSEID);
        mFilter.getCourseIds().add(courseId);
        List<CourseMembershipVO> memberships = client.getCourseMembershipService().getCourseMembership(courseId, mFilter);

        return memberships;

    }
}
