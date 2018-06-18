package com.javacourse.servlet.user;

import com.javacourse.servlet.util.ServletUtil;
import com.javacourse.store.user.UserCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class UserDeleteServlet extends HttpServlet {
    private final UserCache userCache = UserCache.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = ServletUtil.getIdFromRequest(req);
        userCache.remove(id);
    }
}
