package com.lagou.dao.impl;

import com.lagou.dao.saveOrUpdateLessonDao;
import com.lagou.pojo.Course_Lesson;
import com.lagou.utils.DateUtils;
import com.lagou.utils.JdbcDruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author : zhoumin
 * @data :  2020/9/30 17:29
 */
public class saveOrUpdateLessonDaoImpl implements saveOrUpdateLessonDao {

  QueryRunner queryRunner = new QueryRunner(JdbcDruidUtil.getDataSource());

  @Override
  /**
   * 修改课时信息
   */
  public int UpdateLessonDao(Course_Lesson course_lesson) {
    try {
      String sql = "UPDATE course_lesson SET course_id= ?,section_id=?,theme=?,duration=?,is_free=?,order_num=?,update_time=?,create_time=? WHERE id = ?;";

      Object[] parms = {course_lesson.getCourse_id(), course_lesson.getSection_id(), course_lesson.getTheme(),
          course_lesson.getDuration(), course_lesson.getIs_free(), course_lesson.getOrderNum(), course_lesson.getUpdate_time(),
          course_lesson.getCreate_time(), course_lesson.getId()};

      int row = queryRunner.update(sql, parms);
      return row;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int saveLessonDao(Course_Lesson lesson) {

    try {
      String sql = "INSERT INTO course_lesson (course_id,section_id,theme,duration,is_free,order_num,create_time,id,update_time) VALUES (?,?,?,?,?,?,?,?,?);";

      Object[] parms = {lesson.getCourse_id(), lesson.getSection_id(), lesson.getTheme(), lesson.getDuration(),
          lesson.getIs_free(), lesson.getOrderNum(), lesson.getCreate_time(), lesson.getId(), lesson.getUpdate_time()};

      int row = queryRunner.update(sql, parms);

      return row;
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }


  /**
   * 修改课时状态
   * @param id
   * @param status
   * @return
   */
  @Override
  public int updateLessonStatusDao(int id, int status) {
    try {
      String sql = "update course_lesson set status=? ,update_time=? where id=?";
      Object [] parms = {status, DateUtils.getDateFormart(), id};

      int row = queryRunner.update(sql, parms);

      return  row;
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }
}
