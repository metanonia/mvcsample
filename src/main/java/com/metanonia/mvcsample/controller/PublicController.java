package com.metanonia.mvcsample.controller;

import com.metanonia.mvcsample.model.Depth;
import com.metanonia.mvcsample.service.DepthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping("/getDepth")
    public String getDepth(@RequestParam HashMap<String,Object>params, Model model) {
        log.info(params.toString());
        List<HashMap<String,Object>> list = depthService.findAll();
        JSONArray jsonArray = new JSONArray(list);
        log.info(jsonArray.toString());
        return jsonArray.toString();
    }
}
