package com.lagou.service.impl;

import com.lagou.base.StatusCode;
import com.lagou.dao.SavceCourse;
import com.lagou.dao.impl.SavceCourseImpl;
import com.lagou.pojo.Course;
import com.lagou.service.SavceCourseService;
import com.lagou.utils.DateUtils;

/**
 * @author : zhoumin
 * @data :  2020/8/27 11:05
 */
public class SavceCourseServiceImpl implements SavceCourseService {
  @Override
  public String SavceCourseSalesInfo(Course course) {

    String str = DateUtils.getDateFormart();
    course.setCreate_time(str);
    course.setUpdate_time(str);
    course.setStatus(1);

    SavceCourse savceCourse = new SavceCourseImpl();
    int i = savceCourse.savceCourseSalesInfo(course);
    if (i > 0) {
      String result = StatusCode.SUCCESS.toString();
      return result;

    } else {
      String result = StatusCode.FAIL.toString();
      return result;
    }
  }

}
