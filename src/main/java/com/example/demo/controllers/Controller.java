package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.models.*;
import com.example.demo.services.interfaces.*;
import javax.inject.Inject;
import com.example.demo.entities.UserEntity;
import org.springframework.http.*;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class Controller {

    @Inject
    ISaveUserService saveUserService;
    
    @Inject
    ILoginUserService loginUserService;

    @RequestMapping("/sample")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello " + name;
    }
  
    @CrossOrigin(origins = "https://mqq8995q18.codesandbox.io")
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public Response registerUser(@RequestBody User user) {
    	return saveUserService.saveUser(user);
    }
    
    @CrossOrigin(origins = "https://mqq8995q18.codesandbox.io")
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public Response loginUser(@RequestBody User user) {
    	return loginUserService.loginUser(user);
    }
}
