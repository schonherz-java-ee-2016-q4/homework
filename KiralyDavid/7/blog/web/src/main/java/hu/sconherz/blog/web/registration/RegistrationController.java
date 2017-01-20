package hu.sconherz.blog.web.registration;

import hu.schonherz.blog.service.UserService;
import hu.schonherz.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/Registration")
public class RegistrationController {

    @Autowired
    private UserService userService;
    private UserVO vo = new UserVO();

    @RequestMapping("/new")
    private String Registration(HttpServletRequest request) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        RegistrationForm registration = new RegistrationForm(request);

        vo.setFirstName(registration.getFirstName());
        vo.setLastName(registration.getLastName());
        vo.setUsername(registration.getUsername());
        vo.setPassword(registration.getPassword());
        vo.setEmail(registration.getEmail());
        vo.setGender(registration.getGender());
        vo.setDate_of_birth(registration.getDate_of_birth());
        vo.setLocation(registration.getLocation());
        vo.setPhone(registration.getPhone());

        userService.save(vo);

        return "public/login";
    }

}
