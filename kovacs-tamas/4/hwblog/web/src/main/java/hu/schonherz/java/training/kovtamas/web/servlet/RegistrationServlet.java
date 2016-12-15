package hu.schonherz.java.training.kovtamas.web.servlet;

import hu.schonherz.java.training.kovtamas.service.UserServiceImpl;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Id;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Location;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Login;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Name;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Picture;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.User;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.User.UserBuilder;
import hu.schonherz.java.training.kovtamas.web.form.RegistrationForm;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static hu.schonherz.java.training.kovtamas.web.form.RegistrationForm.fromRequest;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private final UserServiceImpl service;
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationServlet.class);

    public RegistrationServlet() {
        service = new UserServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationForm form = fromRequest(req);
        if (!isValidForm(form)) {
            resp.sendRedirect("/web/resources/pages/public/register.jsp");
        }
        User user = createUser(form);
        service.addUser(user);
        resp.sendRedirect("/web/resources/pages/public/login.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/web/resources/pages/public/register.jsp");
    }

    private boolean isValidForm(RegistrationForm form) {
        return !form.hasNullOrEmpty()
                && form.getPassword().equals(form.getConfirmPassword())
                && EmailValidator.getInstance().isValid(form.getEmail());
//                && DateValidator.getInstance().isValid(form.getDob());
    }

    private User createUser(RegistrationForm form) {
        UserBuilder builder = User.builder();

        Id id = new Id();
        id.setName(form.getUsername());
        id.setValue(form.getPassword());

        Login login = new Login();
        login.setUsername(form.getUsername());
        login.setPassword(form.getPassword());

        Location location = new Location();
        location.setCity(form.getCity());
        LOG.info("post code: " + form.getPostcode());
        location.setPostcode(Integer.parseInt(form.getPostcode()));
        location.setState(form.getState());
        location.setStreet(form.getStreet());

        Name name = new Name();
        name.setFirst(form.getFirstname());
        name.setLast(form.getLastname());
        name.setTitle(form.getTitle());

        Picture picture = new Picture();
        picture.setLarge(null);
        picture.setMedium(null);
        picture.setThumbnail(null);

        return builder
                .Id(id)
                .login(login)
                .location(location)
                .name(name)
                .picture(picture)
                .cell(form.getCell())
                .dob(form.getDob())
                .email(form.getEmail())
                .nat("?")
                .phone(form.getPhone())
                .gender(form.getGender())
                .build();
    }
}
