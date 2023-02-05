package edu.citytech.cst.mv500.cst4713.marginaltaxrate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TaxReportController {


    @RequestMapping("/taxreport")
    public String helloWorld (Model model){
        return "table-design.jsp";
    }
}
