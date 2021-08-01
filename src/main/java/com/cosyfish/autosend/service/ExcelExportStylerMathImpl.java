package com.cosyfish.autosend.service;

import cn.afterturn.easypoi.excel.entity.params.ExcelExportEntity;
import cn.afterturn.easypoi.excel.entity.params.ExcelForEachParams;
import cn.afterturn.easypoi.excel.export.styler.AbstractExcelExportStyler;
import cn.afterturn.easypoi.excel.export.styler.IExcelExportStyler;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;


public class ExcelExportStylerMathImpl implements IExcelExportStyler {

    protected CellStyle stringNoneStyle;
    protected CellStyle stringNoneWrapStyle;
    protected CellStyle stringSeptailStyle;
    protected CellStyle stringSeptailWrapStyle;
    protected Workbook workbook;
    protected static final short STRING_FORMAT = (short) BuiltinFormats.getBuiltinFormat("0.00%");



    public ExcelExportStylerMathImpl(Workbook workbook) {
        this.createStyles(workbook);
    }

    protected void createStyles(Workbook workbook) {
        this.stringNoneStyle = this.stringNoneStyle(workbook, false);
        this.stringNoneWrapStyle = this.stringNoneStyle(workbook, true);
        this.stringSeptailStyle = this.stringSeptailStyle(workbook, false);
        this.stringSeptailWrapStyle = this.stringSeptailStyle(workbook, true);
        this.workbook = workbook;
    }

    @Override
    public CellStyle getHeaderStyle(short i) {
        return null;
    }

    @Override
    public CellStyle getTitleStyle(short i) {
        return null;
    }

    @Override
    public CellStyle getStyles(boolean b, ExcelExportEntity excelExportEntity) {
        CellStyle styles = workbook.createCellStyle();
        if(excelExportEntity!=null && "".equals(excelExportEntity.getName())){
            styles.setDataFormat(STRING_FORMAT);
        }
        return styles;
    }

    @Override
    public CellStyle getStyles(Cell cell, int dataRow, ExcelExportEntity entity, Object obj, Object data) {
        return this.getStyles(dataRow % 2 == 1, entity);
    }

    public CellStyle stringNoneStyle(Workbook workbook, boolean isWarp) {
        return null;
    }

    public CellStyle stringSeptailStyle(Workbook workbook, boolean isWarp) {
        return null;
    }

    @Override
    public CellStyle getTemplateStyles(boolean isSingle, ExcelForEachParams excelForEachParams) {
        return null;
    }


}
