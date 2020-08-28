package com.lagou.service.impl;

import com.lagou.base.StatusCode;
import com.lagou.dao.updateCourseDao;
import com.lagou.pojo.Course;
import com.lagou.service.updateCourse;

/**
 * @author : zhoumin
 * @data :  2020/8/28 17:27
 */
public class updateCourseImpl implements updateCourse {
  @Override
  public String updateCourseInfo(Course course) {
    updateCourseDao updateCourseDao = new com.lagou.dao.impl.updateCourseImpl();
    int row = updateCourseDao.updateCourseInfo(course);

    if (row > 0) {
      return StatusCode.SUCCESS.toString();

    } else {
      return StatusCode.FAIL.toString();
    }
  }
}
