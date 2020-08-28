package com.lagou.service.impl;

import com.lagou.dao.CourseDao;
import com.lagou.dao.impl.CourseDaoImpl;
import com.lagou.pojo.Course;
import com.lagou.service.CourseService;

import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/8/26 10:59
 */
public class CourseServiceImpl implements CourseService {

  CourseDao courseDao = new CourseDaoImpl();

  @Override
  public List<Course> findCourseList() {
    List<Course> courseList = courseDao.findCourseList();
    return courseList;
  }

  @Override
  public List<Course> findCourseNameAndStatus(String name, String status) {
    List<Course> list = courseDao.findCourseNameAndStatus(name, status);
    return list;
  }

  @Override
  public Course findById(int id) {
    CourseDao courseDao = new CourseDaoImpl();
    return courseDao.findById(id);

  }
}
