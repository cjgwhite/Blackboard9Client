package com.phoundation.blackboard9.client;

/**
 *
 * All the 'types' used for setType() method in the Filters used within the 
 * BB9 clients. 
 * 
 * The relevant filter is defined by the first (camel cased) element of the constant's
 * name. For example <br/>
 * <br/>
 * <em>CalendarItem_GET_BY_ID</em> = CalendarItemFilter.
 * 
 * @author Chris White
 */
public final class FilterTypes {
  
    /*
     * AnnouncementsWS
     */
    // AnnouncementAttributeFilter
    public static final int AnnouncementAttribute_GET_BY_ID = 1;
    public static final int AnnouncementAttribute_GET_BY_COURSEID = 2;
    public static final int AnnouncementAttribute_GET_BY_COURSEID_AND_STARTDATE = 3;
    public static final int AnnouncementAttribute_GET_BY_USERID = 4;
    public static final int AnnouncementAttribute_GET_BY_USERID_AND_STARTDATE = 5;
    public static final int AnnouncementAttribute_GET_ALL_SYSTEM = 6;
    public static final int AnnouncementAttribute_GET_ALL_SYSTEM_BY_STARTDATE = 7;
    public static final int AnnouncementAttribute_GET_BY_USERID_AND_COURSEID = 8;
    public static final int AnnouncementAttribute_GET_BY_USERID_AND_COURSEID_AND_STARTDATE = 9;
    public static final int AnnouncementAttribute_GET_BY_CREATOR_USERID = 10;
    public static final int AnnouncementAttribute_GET_BY_CREATOR_USERID_AND_STARTDATE = 11;
        
    /*
     * CalendarWS
     */
    // CalendarItemFilter
    public static final int CalendarItem_GET_BY_ID = 1;
    public static final int CalendarItem_GET_BY_COURSE_ID = 2;
    public static final int CalendarItem_GET_FOR_COURSE_ID_DATE = 3;
    public static final int CalendarItem_GET_FOR_USER_ID = 4;
    public static final int CalendarItem_GET_FOR_USER_ID_DATE = 5;
    public static final int CalendarItem_GET_BY_TYPE = 6;
    public static final int CalendarItem_GET_BY_TYPE_DATE = 7;
    public static final int CalendarItem_GET_BY_COURSE_BATCH_ID = 8;
    public static final int CalendarItem_GET_BY_USER_BATCH_ID = 9;
    public static final int CalendarItem_GET_BY_CREATOR_USER_ID = 10;
    public static final int CalendarItem_GET_BY_CREATOR_USER_ID_DATE = 11;
  
    /*
     * ContentWS
     */
    // ContentFilter
    public static final int Content_GET_BY_CONTENTID = 1;
    public static final int Content_GET_IMMEDIATE_CHILDREN_BY_CONTENTID = 2;
    public static final int Content_GET_CHILDREN_BY_CONTENTID = 3;
    public static final int Content_GET_ANCESTOR_BY_CONTENTID = 4;
    public static final int Content_GET_ROOT_ENTRIES = 5;
    public static final int Content_GET_REVIEWABLE_ENTRIES = 6;
    public static final int Content_GET_ROOT_ENTRIES_BY_USERID = 7;
    public static final int Content_GET_MODIFIEDSINCE_BY_USERID = 8;
    public static final int Content_GET_CHILDREN_BY_CONTENTID_AND_USERID = 9;
    public static final int Content_GET_BY_TOCID = 10;
    
    // ContentStatusFilter
    public static final int ContentStatus_GET_BY_CONTENTID = 1;
    public static final int ContentStatus_GET_BY_COURSEID = 2;
    public static final int ContentStatus_GET_BY_COURSEID_AND_USERID = 3;
    
    /*
     * CourseWS
     */
    // CategoryFilter
    public static final int Category_GET_ALL_COURSE_CATEGORY = 1;
    public static final int Category_GET_ALL_ORG_CATEGORY = 2;
    public static final int Category_GET_CATEGORY_BY_ID = 3;
    public static final int Category_GET_CATEGORY_BY_PARENT_ID = 4;
    
    // CategoryMembershipFilter
    public static final int CategoryMembership_GET_CATEGORY_MEMBERSHIP_BY_ID = 1;
    public static final int CategoryMembership_GET_CATEGORY_MEMBERSHIP_BY_COURSE_ID = 2;
    
    // CourseFilter
    public static final int Course_GET_ALL_COURSES = 0;
    public static final int Course_GET_COURSE_BY_COURSEID = 1;
    public static final int Course_GET_COURSE_BY_BATCHUID = 2;
    public static final int Course_GET_COURSE_BY_ID = 3;
    public static final int Course_GET_COURSE_BY_CATEGORY_ID = 4;
    public static final int Course_GET_COURSE_BY_SEARCH_KEYVALUE = 5;
    
