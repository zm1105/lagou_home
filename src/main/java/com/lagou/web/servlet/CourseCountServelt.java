package com.lagou.web.servlet;

import com.alibaba.fastjson.JSON;
import com.lagou.base.BaseServlet;
import com.lagou.pojo.Course_Section;
import com.lagou.service.CourseCountService;
import com.lagou.service.impl.CourseCountServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : zhoumin
 * @data :  2020/9/17 11:09
 */

@WebServlet(urlPatterns = "/courseContent")

public class CourseCountServelt extends BaseServlet {


  public void findSectionAndLessonByCourseId(HttpServletRequest request, HttpServletResponse response) {

    try {
      String course_id = request.getParameter("course_id");

      CourseCountService courseCountService = new CourseCountServiceImpl();

      List<Course_Section> sectionList = courseCountService.findSetionAndLessonByCourseid(Integer.parseInt(course_id));
      String s = JSON.toJSONString(sectionList);
      response.getWriter().print(s);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
