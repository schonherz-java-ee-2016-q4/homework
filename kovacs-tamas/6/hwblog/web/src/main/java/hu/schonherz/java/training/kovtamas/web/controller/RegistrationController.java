package hu.schonherz.java.training.kovtamas.web.controller;

import hu.schonherz.java.training.kovtamas.service.UserServiceImpl;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Dates;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Location;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Login;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.Name;
import hu.schonherz.java.training.kovtamas.serviceapi.user.vo.UserVo;
import hu.schonherz.java.training.kovtamas.web.form.RegistrationForm;
import hu.schonherz.java.training.kovtamas.web.pageinfo.PageNames;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.routines.DateValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static hu.schonherz.java.training.kovtamas.web.form.RegistrationForm.fromRequest;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserServiceImpl service;
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    public RegistrationController() {
    }

    @PostMapping
    protected String registerUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationForm form = fromRequest(req);
        if (!isValidForm(form)) {
            return PageNames.REGISTRATION_PAGE;
        } else {
            UserVo user = createUser(form);
            service.addUser(user);
            return PageNames.LOGIN_PAGE;
        }
    }

    @GetMapping
    protected String getMethod(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        return PageNames.REGISTRATION_PAGE;
    }

    private boolean isValidForm(RegistrationForm form) {
        return !form.hasNullOrEmpty()
                && form.getPassword().equals(form.getConfirmPassword())
                && EmailValidator.getInstance().isValid(form.getEmail())
                && DateValidator.getInstance().isValid(form.getDob(), "MM/dd/YYYY");

    }

    private UserVo createUser(RegistrationForm form) {
        Login login = new Login();
        login.setUsername(form.getUsername());
        login.setPassword(form.getPassword());

        Location location = new Location();
        location.setCity(form.getCity());
        location.setPostCode(Integer.parseInt(form.getPostcode()));
        location.setStreet(form.getStreet());

        Name name = new Name();
        name.setFirstName(form.getFirstname());
        name.setLastName(form.getLastname());

        Dates dates = new Dates();
        dates.setRegistration(new java.util.Date());
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        try {
            dates.setBirth(dateFormat.parse(form.getDob()));
        } catch (ParseException pe) {
            String messsage = "Could not parse Date of Birth!";
            LOG.warn(messsage, pe);
            throw new IllegalArgumentException(messsage, pe);
        }

        UserVo vo = new UserVo();
        vo.setLogin(login);
        vo.setLocation(location);
        vo.setName(name);
        vo.setDates(dates);

        vo.setGender(form.getGender());
        vo.setEmail(form.getEmail());
        vo.setPhone(form.getPhone());
        vo.setPicUrl(null);

        return vo;
    }

}
