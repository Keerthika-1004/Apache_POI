package com.customer.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.model.Customer;
import com.customer.service.CustomerService;
import com.customer.util.CustomerUtil;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	@Autowired
	private CustomerUtil util;

	@PostMapping(value = "createCustomer")
	public String insertCustomer(@RequestBody Customer customer) {
		service.insertCustomer(customer);
		return "Customer added successfully";

	}

	@GetMapping("excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception {

		response.setContentType("application/octet-stream");

//		String headerKey = "Content-Disposition";
//		String headerValue = "attachment;filename=courses.xls";

		LocalDateTime now = LocalDateTime.now();
		Date creationDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		response.setHeader("Content-Disposition", "filename=customer.xls");

		util.generateExcel(response);
		response.flushBuffer();
	}

}
