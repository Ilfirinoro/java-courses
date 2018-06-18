package com.javacourse.servlet.util;

import com.javacourse.servlet.constants.ServletConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public class ServletUtil {

    public static UUID getIdFromRequest(HttpServletRequest req) {
        String idAsString = req.getParameter(ServletConstants.ID_PARAM_NAME);
        assert idAsString != null || !idAsString.equals("")
                : String.format("Некорректный идентификатор в параметрах запроса: <%s>.", idAsString);
        return UUID.fromString(req.getParameter(ServletConstants.ID_PARAM_NAME));
    }
}
