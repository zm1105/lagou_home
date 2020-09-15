package com.lagou.service.impl;

import com.lagou.base.StatusCode;
import com.lagou.dao.impl.updateCourseDaoImpl;
import com.lagou.dao.updateCourseDao;
import com.lagou.pojo.Course;
import com.lagou.service.updateCourse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhoumin
 * @data :  2020/8/28 17:27
 */
public class UpdateCourseImpl implements updateCourse {


  updateCourseDao updateCourseDao = new updateCourseDaoImpl();

  @Override
  public String updateCourseInfo(Course course) {
    int row = updateCourseDao.updateCourseInfo(course);

    if (row > 0) {
      return StatusCode.SUCCESS.toString();

    } else {
      return StatusCode.FAIL.toString();
    }
  }

  @Override
  public Map<String, Integer> updateCourseStatus(Course course) {
    int row = updateCourseDao.updateCourseStatus(course);
    Map<String, Integer> map = new HashMap<>();

    if (row > 0) {
      if (course.getStatus() == 0) {
        map.put("status", 0);
      } else {
        map.put("status", 1);
      }
    }
    return map;

  }
}
