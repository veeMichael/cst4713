package edu.citytech.cst.mv500.cst4713.marginaltaxrate.statetax;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import java.util.function.Supplier;


@Controller
public class StateTaxController {

    @Autowired
    StateTaxService service;

    Map<String, Supplier<List<StateRule>>> map = new HashMap<>();

    public void initialize (){
        map.put("state", service::getAllStates);
    }

    @RequestMapping("/state-tax")
    public String stateTaxController( Model model) {
        if(map.size()==0)initialize();
        model.addAttribute("states",service.getAllStates());
        return "state-tax.jsp";
    }
}
