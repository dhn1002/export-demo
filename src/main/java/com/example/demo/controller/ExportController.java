package com.example.demo.controller;

import com.example.demo.service.ExportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dong
 * @date 2018/3/19
 */
@RestController
public class ExportController {

    @Autowired
    private ExportService exportService;

    /**
     * @param resp
     */
    @RequestMapping("/exportExcel")
    public void exportExcel(HttpServletResponse resp) {
        HSSFWorkbook wb = exportService.exportExcel();
        writeResponse(resp, "导出表.xls", wb);
    }

    public void writeResponse(HttpServletResponse response, String fileName, HSSFWorkbook wb) {
        try {
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            response.setContentType("application/msexcel");
            wb.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
