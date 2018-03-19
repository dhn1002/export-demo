package com.example.demo.service.impl;

import com.example.demo.model.UserEntity;
import com.example.demo.service.ExportService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author dong
 * @date 2018/3/19
 */
@Service
public class ExportServiceImpl implements ExportService {

    public HSSFWorkbook exportExcel() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("导出表");
        sheet.setDefaultColumnWidth(10);
//        sheet.setColumnWidth(0, 20*256);  //设置某列列宽
        //表头
        HSSFRow menuRow = sheet.createRow(0);
        createCellByStrings(menuRow,"id","用户名","密码","创建时间");
        //数据行
        List<UserEntity> data = getData();
        HSSFRow row;
        HSSFCell cell;
        for (int i = 0; i < data.size(); i++) {
            UserEntity user = data.get(i);
            row = sheet.createRow(i+1);
            cell = row.createCell(0);
            cell.setCellValue(user.getId());
            cell = row.createCell(1);
            cell.setCellValue(user.getName());
            cell = row.createCell(2);
            cell.setCellValue(user.getPassword());
            cell = row.createCell(3);
            cell.setCellValue(user.getCreateTime());
        }
        return  wb;
    }

    public void createCellByStrings(HSSFRow row, String... array){
        for (int i = 0; i < array.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(array[i]);
        }
    }

    public List<UserEntity> getData() {
        List<UserEntity> list = new ArrayList<>();
        list.add(new UserEntity(1,"一一","111",new Date()));
        list.add(new UserEntity(1,"二二","222",new Date()));
        list.add(new UserEntity(1,"三三","333",new Date()));
        list.add(new UserEntity(1,"四四","444",new Date()));
        return list;
    }
}
