//package com.lagou.web.servlet;
//
//import com.lagou.utils.UUIDUtils;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//import org.apache.commons.io.IOUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//
///**
// * @author : zhoumin
// * @data :  2020/8/27 11:15
// */
//@WebServlet(name = "FileUploadServlet", urlPatterns = "/Upload")
//public class FileUploadServlet extends HttpServlet {
//  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    try {
//      DiskFileItemFactory factory = new DiskFileItemFactory();
//
//      ServletFileUpload upload = new ServletFileUpload(factory);
//      upload.setHeaderEncoding("utf-8");
//      boolean multipartContent = upload.isMultipartContent(request);
//      if (multipartContent) {
//        List<FileItem> list = upload.parseRequest(request);
//        if (null != list) {
//          for (FileItem fileItem : list) {
//            boolean formField = fileItem.isFormField();
//            if (formField) {
//              String fieldName = fileItem.getFieldName();
//              String string = fileItem.getString("utf-8");
//
//
//            } else {
//              String name = fileItem.getName();
//              String newName = UUIDUtils.getUUID() + "_" + name;
//              InputStream in = fileItem.getInputStream();
//
//              String realPath = this.getServletContext().getRealPath("/");
//              String webappspath = realPath.substring(0, realPath.indexOf("lagou_home"));
//
//              FileOutputStream out = new FileOutputStream(webappspath + "/upload" + newName);
//              IOUtils.copy(in, out);
//              out.close();
//              in.close();
//            }
//          }
//        }
//      }
//    } catch (FileUploadException e) {
//      e.printStackTrace();
//    }
//  }
//
//  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    this.doPost(request, response);
//  }
//}
