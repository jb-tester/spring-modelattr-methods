package com.mytests.springmvc.springmodelattrmethods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * *
 * <p>Created by irina on 24.11.2020.</p>
 * <p>Project: spring-modelattr-methods</p>
 * <p>Issues:</p>
 * <ul>
 * <li><a href="https://youtrack.jetbrains.com/issue/IDEA-286593">not resolved attributes added using <strong>addAllAttributes(Map.of())</strong></a></li>
 * <li><a href="https://youtrack.jetbrains.com/issue/IDEA-286612">not resolved attributes added using <strong>addAllAttributes(Collection)</strong></a></li>
 * </ul>
 * *
 */
@Controller
public class ModelAttrsInMappingMethodsDifferentWays {
    @RequestMapping("/checkModelAttrsAddingInMappingMethod")
    public String checkModelAttrsAddingInMappingMethod(ModelMap model) {
        model.addAttribute("simple_attr1", "simple_attr1");
        model.addAttribute(new Foo0("foo0",0));
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

    @RequestMapping(value = "/checkModelAttrsAddingInMappingMethodToMaV")
    public ModelAndView checkModelAttrsAddingInMappingMethodToMav() {

        ModelAndView mav = new ModelAndView("m5");
        mav.addObject("simple_attr1", "simple_attr1");
        mav.addObject(new Foo0("foo04",4));
        Map<String, String> attrsMap  = new HashMap<>();
        attrsMap.put("map3attr1", "map3attr1_value");
        attrsMap.put("map3attr2", "map3attr2_value");
        attrsMap.put("map3attr3", "map3attr3_value");
        mav.addAllObjects(attrsMap);
        Map<String, String> attrsMap2 = Map.of(
                "map4attr1", "map4attr1_value",
                "map4attr2", "map4attr2_value",
                "map4attr3", "map4attr3_value"
        );
        mav.addAllObjects(attrsMap2);
        return mav;
    }
}
