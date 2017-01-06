package hu.sconherz.blog.web.register;

import hu.schonherz.blog.service.api.user.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Geri on 2016. 12. 29..
 */
@Controller
public class RegisterController {

    private static final String REG_SUCCESS_URL = "secured/regsuccess.jsp";

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String add(HttpServletRequest req) {
        RegisterForm registerForm = new RegisterForm(req);
        UserVO userVO = toVO(registerForm);
        userService.add(userVO);
        return REG_SUCCESS_URL;
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
