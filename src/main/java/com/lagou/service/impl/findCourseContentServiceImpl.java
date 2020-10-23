package com.lagou.service.impl;

import com.lagou.base.StatusCode;
import com.lagou.dao.findCourseContentDao;
import com.lagou.dao.impl.findCourseContentDaoImpl;
import com.lagou.dao.impl.saveOrUpdateLessonDaoImpl;
import com.lagou.dao.saveOrUpdateLessonDao;
import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Section;
import com.lagou.service.findCourseContentService;
import com.lagou.utils.DateUtils;

/**
 * @author : zhoumin
 * @data :  2020/9/17 16:59
 */
public class findCourseContentServiceImpl implements findCourseContentService {
  findCourseContentDao updateCourseContentDao = new findCourseContentDaoImpl();

  @Override
  public Course findCourseById(int courseid) {

    Course courseById = updateCourseContentDao.findCourseById(courseid);


    return courseById;
  }

  @Override
  public String savceCoursecontent(Course_Section section) {
    /**
     * 1   待发布
     * 2   发布
     * 0   隐藏
     */
    section.setStatus(2);
    section.setCreate_time(DateUtils.getDateFormart());
    section.setUpdate_time(DateUtils.getDateFormart());


    int i = updateCourseContentDao.savceCoursecontent(section);

    if (i > 0) {
      return StatusCode.SUCCESS.toString();
    } else {
      return StatusCode.FAIL.toString();
    }
  }

  @Override
  public String updateCourseSection(Course_Section section) {
    //补信息

    String dateFormart = DateUtils.getDateFormart();
    section.setUpdate_time(dateFormart);
    int i = updateCourseContentDao.updateCourse(section);
    if (i > 0) {
      String s = StatusCode.SUCCESS.toString();
      return s;
    } else {
      String s = StatusCode.FAIL.toString();
      return s;
    }
  }

  @Override
  public String updateSectionStatus(int id, int status) {

    int i = updateCourseContentDao.updateSectionStatus(id, status);
    if (i > 0) {
      String s = StatusCode.SUCCESS.toString();
      return s;
    } else {
      String s = StatusCode.FAIL.toString();
      return s;
    }
  }

  @Override
  public String updateLessonStatus(int id, int status) {
    saveOrUpdateLessonDao saveOrUpdateLessonDao = new saveOrUpdateLessonDaoImpl();
    int i = saveOrUpdateLessonDao.updateLessonStatusDao(id, status);
    if (i > 0) {
      String s = StatusCode.SUCCESS.toString();
      return s;
    } else {
      String s = StatusCode.FAIL.toString();
      return s;
    }
  }
}
