package com.example.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.eduservice.entity.EduSubject;
import com.example.eduservice.entity.subject.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【edu_subject(课程科目)】的数据库操作Service
 * @createDate 2023-12-09 16:42:38
 */
public interface EduSubjectService extends IService<EduSubject> {

    //    void saveSubject(MultipartFile file, EduSubjectService subjectService);
//添加课程分类
    void saveSubject(MultipartFile file, EduSubjectService subjectService);

    //课程分类列表（树形）
    List<OneSubject> getAllOneTwoSubject();
}
