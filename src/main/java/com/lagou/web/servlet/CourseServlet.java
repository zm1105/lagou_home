package com.lagou.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.lagou.base.BaseServlet;
import com.lagou.pojo.Course;
import com.lagou.service.CourseService;
import com.lagou.service.impl.CourseServiceImpl;
import com.lagou.service.impl.UpdateCourseImpl;
import com.lagou.service.updateCourse;
import com.lagou.utils.DateUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author : zhoumin
 * @data :  2020/8/26 11:02
 */

@WebServlet("/Course")
public class CourseServlet extends BaseServlet {

  CourseService courseService = new CourseServiceImpl();
//  SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Course.class, "id", "course_name"
//      , "price", "sort_num", "status");

  public void findCourseList(HttpServletRequest request, HttpServletResponse response) {

    try {
      List<Course> courseList = courseService.findCourseList();

      String s = JSON.toJSONString(courseList);
      response.getWriter().print(s);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void findByCourseNameAndStatus(HttpServletRequest request, HttpServletResponse response) {

    try {
      String course_name = request.getParameter("course_name");
      String status = request.getParameter("status");
      List<Course> courseNameAndStatus = courseService.findCourseNameAndStatus(course_name, status);


      String s = JSON.toJSONString(courseNameAndStatus);
      response.getWriter().print(s);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 根据课程ID查询
   */
  public void findCourseById(HttpServletRequest request, HttpServletResponse response) {

    try {
      String id = request.getParameter("id");
      CourseService courseService = new CourseServiceImpl();
      Course course = courseService.findById(Integer.parseInt(id));

      String result = JSON.toJSONString(course);
      response.getWriter().print(result);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 修改课程状态
   */
  public void updateCourseStatus(HttpServletRequest request, HttpServletResponse response) {

    try {
      String id = request.getParameter("id");

      updateCourse updateCourse = new UpdateCourseImpl();
      Course courseId = courseService.findById(Integer.parseInt(id));

      int status = courseId.getStatus();
      if (status == 0) {
        courseId.setStatus(1);
      } else {
        courseId.setStatus(0);
      }

      courseId.setUpdate_time(DateUtils.getDateFormart());
      Map<String, Integer> map = updateCourse.updateCourseStatus(courseId);

      String result = JSON.toJSONString(map);
      response.getWriter().print(result);
    } catch (IOException e) {
      e.printStackTrace();
    }


  }

}