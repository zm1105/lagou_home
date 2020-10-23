package com.lagou.dao;

import com.lagou.pojo.Course_Lesson;

/**
 * @author : zhoumin
 * @data :  2020/9/30 17:08
 */
public interface saveOrUpdateLessonDao {


  /**
   * 修改课时信息
   * @param course_lesson
   * @return
   */
 int UpdateLessonDao(Course_Lesson course_lesson);


 int saveLessonDao(Course_Lesson lesson);


  /**
   * 修改课时状态
   * @param id
   * @param status
   * @return
   */
 int updateLessonStatusDao(int id ,int status);

}
