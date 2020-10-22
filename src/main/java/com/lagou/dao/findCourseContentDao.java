package com.lagou.dao;

import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Section;

/**
 * @author : zhoumin
 * @data :  2020/9/17 16:37
 */
public interface findCourseContentDao {

  /**
   * 回显课程
   * @param id
   * @return
   */
  Course findCourseById(int id);

  /**
   * 保存章节
   */

  int savceCoursecontent(Course_Section section);

  /**
   * 保存&修改章节信息
   * @param section
   * @return
   */
  int updateCourse(Course_Section section);


   int updateSectionStatus(int id, int status);
}
