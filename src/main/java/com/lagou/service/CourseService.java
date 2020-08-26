package com.lagou.service;

import com.lagou.pojo.Course;

import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/8/26 10:59
 */
public interface CourseService {
  List<Course> findCourseList();

  List<Course>findCourseNameAndStatus(String name,String status);

}
