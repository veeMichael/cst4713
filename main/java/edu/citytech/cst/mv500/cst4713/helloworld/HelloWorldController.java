package edu.citytech.cst.mv500.cst4713.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {


    @RequestMapping("/salutation")
    public String helloWorld (Model model){

        model.addAttribute("author", "Michael Vanunu");


        return "HelloWorld.jsp";
    }
}
