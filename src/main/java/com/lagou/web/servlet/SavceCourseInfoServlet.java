package com.lagou.web.servlet;

import com.lagou.base.Constants;
import com.lagou.pojo.Course;
import com.lagou.service.SavceCourseService;
import com.lagou.service.impl.SavceCourseServiceImpl;
import com.lagou.service.impl.UpdateCourseImpl;
import com.lagou.service.updateCourseService;
import com.lagou.utils.DateUtils;
import com.lagou.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zhoumin
 * @data :  2020/8/27 15:20
 */
@WebServlet(name = "SavceCourseInfoServlet", urlPatterns = "/courseSalesInfo")
public class SavceCourseInfoServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      Course course = new Course();
      Map<String, Object> map = new HashMap<>();
      DiskFileItemFactory factory = new DiskFileItemFactory();
      ServletFileUpload upload = new ServletFileUpload(factory);

      List<FileItem> list = upload.parseRequest(request);
      for (FileItem fileItem : list) {
        boolean formField = fileItem.isFormField();
        // 普通表单
        if (formField) {
          String fieldName = fileItem.getFieldName();
          String  value= fileItem.getString("utf-8");
          map.put(fieldName, value);
        } else {        //文件上传
          String fieldName = fileItem.getFieldName();
          String newname = UUIDUtils.getUUID() + "_" + fieldName;

          InputStream inputStream = fileItem.getInputStream();
          String realPath = this.getServletContext().getRealPath("/");
          String webappspath = realPath.substring(0, realPath.indexOf("lagou_home"));

          OutputStream outputStream = new FileOutputStream(webappspath + "/upload/" + newname);
          IOUtils.copy(inputStream, outputStream);
          outputStream.close();
          inputStream.close();
          map.put("course_img_url", Constants.LOCAL_URL + "/upload/" + newname);
        }
      }

      BeanUtils.populate(course, map);
      String dateFormart = DateUtils.getDateFormart();
      updateCourseService updateCourse = new UpdateCourseImpl();

      System.out.println("huoqu"+course);
      if (map.get("id") != null) {
        System.out.println("8888888888888");
        //修改
        course.setCreate_time(dateFormart);
        String result = updateCourse.updateCourseInfo(course);
        response.getWriter().print(result);
      } else {
        //新建
        course.setCreate_time(dateFormart);
        course.setUpdate_time(dateFormart);
        course.setStatus(1);

        SavceCourseService savceCourseService = new SavceCourseServiceImpl();
        String s = savceCourseService.SavceCourseSalesInfo(course);
        response.getWriter().print(s);
      }

    } catch (FileUploadException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
  }
}
