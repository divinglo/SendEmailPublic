package com.cosyfish.autosend.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@AllArgsConstructor
@Data
public class DailyExcelDto implements Serializable {

     @Excel(name = "站点")
     private String site;

}
