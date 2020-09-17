package com.lagou.service.impl;

import com.lagou.dao.CoursecontentDao;
import com.lagou.dao.impl.CourseContDaoImpl;
import com.lagou.pojo.Course_Section;
import com.lagou.service.CourseCountService;

import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/9/17 11:06
 */
public class CourseCountServiceImpl implements CourseCountService {
  @Override
  public List<Course_Section> findSetionAndLessonByCourseid(int courseid) {

    CoursecontentDao courseContDao = new CourseContDaoImpl();
    List<Course_Section> setions = courseContDao.findSetionAndLessonByCourseid(courseid);

    return setions;
  }
}
