package com.example.exceldemo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExcelDemo1 {
    @ExcelProperty(value = "学生编号", index = 0)
    private Integer stuNo;
    @ExcelProperty(value = "学生姓名", index = 1)
    private String stuName;
    @ExcelProperty(value = "学生年级", index = 2)
    private Integer stuClass;
}
