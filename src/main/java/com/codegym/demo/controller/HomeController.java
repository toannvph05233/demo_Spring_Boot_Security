package com.codegym.demo.controller;

import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class HomeController {
    @Value("${uploadPart}")
    String uploadPart;


    @Autowired
    IProductService productService;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/upload")
    public String uploadfile() {
        return "uploadfile";
    }

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam MultipartFile file) throws IOException {

        String name = file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes(), new File(uploadPart + name));

        ModelAndView modelAndView = new ModelAndView("uploadfile");
        modelAndView.addObject("img", name);

        return modelAndView;
    }
}
