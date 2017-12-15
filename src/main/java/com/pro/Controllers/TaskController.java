package com.pro.Controllers;

import com.pro.Model.Location;
import com.pro.Model.Result;
import com.pro.Services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * Created by muhamd gomaa on 12/14/2017.
 */

@Controller
public class TaskController {

    @Autowired
    TaskService taskservice;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String we() {
        return "hello";
    }

    @RequestMapping(value = "/app/{address}",  produces = "application/json")
    public ResponseEntity<Result> getSpecificAdderes (@PathVariable("address") String address)
    {
       Result r= taskservice.getAddress(address);

     return  new ResponseEntity<Result>(r,HttpStatus.OK);

    }

}
