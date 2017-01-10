package hu.schonherz.blog.web.user;

import com.google.gson.Gson;
import hu.schonherz.blog.service.user.service.UserService;
import hu.schonherz.blog.service.user.service.UserServiceImpl;
import hu.schonherz.blog.service.user.vo.UserVO;
import hu.schonherz.blog.web.register.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * Created by Geri on 2017. 01. 04..
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/secured/users", method = RequestMethod.GET)
    public ModelAndView printUsers() {
        Collection<UserVO> users = userService.findAll();
        return new ModelAndView("/secured/users", "users", users);
    }

    @RequestMapping(path = "/users/new", method = RequestMethod.POST)
    public String saveUser(HttpServletRequest req) {
        RegisterForm registerForm = new RegisterForm(req);
        userService.add(toVO(registerForm));
        return "redirect:/users";
    }

    @RequestMapping(path = "/admin/users/changeStatus", method = RequestMethod.GET)
    public String changeStatus(@RequestParam(value = "id") int id) {
        userService.changeStatus(id);
        return "redirect:/secured/users";
    }

    private static UserVO toVO(RegisterForm registerForm) {
        UserVO userVO = new UserVO();
        userVO.setFirstName(registerForm.getFirstName());
        userVO.setLastName(registerForm.getLastName());
        userVO.setEmail(registerForm.getEmail());
        userVO.setUsername(registerForm.getUsername());
        userVO.setPassword(registerForm.getPassword());
        userVO.setPhone(registerForm.getPhone());
        userVO.setGender(registerForm.getGender());
        userVO.setDob(registerForm.getDob());
        userVO.setRegistered(registerForm.getRegistered());
        userVO.setPostcode(registerForm.getPostcode());
        userVO.setStreet(registerForm.getStreet());
        userVO.setState(registerForm.getState());
        userVO.setCity(registerForm.getCity());
        userVO.setLargePicture(registerForm.getLargePicture());
        userVO.setMediumPicture(registerForm.getMediumPicture());
        userVO.setThumbnail(registerForm.getThumbnail());
        return userVO;
    }
}
