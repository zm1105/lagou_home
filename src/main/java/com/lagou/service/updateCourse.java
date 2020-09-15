package com.lagou.service;

import com.lagou.pojo.Course;

import java.util.Map;

/**
 * @author : zhoumin
 * @data :  2020/8/28 17:24
 */
public interface updateCourse {

  String updateCourseInfo(Course course);

  Map< String ,Integer> updateCourseStatus(Course course);

}
