package com.lagou.dao.impl;

import com.lagou.dao.findCourseContentDao;
import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Section;
import com.lagou.utils.DateUtils;
import com.lagou.utils.JdbcDruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author : zhoumin
 * @data :  2020/9/17 16:40
 */
public class findCourseContentDaoImpl implements findCourseContentDao {
  QueryRunner queryRunner = new QueryRunner(JdbcDruidUtil.getDataSource());

  @Override
  public Course findCourseById(int courseid) {
    try {
      String sql = "SELECT id,course_name FROM course where id = ? ";

      Course courseList = queryRunner.query(sql, new BeanHandler<Course>(Course.class), courseid);
      return courseList;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 保存章节信息
   *
   * @param section
   * @return
   */
  @Override
  public int savceCoursecontent(Course_Section section) {

    try {
      String sql = "INSERT INTO course_section (course_id,section_name,description,order_num,`status`,create_time,update_time) VALUES (?,?,?,?,?,?,?); ";

      Object[] parm = {section.getCourse_id(), section.getSection_name(), section.getDescription(), section.getOrder_num(),
          section.getStatus(), section.getCreate_time(), section.getUpdate_time()};

      int row = queryRunner.update(sql, parm);
      return row;
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override
  public int updateCourse(Course_Section section) {

    try {
      String sql = "update course_section set  section_name=?,description=?,order_num=?,update_time=? where id =?";

      Object[] parem = {section.getSection_name(), section.getDescription(), section.getOrder_num(),
          section.getUpdate_time(), section.getId()};

      int row = queryRunner.update(sql, parem);

      return row;
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }

  @Override
  public int updateSectionStatus(int id, int status) {

    try {
      String sql = "update course_section set status=? ,update_time=? where id=?";

      Object[] parem = {status, DateUtils.getDateFormart(), id};

      int row = queryRunner.update(sql, parem);
      return row;
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }
}
