package blog_web.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import blog_service.services.PostServiceImpl;
import blog_service.services.UserServiceImpl;
import blog_service.vo.PostVO;
import blog_service.vo.UserVO;

@Controller
public class MapController {
	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	UserVO userVO;
	
	@Autowired
	PostServiceImpl postService;
	
	@Autowired
	PostVO postVO;
	@RequestMapping("/")
	public  ModelAndView index(){
		return new  ModelAndView("index", "posts",  postService.findAll());
	}
	
	@RequestMapping(path = "/posts/{id}")
	public ModelAndView posts(@PathVariable int id){
		return new ModelAndView("posts", "post", postService.findById(id));
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logoout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null){
			 new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}
	
	@RequestMapping("/register")
	public String register(){
		return "register";
	}
	
	
	@RequestMapping("/users")
	public ModelAndView users(){
		return new ModelAndView("users", "users", userService.findAll());
	}

	@RequestMapping("/post")
	public String post(){
		return "post";
	}
	
}
