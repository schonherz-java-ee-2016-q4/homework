package hu.schonherz.blog.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.vo.UserResultVo;

@Controller
public class UserController {

    @Autowired
    private UserService userService; 
    
    @RequestMapping(path="/listUsers", method=RequestMethod.GET,
    		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
	public String listUsers() {
		UserResultVo result = new UserResultVo();
		result.setResults(userService.findAllUser());
		return new Gson().toJson(result);
	}
    
    @RequestMapping(path="/admin/switchUserStatus")
    public  ResponseEntity<String> switchUserStatus(@RequestParam String username) {
		return ResponseEntity.ok("" + userService.switchUserStatus(username));
    }
}
