package org.selina.ptj.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.selina.ptj.bean.Job;
import org.selina.ptj.bean.JobState;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ Author : Selina
 * @ Date : 2020/5/1
 * @ Description : org.selina.ptj.utils
 * @ version : 1.0
 */
public class POIUtils {
    public static ResponseEntity<byte[]> employee2Excel(List<Job> list) throws IOException {
        //创建一个Excel文档
        HSSFWorkbook workbook=new HSSFWorkbook();
        //创建文档摘要
        workbook.createInformationProperties();
        //获取并配置文档信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("兼职信息");
        //文档管理员
        docInfo.setManager("selina");
        //设置公司信息
        docInfo.setCompany("www.selina.org");
        //获取文档摘要信息
        SummaryInformation sumInfo=workbook.getSummaryInformation();
        //文档标题
        sumInfo.setTitle("兼职信息表");
        //文档作者
        sumInfo.setAuthor("selina");
        //文档备注
        sumInfo.setComments("本文由selina提供");

        //创建样式，创建标题行的样式，比如标题行背景色
        HSSFCellStyle headerStyle=workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        //填充模式solid_foreground
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置日期格式
        HSSFCellStyle dateCellStyle=workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));

        HSSFSheet sheet = workbook.createSheet("兼职信息表");
        //设置列宽,5个字符的样子
        sheet.setColumnWidth(0,5*256);
        sheet.setColumnWidth(1,15*256);
        sheet.setColumnWidth(2,15*256);
        sheet.setColumnWidth(3,15*256);
        sheet.setColumnWidth(4,20*256);
        sheet.setColumnWidth(5,15*256);
        sheet.setColumnWidth(6,5*256);
        sheet.setColumnWidth(7,5*256);
        sheet.setColumnWidth(8,20*256);
        sheet.setColumnWidth(9,12*256);
        sheet.setColumnWidth(10,15*256);
        sheet.setColumnWidth(11,15*256);
        //创建标题行
        HSSFRow row0 = sheet.createRow(0);
        //列名
        HSSFCell cell0 = row0.createCell(0);
        cell0.setCellValue("编号");
        cell0.setCellStyle(headerStyle);

        HSSFCell c1 = row0.createCell(1);
        c1.setCellStyle(headerStyle);
        c1.setCellValue("名称");
        HSSFCell c2 = row0.createCell(2);
        c2.setCellStyle(headerStyle);
        c2.setCellValue("起始时间");
        HSSFCell c3 = row0.createCell(3);
        c3.setCellStyle(headerStyle);
        c3.setCellValue("时段");
        HSSFCell c4 = row0.createCell(4);
        c4.setCellStyle(headerStyle);
        c4.setCellValue("工作地点");
        HSSFCell c5 = row0.createCell(5);
        c5.setCellStyle(headerStyle);
        c5.setCellValue("薪资");
        HSSFCell c6 = row0.createCell(6);
        c6.setCellStyle(headerStyle);
        c6.setCellValue("人数");
        HSSFCell c7 = row0.createCell(7);
        c7.setCellStyle(headerStyle);
        c7.setCellValue("状态");
        HSSFCell c8 = row0.createCell(8);
        c8.setCellStyle(headerStyle);
        c8.setCellValue("具体要求");
        HSSFCell c9 = row0.createCell(9);
        c9.setCellStyle(headerStyle);
        c9.setCellValue("结束时间");
        HSSFCell c10 = row0.createCell(10);
        c10.setCellStyle(headerStyle);
        c10.setCellValue("公司ID");
        HSSFCell c11 = row0.createCell(11);
        c11.setCellStyle(headerStyle);
        c11.setCellValue("发布时间");

        //遍历集合 放数据
        for (int i = 0; i <list.size(); i++) {
            Job job = list.get(i);
            HSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(job.getId());
            row.createCell(1).setCellValue(job.getName());

            HSSFCell cell2 = row.createCell(2);
            cell2.setCellStyle(dateCellStyle);
            cell2.setCellValue(job.getBeginDate());

            row.createCell(3).setCellValue(job.getJobtime());
            row.createCell(4).setCellValue(job.getWorkplace());
            row.createCell(5).setCellValue(job.getSalary());
            row.createCell(6).setCellValue(job.getNum());
            row.createCell(7).setCellValue(job.getState());
            row.createCell(8).setCellValue(job.getDetails());

            HSSFCell cell9 = row.createCell(9);
            cell9.setCellStyle(dateCellStyle);
            cell9.setCellValue(job.getEndDate());

            row.createCell(10).setCellValue(job.getBusinessid());

            HSSFCell cell11 = row.createCell(11);
            cell11.setCellStyle(dateCellStyle);
            cell11.setCellValue(job.getPosttime());

        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        HttpHeaders headers=new HttpHeaders();
        //设置头，把UTF-8转化成ISO-8859-1，不然浏览器弹出文件名为中文时会乱码
        headers.setContentDispositionFormData("attachment",new String("兼职表.xls".getBytes("UTF-8"),"ISO-8859-1"));
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        workbook.write(baos);

        return new ResponseEntity<byte[]>(baos.toByteArray(),headers, HttpStatus.CREATED);
    }

    //Excel解析成员工集合

    public static List<Job> excel2Job(MultipartFile file) throws IOException {
        List<Job> list=new ArrayList<>();
        Job job=null;
        //创建一个 workbook 对象
        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        //获取 workbook 中表单的数量
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            //获取表单
            HSSFSheet sheet = workbook.getSheetAt(i);
            //获取获取表单中的行数
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            //遍历行
            for (int j = 0; j < physicalNumberOfRows; j++) {
                if(j==0){
                    continue;//跳过标题行
                }
                //获取行
                HSSFRow row = sheet.getRow(j);
                if(row==null){
                    continue;//防止数据中间 有空行
                }
                //获取表单里的列数
                int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                job =new Job();
                for (int k = 0; k < physicalNumberOfCells; k++) {
                    HSSFCell cell = row.getCell(k);
                    switch (cell.getCellType()){
                        case STRING:
                            String cellValue = cell.getStringCellValue();
                            switch (k){
                                case 1:
                                    job.setName(cellValue);
                                    break;
                                case 3:
                                    job.setJobtime(cellValue);
                                    break;
                                case 4:
                                    job.setWorkplace(cellValue);
                                    break;
                                case 5:
                                    job.setSalary(cellValue);
                                    break;
                                case 8:
                                    job.setDetails(cellValue);
                                    break;
                            }
                            break;
                        default:{
                            switch (k){
                                case 2:
                                    job.setBeginDate(cell.getDateCellValue());
                                    break;
                                case 6:
                                    job.setNum((int) cell.getNumericCellValue());
                                    break;
                                case 7:
                                    job.setState((int) cell.getNumericCellValue());
                                    break;
                                case 9:
                                    job.setEndDate(cell.getDateCellValue());
                                    break;
                                case 10:
                                    job.setBusinessid((int) cell.getNumericCellValue());
                                    break;
                                case 11:
                                    job.setPosttime(cell.getDateCellValue());
                                    break;
                            }
                        }
                        break;
                    }
                }
                list.add(job);
            }
        }
        return list;
    }
}
