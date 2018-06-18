package com.javacourse.servlet.user;

import com.javacourse.model.User;
import com.javacourse.servlet.constants.ServletConstants;
import com.javacourse.servlet.util.ServletUtil;
import com.javacourse.store.user.UserCache;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static com.javacourse.servlet.constants.ServletConstants.USER_ATTRIBUTE_NAME;
import static com.javacourse.servlet.constants.ServletConstants.USER_EDIT_JSP_PATH;


public class UserEditServlet extends HttpServlet {

    private final UserCache userCache = UserCache.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = ServletUtil.getIdFromRequest(req);
        User user = userCache.get(id);

        req.setAttribute(USER_ATTRIBUTE_NAME, user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USER_EDIT_JSP_PATH);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = ServletUtil.getIdFromRequest(req);
        String login = req.getParameter(ServletConstants.LOGIN_PARAM_NAME);
        String email = req.getParameter(ServletConstants.EMAIL_PARAM_NAME);

        User userToEdit = this.userCache.get(id);
        userToEdit.setLogin(login);
        userToEdit.setEmail(email);
        this.userCache.put(id, userToEdit);
        doGet(req, resp);
    }
}
