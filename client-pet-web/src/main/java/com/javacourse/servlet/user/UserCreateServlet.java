package com.javacourse.servlet.user;

import com.javacourse.servlet.constants.ServletConstants;
import com.javacourse.store.user.UserCache;
import com.javacourse.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserCreateServlet extends HttpServlet {
    private final UserCache userCache = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ServletConstants.USER_CREATE_JSP_PATH);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(ServletConstants.LOGIN_PARAM_NAME);
        String email = req.getParameter(ServletConstants.EMAIL_PARAM_NAME);
        User user = new User(login, email);
        userCache.put(user.getId(), user);
        doGet(req, resp);
    }
}
