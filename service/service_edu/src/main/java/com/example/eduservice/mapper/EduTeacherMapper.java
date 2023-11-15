package com.example.eduservice.mapper;

import com.example.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Administrator
* @description 针对表【edu_teacher(讲师)】的数据库操作Mapper
* @createDate 2023-11-13 17:37:42
* @Entity com.example.eduservice.entity.EduTeacher
*/
@Mapper
public interface EduTeacherMapper extends BaseMapper<EduTeacher> {

}




