package edu.citytech.cst.mv500.cst4713;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({ "/home", "/index",  "/" })
    public String index() {
        return "index.jsp";
    }

    @RequestMapping({ "NA" })
    public String na() {
        return "NA.jsp";
    }

}