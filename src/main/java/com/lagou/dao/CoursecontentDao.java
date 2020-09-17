package com.lagou.dao;

/**
 * @author : zhoumin
 * @data :  2020/8/31 11:00
 */

import com.lagou.pojo.Course_Lesson;
import com.lagou.pojo.Course_Section;

import java.util.List;

/**
 * 课程管理
 */
public interface CoursecontentDao {


  /**
   * 课程ID对应章节与课时
   *
   * @return
   */
  List<Course_Section> findSetionAndLessonByCourseid(int courseid);


  List<Course_Lesson> findLessionBySectionid(int Sectionid);
}
