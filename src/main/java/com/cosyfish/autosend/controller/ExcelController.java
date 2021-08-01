package com.cosyfish.autosend.controller;

import com.cosyfish.autosend.service.EmailService;
import com.cosyfish.autosend.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelController {

    @Autowired
    private ExcelService excelService;


    @Autowired
    private EmailService emailService;

    @GetMapping("test")
    private Object test() throws Exception {
        return excelService.exportExcel();
    }

    @GetMapping("testEmail")
    private Object testEmail() throws Exception {
        return null;
    }
}
