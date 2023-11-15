package com.example.eduservice.controller;

import com.example.eduservice.entity.EduTeacher;
import com.example.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Resource
    EduTeacherService eduTeacherService;

//    查找所有老师
    @GetMapping("findAll")
    public List<EduTeacher> findAll() {
        return eduTeacherService.list();
    }
//    删除教师
//    @DeleteMapping("{id}")
//    public boolean deleteTeacher(@PathVariable String id) {
//        boolean result = eduTeacherService.removeById(id);
//        return result;
//    }
}
