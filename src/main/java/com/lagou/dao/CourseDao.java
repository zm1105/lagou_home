package com.lagou.dao;

import com.lagou.pojo.Course;

import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/8/26 10:51
 */
public interface CourseDao {

  /**
   * 查询所有课程信息
   * @return
   */
  List<Course> findCourseList();


  /**
   * 条件查询
   * @param name
   * @param status
   * @return
   */
  List<Course>findCourseNameAndStatus(String name,String status);

  Course findById(int id);
}
