package com.javacourse.servlet.user;

import com.javacourse.servlet.constants.ServletConstants;
import com.javacourse.store.user.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserViewServlet extends HttpServlet {

    private final UserCache userCache = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(
                ServletConstants.USERS_PARAM_NAME,
                this.userCache.values()
        );
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(ServletConstants.USER_VIEW_JSP_PATH);
        requestDispatcher.forward(req, resp);
    }

}
