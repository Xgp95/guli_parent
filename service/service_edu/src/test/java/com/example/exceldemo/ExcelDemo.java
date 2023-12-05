package com.example.exceldemo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelDemo {
    @ExcelProperty("学生编号")
    private Integer stuNo;
    @ExcelProperty("学生姓名")
    private String stuName;
    @ExcelProperty("学生年级")
    private Integer stuClass;
}
