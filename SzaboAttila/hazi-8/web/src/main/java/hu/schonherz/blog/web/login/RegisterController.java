package hu.schonherz.blog.web.login;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hu.schonherz.blog.service.api.service.UserService;
import hu.schonherz.blog.service.api.user.exception.UserNotFoundException;
import hu.schonherz.blog.service.api.user.vo.IdVo;
import hu.schonherz.blog.service.api.user.vo.LocationVo;
import hu.schonherz.blog.service.api.user.vo.LoginVo;
import hu.schonherz.blog.service.api.user.vo.NameVo;
import hu.schonherz.blog.service.api.user.vo.PictureVo;
import hu.schonherz.blog.service.api.user.vo.UserVo;

@Controller
public class RegisterController {
    private static final String REGISTER_JSP_URL = "public/register";
    private static final String REGISTER_SUCC_JSP_URL = "public/register_succes";
    private static final String SAVE_DIR = "Files";

    @Autowired
    private UserService userService;
    
    @RequestMapping(path="/Register", method=RequestMethod.POST)
    public String registerNewUser(HttpServletRequest request, HttpServletResponse response, ModelMap model,
            @RequestParam("file") MultipartFile file)
            throws ServletException, IOException {
        RegisterForm registerForm = new RegisterForm(request);
        String username = registerForm.getUsername();
        
        try {
            userService.findUserByUsername(username);
            model.addAttribute("error", "This username already exists!");
            return REGISTER_JSP_URL;
        } catch (UserNotFoundException e) {
            registerForm.setImageurl(upload(file, request, username));
            userService.addNewUser(createUser(registerForm, userService));
            
            return REGISTER_SUCC_JSP_URL;
        }
    }

    private String upload(MultipartFile file, HttpServletRequest request, String username ) {
        try {
            byte[] bytes = file.getBytes();
            
            // gets absolute path of the web application
            String appPath = request.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            String savePath = appPath + SAVE_DIR;
            //System.out.println("savePath: " + savePath);
            String out = "";
            // creates the save directory if it does not exists
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }

            out = savePath + File.separator + username;
            //System.out.println("fileRealPath: " + out);
            // Create the file on server
            File serverFile = new File(out);
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            
            out = "..\\" + SAVE_DIR + File.separator + username;
            //System.out.println("fileFakePath: " + out);
            return out;
        } catch (Exception e) {
            return "";
        }
    }
    

    private UserVo createUser(RegisterForm registerForm, UserService userService) {
        UserVo user = new UserVo();
        
        LoginVo login = new LoginVo();
        login.setUsername(registerForm.getUsername());
        login.setPassword(registerForm.getPassword());
        user.setEmail(registerForm.getEmail());
        user.setLogin(login);
        
        NameVo name = new NameVo();
        name.setTitle(registerForm.getTitle());
        name.setFirst(registerForm.getFirstname());
        name.setLast(registerForm.getLastname());
        user.setName(name);
        user.setGender(registerForm.getGender());
        user.setDob(registerForm.getDob() + " 00:00:00");
        
        LocationVo location = new LocationVo();
        location.setState(registerForm.getState());
        location.setPostcode(Integer.parseInt(registerForm.getPostcode()));
        location.setCity(registerForm.getCity());
        location.setStreet(registerForm.getStreet());
        user.setLocation(location);
        
        user.setPhone(registerForm.getPhone());
        user.setCell(registerForm.getCell());
        user.setRegistered(new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + " 00:00:00");
        
        PictureVo picture = new PictureVo();
        picture.setLarge(registerForm.getImageurl());
        picture.setMedium(registerForm.getImageurl());
        picture.setThumbnail(registerForm.getImageurl());
        user.setPicture(picture);
        
        IdVo id = new IdVo();
        id.setName("");
        id.setValue("");
        user.setId(id);
        
        user.setNat("");
        
        return user;
    }

}
