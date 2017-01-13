package hu.sconherz.blog.web.register;

import hu.schonherz.blog.service.UserService;
import hu.schonherz.blog.service.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/Register")
public class RegistrationController {

    @Autowired
    private UserService userService;
    private UserVO vo = new UserVO();

    @RequestMapping("/new")
    protected String Register(HttpServletRequest request) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        RegistrationForm register = new RegistrationForm(request);

        vo.setFirstName(register.getFirstName());
        vo.setLastName(register.getLastName());
        vo.setUsername(register.getUsername());
        vo.setPassword(register.getPassword());
        vo.setEmail(register.getEmail());
        vo.setGender(register.getGender());
        vo.setDate_of_birth(register.getDate_of_birth());
        vo.setLocation(register.getLocation());
        vo.setPhone(register.getPhone());

        userService.save(vo);

        return "public/login";
    }

}