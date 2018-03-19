package com.example.demo.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author dong
 * @date 2018/3/19
 */
public interface ExportService {

    HSSFWorkbook exportExcel();

}
