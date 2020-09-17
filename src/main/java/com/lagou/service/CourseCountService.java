package com.lagou.service;

import com.lagou.pojo.Course_Section;

import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/9/17 11:03
 */
public interface CourseCountService {

  /**
   * 根据课程ID查询课程内容
   * @param courseid
   * @return
   */

  List<Course_Section> findSetionAndLessonByCourseid(int courseid);

}