    // GroupFilter
    public static final int Group_GET_GROUP_BY_ID = 1;
    public static final int Group_GET_GROUP_BY_COURSE_ID= 2;
    public static final int Group_GET_ENROLLED_GROUP_BY_USER_ID= 3;
    
    /*
     * CourseMembershipWS
     */
    // CourseRoleFilter
    // MembershipFilter
    public static final int Membership_GET_BY_ID = 1;
    public static final int Membership_GET_BY_COURSEID = 2;
    public static final int Membership_GET_GROUP_MEMBERSHIP_BY_COURSE_MEMBERSHIP_ID = 3;
    public static final int Membership_GET_GROUP_MEMBERSHIP_BY_GROUP_ID = 4;
    public static final int Membership_GET_COURSE_MEMBERSHIP_BY_USER_ID = 5;
    public static final int Membership_GET_COURSE_MEMBERSHIP_BY_COURSEID_AND_USER_ID = 6;
    public static final int Membership_GET_COURSE_MEMBERSHIP_BY_COURSEID_AND_ROLE_ID = 7;
    
    /*
     * GradebookWS
     */
    // AttemptFilter
    public static final int Attempt_GET_ATTEMPT_BY_GRADE_ID = 1;
    public static final int Attempt_GET_ATTEMPT_BY_GRADE_ID_AND_LAST_ATTEMPT = 2;
    public static final int Attempt_GET_ATTEMPT_BY_IDS = 3;
    
    // ColumnFilter
    public static final int Column_GET_COLUMN_BY_COURSE_ID = 1;
    public static final int Column_GET_COLUMN_BY_COURSE_ID_AND_COLUMN_NAME = 2;
    public static final int Column_GET_COLUMN_BY_IDS = 3;
    public static final int Column_GET_COLUMN_BY_EXTERNAL_GRADE_FLAG = 4;
    
    // GradebookTypeFilter
    public static final int GradebookType_GET_GRADEBOOK_TYPE_BY_ID = 1;
    public static final int GradebookType_GET_GRADEBOOK_TYPE_BY_COURSE_ID = 2;
    public static final int GradebookType_GET_GRADEBOOK_TYPE_BY_COURSE_ID_AND_TITLE = 3;
    
    // GradingSchemaFiter
    public static final int GradingSchema_GET_GRADING_SCHEMA_BY_ID = 1;
    public static final int GradingSchema_GET_GRADING_SCHEMA_BY_COURSE_ID = 2;
    public static final int GradingSchema_GET_GRADING_SCHEMA_BY_COURSE_ID_AND_TITLE = 3;
    
    // ScoreFilter
    public static final int Score_GET_SCORE_BY_COURSE_ID = 1;
    public static final int Score_GET_SCORE_BY_COLUMN_ID_AND_USER_ID = 2;
    public static final int Score_GET_SCORE_BY_COLUMN_ID = 3;
    public static final int Score_GET_SCORE_BY_COURSE_ID_AND_FINAL_GRADE = 4;
    public static final int Score_GET_SCORE_BY_MEMBER_ID_AND_COLUMN_ID = 5;
    public static final int Score_GET_SCORE_BY_MEMBER_ID = 6;
    public static final int Score_GET_SCORE_BY_ID = 7;
    public static final int Score_GET_SCORE_BY_USER_ID = 8;
    public static final int Score_GET_SCORE_BY_USER_ID_AND_FINAL_GRADE = 9;
    public static final int Score_GET_SCORE_BY_MEMBER_IDS_AND_COLUMN_ID = 10;
    
    /*
     * NotificationdistributoroperationsWS
     */
    
    /*
     * UserWS
     */
    // UserFilter
    public static final int User_GET_ALL_USERS_WITH_AVAILABILITY = 1;
    public static final int User_GET_USER_BY_ID_WITH_AVAILABILITY = 2;
    public static final int User_GET_USER_BY_BATCH_ID_WITH_AVAILABILITY = 3;
    public static final int User_GET_USER_BY_COURSE_ID_WITH_AVAILABILITY = 4;
    public static final int User_GET_USER_BY_GROUP_ID_WITH_AVAILABILITY = 5;
    public static final int User_GET_USER_BY_NAME_WITH_AVAILABILITY = 6;
    public static final int User_GET_USER_BY_SYSTEM_ROLE = 7;
    
    public static final int User_GET_ADDRESS_BOOK_ENTRY_BY_ID = 1;
    public static final int User_GET_ADDRESS_BOOK_ENTRY_BY_CURRENT_USERID = 2;
    
    /*
     * UtilWS
     */
}
