package com.example.eduservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.commonutils.R;
import com.example.eduservice.entity.EduTeacher;
import com.example.eduservice.entity.vo.TeacherQuery;
import com.example.eduservice.service.EduTeacherService;
import com.example.servicebase.exceptionhandler.GlException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    @Autowired
    EduTeacherService eduTeacherService;

    //    讲师修改
    @ApiOperation(value = "讲师修改")
    @PostMapping(value = "updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if (flag) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    //    根据id查询讲师
    @ApiOperation(value = "根据id查询讲师")
    @GetMapping(value = "findTeacherById/{id}")
    public R findTeacherById(@PathVariable String id) {
//        int i = 10 / 0;
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return R.ok().data("eduTeacher", eduTeacher);
    }

    //    添加讲师
    @ApiOperation(value = "添加讲师")
    @PostMapping(value = "addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher) {
//        System.out.println(eduTeacher);
        boolean b = eduTeacherService.save(eduTeacher);
        if (b) {
            return R.ok();
        } else {
            return R.error();
        }

    }

    //    条件分页查询讲师
    @ApiOperation(value = "条件分页查询讲师")
    @PostMapping("pageTeacherCondition/{current}/{size}")
    public R pageTeacherCondition(@PathVariable long current,
                                  @PathVariable long size,
                                  @RequestBody(required = false) TeacherQuery teacherQuery) {
        Page<EduTeacher> eduTeacherPage = new Page<>(current, size);
//        System.out.println(teacherQuery);
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();
//        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<EduTeacher> queryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like(EduTeacher::getName, name);
        }
        if (!StringUtils.isEmpty(level)) {
            queryWrapper.eq(EduTeacher::getLevel, level);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge(EduTeacher::getGmtCreate, begin);
        }
        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le(EduTeacher::getGmtCreate, end);
        }
        queryWrapper.orderByDesc(EduTeacher::getGmtModified);
        eduTeacherService.page(eduTeacherPage, queryWrapper);
        List<EduTeacher> teacherPageRecords = eduTeacherPage.getRecords();
        long total = eduTeacherPage.getTotal();
        Map map = new HashMap();
        map.put("total", total);
        map.put("teacherPageRecords", teacherPageRecords);
        return R.ok().data(map);
    }

    //分页查询讲师
    @ApiOperation(value = "分页查询讲师")
    @GetMapping("pageTeacher/{current}/{size}")
    public R pageTeacher(@PathVariable long current,
                         @PathVariable long size) {
        Page<EduTeacher> eduTeacherPage = new Page<>(current, size);
        eduTeacherService.page(eduTeacherPage);
        List<EduTeacher> teacherPageRecords = eduTeacherPage.getRecords();
        long total = eduTeacherPage.getTotal();
        Map map = new HashMap();
        map.put("total", total);
        map.put("teacherPageRecords", teacherPageRecords);
        return R.ok().data(map);
    }

    //    查找所有老师
    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public R findAll() {
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            throw new GlException(20001, "执行了自定义异常处理.");
        }
        List<EduTeacher> eduTeacherList = eduTeacherService.list();
        R r = R.ok().data("items", eduTeacherList);
        return r;
    }

    //    @GetMapping("findAll")
//    public List<EduTeacher> findAll() {
//        return eduTeacherService.list();
//    }
//    删除教师
    @ApiOperation(value = "根据id删除教师")
    @DeleteMapping("{id}")
    public R deleteTeacher(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        boolean result = eduTeacherService.removeById(id);
        if (result) {
            return R.ok();
        } else {
            return R.error();
        }
    }
//    @DeleteMapping("{id}")
//    public boolean deleteTeacher(@PathVariable String id) {
//        boolean result = eduTeacherService.removeById(id);
//        return result;
//    }
}
