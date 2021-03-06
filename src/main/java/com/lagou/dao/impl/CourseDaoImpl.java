package com.lagou.dao.impl;

import com.lagou.dao.CourseDao;
import com.lagou.pojo.Course;
import com.lagou.utils.JdbcDruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/8/26 10:52
 */
public class CourseDaoImpl implements CourseDao {

  QueryRunner queryRunner = new QueryRunner(JdbcDruidUtil.getDataSource());

  /**
   * 查询所有
   *
   * @return
   */
  @Override
  public List<Course> findCourseList() {

    try {
      String sql = "SELECT id ,course_name,price,sort_num,status FROM course WHERE is_del =?";
      List<Course> list = queryRunner.query(sql, new BeanListHandler<Course>(Course.class), 0);
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 根据名称和状态查询
   *
   * @param Coursename
   * @param status
   * @return
   */
  @Override
  public List<Course> findCourseNameAndStatus(String Coursename, String status) {

    try {
      StringBuffer stringBuffer = new StringBuffer("select * from  course where 1=1 and is_del =? ");
      List<Object> list = new ArrayList<>();
      list.add(0);

      if (null != Coursename && "" != Coursename) {
        stringBuffer.append(" and course_name like ?");
        String s = "%" + Coursename + "%";
        list.add(s);
      }

      if (null != status && "" != status) {
        stringBuffer.append(" and status = ?");
        int i = Integer.parseInt(status);
        list.add(i);
      }
      List<Course> list1 = queryRunner.query(stringBuffer.toString(), new BeanListHandler<Course>(Course.class), list.toArray());
      return list1;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 根据ID进行查询
   *
   * @param id
   * @return
   */
  @Override
  public Course findById(int id) {
    try {
      String sql = "SELECT id,course_name,brief,teacher_name,teacher_info,preview_first_field,preview_second_field,discounts, price,price_tag,course_img_url,share_image_title,share_title,share_description,course_description,STATUS FROM course WHERE id = ?";
      Course course = queryRunner.query(sql, new BeanHandler<Course>(Course.class),id);
      return course;
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }
  }
}
