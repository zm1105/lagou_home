package com.lagou.service.impl;

import com.lagou.base.StatusCode;
import com.lagou.dao.impl.saveOrUpdateLessonDaoImpl;
import com.lagou.dao.saveOrUpdateLessonDao;
import com.lagou.pojo.Course_Lesson;
import com.lagou.service.saveOrUpdateLessonService;
import com.lagou.utils.DateUtils;

/**
 * @author : zhoumin
 * @data :  2020/9/30 17:44
 */
public class saveOrUpdateLessonServiceImpl implements saveOrUpdateLessonService {
  @Override
  public String UpdateLesson(Course_Lesson course_lesson) {

    String str = DateUtils.getDateFormart();
    course_lesson.setCreate_time(str);
    course_lesson.setUpdate_time(str);

    saveOrUpdateLessonDao saveOrUpdateLessonDao = new saveOrUpdateLessonDaoImpl();
    int i = saveOrUpdateLessonDao.UpdateLessonDao(course_lesson);
    if (i > 0) {
      String result = StatusCode.SUCCESS.toString();
      return result;

    } else {
      String result = StatusCode.FAIL.toString();
      return result;
    }
  }

  @Override
  public String saveLessonService(Course_Lesson lesson) {
    String str = DateUtils.getDateFormart();
    lesson.setCreate_time(str);
    lesson.setUpdate_time(str);

    saveOrUpdateLessonDao saveOrUpdateLessonDao = new saveOrUpdateLessonDaoImpl();

    int i = saveOrUpdateLessonDao.saveLessonDao(lesson);
    if (i > 0) {
      String result = StatusCode.SUCCESS.toString();
      return result;
    } else {
      String result = StatusCode.FAIL.toString();
      return result;
    }
  }
}
