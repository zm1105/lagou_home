package com.lagou.dao.impl;

import com.lagou.dao.updateCourseDao;
import com.lagou.pojo.Course;
import com.lagou.utils.JdbcDruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author : zhoumin
 * @data :  2020/8/28 17:16
 */
public class updateCourseImpl implements updateCourseDao {
  @Override
  public int updateCourseInfo(Course course) {

    try {
      QueryRunner queryRunner = new QueryRunner(JdbcDruidUtil.getDataSource());

      String sql = "UPDATE course SET course_name = ?,brief = ? ,teacher_name = ?,teacher_info = ?,preview_first_field = ?,preview_second_field = ?,discounts = ?,price = ?,price_tag = ?,share_image_title = ?,share_title = ?,share_description = ?,course_description = ?,course_img_url = ?,update_time = ? WHERE id = ?";

      Object[] param = {course.getCourse_name(), course.getBrief(), course.getTeacher_name(), course.getTeacher_info(),
          course.getPreview_first_field(), course.getPreview_second_field(), course.getDiscounts(), course.getPrice(),
          course.getPrice_tag(), course.getShare_image_title(), course.getShare_title(), course.getShare_description(),
          course.getCourse_description(), course.getCourse_img_url(), course.getUpdate_time(), course.getId()};

      int row = queryRunner.update(sql, param);
      return row;
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }
}
