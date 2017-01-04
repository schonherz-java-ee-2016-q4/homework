package hu.sconherz.blog.web.blogpost.postcreator.validator;

import javax.servlet.http.HttpServletRequest;

public class PostCreatorFormValidator {
    private final HttpServletRequest request;

    public PostCreatorFormValidator(HttpServletRequest request) {
        super();
        this.request = request;
    }

    public boolean isValidForm() {
        if (validateBody() && validateTitle() && validateOwner()) {
            return true;
        }
        return false;

    }

    private boolean validateTitle() {
        if (request.getParameter("title") != null && request.getParameter("title") != "") {
            return true;
        }
        return false;
    }

    private boolean validateBody() {
        if (request.getParameter("body") != null && request.getParameter("body") != "") {
            return true;
        }
        return false;
    }

    private boolean validateOwner() {
        if (request.getSession().getAttribute("user") != null) {
            return true;
        }
        return false;
    }

}
