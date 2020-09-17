package com.lagou.dao.impl;

import com.lagou.dao.CoursecontentDao;
import com.lagou.pojo.Course_Lesson;
import com.lagou.pojo.Course_Section;
import com.lagou.utils.JdbcDruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/9/17 10:30
 */
public class CourseContDaoImpl implements CoursecontentDao {

  QueryRunner queryRunner = new QueryRunner(JdbcDruidUtil.getDataSource());

  /**
   * @return
   */
  @Override
  public List<Course_Section> findSetionAndLessonByCourseid(int courseid) {


    try {
      String sql = "select id,course_id,section_name,description,order_num,status from course_section  where course_id =?";

      List<Course_Section> sectionList = queryRunner.query(sql, new BeanListHandler<Course_Section>(Course_Section.class), courseid);
      for (Course_Section section : sectionList) {
        List<Course_Lesson> lessionlist = findLessionBySectionid(section.getId());
        section.setCourseLessonlist(lessionlist);
      }
      return sectionList;

    } catch (SQLException e) {
      e.printStackTrace();

      return null;
    }
  }

  @Override
  public List<Course_Lesson> findLessionBySectionid(int Sectionid) {

    try {
      String sql = "select id,course_id,theme,duration,order_num,status FROM course_lesson WHERE section_id = ?";

      List<Course_Lesson> query = queryRunner.query(sql, new BeanListHandler<Course_Lesson>(Course_Lesson.class), Sectionid);
      return query;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
