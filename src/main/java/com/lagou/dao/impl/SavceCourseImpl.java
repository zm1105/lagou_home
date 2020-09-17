package com.lagou.dao.impl;

import com.lagou.dao.SavceCourse;
import com.lagou.pojo.Course;
import com.lagou.utils.JdbcDruidUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

/**
 * @author : zhoumin
 * @data :  2020/8/27 10:42
 */

/**
 *
 */
public class SavceCourseImpl implements SavceCourse {

  QueryRunner queryRunner = new QueryRunner(JdbcDruidUtil.getDataSource());

  @Override
  public int savceCourseSalesInfo(Course course) {
    try {
      String sql = "INSERT INTO course(course_name,brief,teacher_name,teacher_info,preview_first_field,preview_second_field,discounts,price,price_tag,share_image_title,share_title,share_description,course_description,course_img_url,STATUS,create_time,update_time)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

      Object[] objects = {course.getCourse_name(), course.getBrief(), course.getTeacher_name(), course.getTeacher_info(),
          course.getPreview_first_field(), course.getPreview_second_field(), course.getDiscounts(), course.getPrice(), course.getPrice_tag()
          , course.getShare_image_title(), course.getShare_title(),course.getShare_description(), course.getCourse_description(), course.getCourse_img_url(),
          course.getStatus(), course.getCreate_time(), course.getUpdate_time()};
      int i = queryRunner.update(sql, objects);
      return i;
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;

    }
  }
}

