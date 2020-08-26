package com.lagou.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.lagou.base.BaseServlet;
import com.lagou.pojo.Course;
import com.lagou.service.CourseService;
import com.lagou.service.impl.CourseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/8/26 11:02
 */

@WebServlet("/Course")
public class CourseServlet extends BaseServlet {

  CourseService courseService = new CourseServiceImpl();
  SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Course.class, "id", "course_name"
      , "price", "sort_num", "status");

  public void findCourseList(HttpServletRequest request, HttpServletResponse response) {

    try {
      List<Course> courseList = courseService.findCourseList();

      String s = JSON.toJSONString(courseList, filter);
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


      String s = JSON.toJSONString(courseNameAndStatus, filter);
      response.getWriter().print(s);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}