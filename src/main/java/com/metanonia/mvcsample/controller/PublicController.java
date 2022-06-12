package com.metanonia.mvcsample.controller;

import com.metanonia.mvcsample.model.Depth;
import com.metanonia.mvcsample.service.DepthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/public")
public class PublicController {
    @Autowired
    DepthService depthService;

    @GetMapping("/")
    public String publicHome() {
        return "/public/home";
    }

    @GetMapping("/depth")
    public String publicDepth(Model model) {
        List<HashMap<String,Object>> list = depthService.findAll();
        model.addAttribute("depth", list);
        return "/public/depth";
    }

    @GetMapping("/ajax")
    public String ajaxSample() {
        return "/public/ajax";
    }

    @ResponseBody
    @PostMapping("/getDepth")
    public String getDepth(Model model) {
        List<HashMap<String,Object>> list = depthService.findAll();
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(list);
        log.info(jsonArray.toString());
        return jsonArray.toString();
    }
}
