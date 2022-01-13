package com.mytests.springmvc.springmodelattrmethods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * *
 * <p>Created by irina on 24.11.2020.</p>
 * <p>Project: spring-modelattr-methods</p>
 * *
 */
@Controller
public class ModelAttrsInMappingMethodsDifferentWays {
    @RequestMapping("/checkModelAttrsAddingInMappingMethod")
    public String test1(ModelMap model) {
        model.addAttribute("simple_attr1", "simple_attr1");
        model.addAttribute(new Foo1("foo0",0));
        Collection<FooService> attrs_list = new ArrayList<>(Arrays.asList(new Foo1("foo1", 1), new Foo2("foo2", 2), new Foo3("foo3", 3)));
        model.addAllAttributes(attrs_list);
        Map<String, String> attrsMap  = new HashMap<>();
        attrsMap.put("map1attr1", "map1attr1_value");
        attrsMap.put("map1attr2", "map1attr2_value");
        attrsMap.put("map1attr3", "map1attr3_value");
        model.addAllAttributes(attrsMap);
        model.addAllAttributes(Map.of(
                "map2attr1", "map2attr1_value",
                "map2attr2", "map2attr2_value",
                "map2attr3", "map2attr3_value"
        ));
        return "m4";
    }
}
