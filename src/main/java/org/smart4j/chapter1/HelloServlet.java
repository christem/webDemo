package org.smart4j.chapter1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by suny on 2016/11/3.
 */
@WebServlet("/org/smart4j/chapter1/hello")
public class HelloServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        request.setAttribute("currentTime",currentTime);
        request.getRequestDispatcher("/WEB-INF/jsp/org/smart4j/chapter1/hello.jsp").forward(request,response);
    }
}
