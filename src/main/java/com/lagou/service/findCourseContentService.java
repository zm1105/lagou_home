package com.lagou.service;

import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Section;

/**
 * @author : zhoumin
 * @data :  2020/9/17 16:58
 */
public interface findCourseContentService {

  Course findCourseById(int courseid);


  String savceCoursecontent(Course_Section section);


  String updateCourseSection(Course_Section section);

  String updateSectionStatus(int id ,int status);

  /**
   * 修改课时状态
   * @param
   * @return
   */
  String updateLessonStatus(int id ,int status);



}
