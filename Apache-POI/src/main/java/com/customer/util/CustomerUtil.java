package com.customer.util;

import java.io.FileOutputStream;


import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.customer.model.Customer;
import com.customer.repo.CustomerRepo;
import com.mysql.cj.result.Row;

@Configuration
public class CustomerUtil {
	@Autowired
	private CustomerRepo repo;

	public void generateExcel(HttpServletResponse response) throws Exception {

		List<Customer> customer = repo.findAll();

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("Customer Info");
		XSSFCellStyle cellstyle1 = workbook.createCellStyle();
		cellstyle1.setBorderBottom(BorderStyle.THICK);
		cellstyle1.setBottomBorderColor(IndexedColors.MAROON.getIndex());
		cellstyle1.setFillBackgroundColor(IndexedColors.RED.getIndex());
		cellstyle1.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
		cellstyle1.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		XSSFRow row = sheet1.createRow(0);

		row.createCell(0).setCellValue("Customer Id");
		row.getCell(0).setCellStyle(cellstyle1);
		row.createCell(1).setCellValue("Customer Order Id");
		row.getCell(1).setCellStyle(cellstyle1);
		row.createCell(2).setCellValue("Customer Name");
		row.getCell(2).setCellStyle(cellstyle1);
		row.createCell(3).setCellValue("Customer Contact");
		row.getCell(3).setCellStyle(cellstyle1);
		row.createCell(4).setCellValue("Customer Status");
		row.getCell(4).setCellStyle(cellstyle1);

		int dataRowIndex = 1;

		for (Customer customers : customer) {

			XSSFRow dataRow = sheet1.createRow(dataRowIndex);

			dataRow.createCell(0).setCellValue(customers.getCustomerId());
			dataRow.createCell(1).setCellValue(customers.getCustomerOrderId());
			dataRow.createCell(2).setCellValue(customers.getCustomerName());
			dataRow.createCell(3).setCellValue(customers.getCustomerContact());
			dataRow.createCell(4).setCellValue(customers.getCustomerStatus());
			dataRowIndex++;
		}
		FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
		ServletOutputStream ops = response.getOutputStream();
		workbook.write(ops);
		workbook.close();
		ops.close();
	}
}
