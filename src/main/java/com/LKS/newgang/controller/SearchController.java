package com.LKS.newgang.controller;

import com.LKS.newgang.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping("search")
    public String lectureList(Model model) {
        return null;
    }

    @PostMapping("/getStudentBelonging")
    @ResponseBody
    public ResponseEntity<?> getStdBelong(HttpSession session) {
        Optional<HashMap<String, String>> stdInfo = searchService.stdBelonging(String.valueOf(session.getAttribute("stdID")));

        final ResponseEntity<?>[] result = new ResponseEntity<?>[1];

        stdInfo.ifPresentOrElse(info -> {
            result[0] = ResponseEntity.ok(info);
        }, () -> result[0] = ResponseEntity.badRequest().build());

        return result[0];
    }
}
