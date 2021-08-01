package com.cosyfish.autosend.service;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.handler.inter.IReadHandler;
import com.cosyfish.autosend.config.OhMyEmail;
import com.cosyfish.autosend.excel.DailyExcelDto;
import com.cosyfish.autosend.excel.KeywordReprotDto;
import com.cosyfish.autosend.mapper.ExcelMapper;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ExcelService {


    @Autowired
    private ExcelMapper excelMapper;

    public Object exportExcel() throws Exception {
        OhMyEmail.config(OhMyEmail.SMTP_QQ(false),"","");
        System.setProperty("mail.mime.splitlongparameters", "false");
        OhMyEmail ohMyEmail = OhMyEmail.subject("这是一封测试TEXT邮件")
                .from("邮箱")
                .to("")
                .html("测试");
        for (int i = 0; i < 2; i++) {
            List<DailyExcelDto> list = new ArrayList<>();
            DailyExcelDto dailyExcelDto = new DailyExcelDto("1");
            list.add(dailyExcelDto);
            ExportParams ex = new ExportParams(null, "日报");
            ex.setStyle(ExcelExportStylerMathImpl.class);
            Workbook workbook = ExcelExportUtil.exportExcel(ex,
                    DailyExcelDto.class, list);
//        FileOutputStream fos = new FileOutputStream("D://ExcelTest.xlsx");
//        workbook.write(fos);
//        fos.close();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            workbook.write(byteArrayOutputStream);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ohMyEmail.attachInputStream(inputStream, "测试过长过长过长过长过长过长过长过长过长文件名"+i+".xlsx");
            byteArrayOutputStream.close();
            inputStream.close();
        }
        ohMyEmail.send();
        return "first";
    }




    public static String emojiConvert1(String str)
    {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(
                        sb,
                        "[["
                                + URLEncoder.encode(matcher.group(1),
                                "UTF-8") + "]]");
            } catch(UnsupportedEncodingException e) {
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

}
