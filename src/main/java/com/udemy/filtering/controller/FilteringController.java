package com.udemy.filtering.controller;

import com.udemy.filtering.model.FilteringModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public FilteringModel  filteringBeans(){
        FilteringModel filteringModel = new FilteringModel("field1", "field2", "field3");
        return filteringModel;
    }


     @GetMapping("/filtering-list")
    public List<FilteringModel> filteringBeansList(){
        return Arrays.asList( new FilteringModel("Hello","HR","MGR"),
                new FilteringModel("BYe","R","GR"));
     }

}
