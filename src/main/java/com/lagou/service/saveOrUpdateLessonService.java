package com.lagou.service;

import com.lagou.pojo.Course_Lesson;

/**
 * @author : zhoumin
 * @data :  2020/9/30 17:43
 */
public interface saveOrUpdateLessonService {

  String UpdateLesson(Course_Lesson course_lesson);


  String saveLessonService(Course_Lesson lesson);
}
