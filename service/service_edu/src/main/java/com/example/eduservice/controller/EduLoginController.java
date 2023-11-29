package com.example.eduservice.controller;

import com.example.commonutils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/eduservice/user")
public class EduLoginController {
    @PostMapping(value = "login")
    public R login() {
        return R.ok().data("token", "admin");
    }
    @GetMapping(value = "info")
    public R info() {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","");
    }
}
