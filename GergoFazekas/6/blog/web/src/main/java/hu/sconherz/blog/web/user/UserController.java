package hu.sconherz.blog.web.user;

import com.google.gson.Gson;
import hu.schonherz.blog.service.api.user.service.UserResult;
import hu.schonherz.blog.service.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Geri on 2016. 12. 29..
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String printUsers() {
        UserResult userResult = new UserResult();
        Gson gson = new Gson();
        return gson.toJson(userResult.getResults());
    }
}
