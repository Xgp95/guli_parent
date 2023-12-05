package com.example.exceldemo;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;


public class TestEasyExcel {
    public static void main(String[] args) {
        String fileName = "D:\\write.xlsx";
//        EasyExcel.write(fileName, ExcelDemo.class).sheet("学生列表").doWrite(getData());
        EasyExcel.read(fileName, ExcelDemo1.class, new ExcelListener()).sheet().doRead();


    }

    //创建方法返回list集合
    private static List getData() {
        List<ExcelDemo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExcelDemo data = new ExcelDemo();
            data.setStuNo(i);
            data.setStuName("lucy" + i);
            data.setStuClass(i % 3 + 1);
            list.add(data);
        }
        return list;
    }
}
