package com.mytests.springmvc.springmodelattrmethods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * *
 * <p>Created by irina on 06.07.2020.</p>
 * <p>Project: spring-modelattrs-methods</p>
 * <p> <a href="https://youtrack.jetbrains.com/issue/IDEA-108160">IDEA-108160 "Cannot resolve path variable" when @ModelAttribute uses @PathVariable</a></p>
 * *
 */
@Controller
public class ModelAttrsWithPathVarsController {
    
    @ModelAttribute("mattr1")
    public String mattr1(@PathVariable("pv1") String pv1, @PathVariable String pv2){
        return "model attr with path variables "+pv1+" and "+pv2;
    }
    
    @GetMapping("/mapv/m1/{pv1}/{pv2}")
    public String m1(@ModelAttribute String mattr1){
        
        return "m1";
    }
    
}
