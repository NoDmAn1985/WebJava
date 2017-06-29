package ru.academits.novoselovda.helloservlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final String htmlEnd = "</body></html>";

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println(getHtmlHead("GET"));
        out.println("<h1>Метод GET</h1>");
        out.println(htmlEnd);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println(getHtmlHead("POST"));
        String text = request.getParameter("name");
        out.println("<h1>Привет, " + text + "</h1>");
        out.println(htmlEnd);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    private String getHtmlHead(String title) {
        return "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><title>" + title + "</title></head><body>";
    }
}
