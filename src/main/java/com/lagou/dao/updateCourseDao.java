package com.lagou.dao;

import com.lagou.pojo.Course;

/**
 * @author : zhoumin
 * @data :  2020/8/28 17:15
 */

/**
 * 修改课程营销信息
 */
public interface updateCourseDao {

  int updateCourseInfo(Course course);


  /**
   * 修改课程状态
   * @param course
   * @return
   */
   int updateCourseStatus(Course course);
}
