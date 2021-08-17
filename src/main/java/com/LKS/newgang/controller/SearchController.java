package com.LKS.newgang.controller;
import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.service.SearchService;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SearchController {
    @Autowired
    SearchService searchService;
    @RequestMapping("search")
    public String lectureList(Model model) {

    }
}
