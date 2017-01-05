/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.sconherz.blog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap map) {
        map.put("msg", "Hello Spring 4 Web MVC!");
        return "index";
    }

//    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

//    @RequestMapping(method = RequestMethod.GET)
//    public String testAll(ModelMap model) {
//        model.addAttribute("message", "MEGY A SPRING!!!");
//        LOG.debug("MEGYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
//        return "index";
//    }
    

}
