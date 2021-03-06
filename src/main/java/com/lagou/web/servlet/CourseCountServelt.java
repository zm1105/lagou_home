package com.lagou.web.servlet;

import com.alibaba.fastjson.JSON;
import com.lagou.base.BaseServlet;
import com.lagou.pojo.Course;
import com.lagou.pojo.Course_Lesson;
import com.lagou.pojo.Course_Section;
import com.lagou.service.CourseCountService;
import com.lagou.service.findCourseContentService;
import com.lagou.service.impl.CourseCountServiceImpl;
import com.lagou.service.impl.findCourseContentServiceImpl;
import com.lagou.service.impl.saveOrUpdateLessonServiceImpl;
import com.lagou.service.saveOrUpdateLessonService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

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

  public void findCourseById(HttpServletRequest request, HttpServletResponse response) {
    try {
      String course_id = request.getParameter("course_id");

      findCourseContentService updateCourseContentService = new findCourseContentServiceImpl();
      Course courseById = updateCourseContentService.findCourseById(Integer.parseInt(course_id));

      String s = JSON.toJSONString(courseById);
      response.getWriter().print(s);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void saveOrUpdateSection(HttpServletRequest request, HttpServletResponse response) {
    try {
      Map<String, Object> map = (Map) request.getAttribute("map");

      Course_Section section = new Course_Section();

      //BeanUtils.populate(course_section, map);
      BeanUtils.copyProperties(section,map.get("section"));
      findCourseContentService findCourseContentService = new findCourseContentServiceImpl();
      if (section.getId() == 0) {
        //新增
        String s = findCourseContentService.savceCoursecontent(section);
        response.getWriter().print(s);
      } else {
        //修改
        String s = findCourseContentService.updateCourseSection(section);
        response.getWriter().print(s);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void updateSectionStatus(HttpServletRequest request, HttpServletResponse response) {
    try {
      int id = Integer.parseInt(request.getParameter("id"));
      int status = Integer.parseInt(request.getParameter("status"));

      findCourseContentService findCourseContentService = new findCourseContentServiceImpl();
      String s = findCourseContentService.updateSectionStatus(id, status);
      response.getWriter().print(s);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public void saveOrUpdateLesson(HttpServletRequest request, HttpServletResponse response) {
    try {
      Map<String, Object> map = (Map) request.getAttribute("map");

      Course_Lesson course_lesson = new Course_Lesson();
      BeanUtils.populate(course_lesson, map);
      saveOrUpdateLessonService saveOrUpdateLessonService = new saveOrUpdateLessonServiceImpl();

      if (course_lesson.getId() == 0) {
        //新增
        String s = saveOrUpdateLessonService.saveLessonService(course_lesson);
        response.getWriter().print(s);
      } else {
        //修改
        String s = saveOrUpdateLessonService.UpdateLesson(course_lesson);
        response.getWriter().print(s);
      }
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  /**
   * 修改课时状态
   * @param request
   * @param response
   */
  public void updateLessonStatus(HttpServletRequest request, HttpServletResponse response) {
    try {
      int id = Integer.parseInt(request.getParameter("id"));
      int status = Integer.parseInt(request.getParameter("status"));

      findCourseContentService findCourseContentService = new findCourseContentServiceImpl();
      String s = findCourseContentService.updateLessonStatus(id, status);
      response.getWriter().print(s);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
