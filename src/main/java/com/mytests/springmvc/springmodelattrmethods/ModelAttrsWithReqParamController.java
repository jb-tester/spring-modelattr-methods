package com.mytests.springmvc.springmodelattrmethods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * *
 * <p>Created by irina on 06.07.2020.</p>
 * <p>Project: spring-modelattrs-methods</p>
 * <p> <a href="https://youtrack.jetbrains.com/issue/IDEA-245300">IDEA-245300 Spring MVC: request parameters specified in @ModelAttribute-annotated methods are not supported</a></p>
 * *
 */
@Controller
public class ModelAttrsWithReqParamController {
    
    
    @ModelAttribute("mattr2")
    public String mattr2(@RequestParam(name = "rp1", defaultValue = "dummy parameter") String rp1, 
                         @RequestParam String rp2){
        return "model attr with request params "+rp1+" and "+rp2;
    }
    
    @GetMapping("/mapv/m2")
    public String m2(@ModelAttribute("mattr2") String mattr2){
        System.out.println("**********************************");
        System.out.println(mattr2);
        System.out.println("**********************************");
        return "m2";
    }
    
   
    
    
    
}
