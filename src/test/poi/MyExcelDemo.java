/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package test.poi;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

/**
 * A weekly timesheet created using Apache POI.
 * Usage:
 *  TimesheetDemo -xls|xlsx
 *
 * @author Yegor Kozlov
 */
public class MyExcelDemo {
    private static final String[] titles = {
            "{'title':'序号'}",	"{'title':'论文名称'}", "{'title':'作者'}", "{'title':'提交时间'}", "{'title':'论文类型'}", 
            "{'title':'出版情况','children':[{'title':'出版刊物'},{'title':'出版时间'}]}",
            "{'title':'获奖情况','children':[{'title':'获奖奖项'},{'title':'获奖等级'},{'title':'获奖时间'}]}",
            "{'title':'学科信息'}", "{'title':'审核状态'}"
    };

    public static void main(String[] args) throws Exception {
        Workbook wb = new HSSFWorkbook();

        Map<String, CellStyle> styles = createStyles(wb);

        Sheet sheet = wb.createSheet("Timesheet");
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);

        //title row
        Row titleRow = sheet.createRow(0);
        titleRow.setHeightInPoints(45);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("XX（机构名称）非课题类科研成果论文汇总（20130506-20140503）");
        titleCell.setCellStyle(styles.get("title"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$O$1"));

        //header row
        Row headerRow = sheet.createRow(1);
        sheet.setDefaultColumnWidth(20);
        headerRow.setHeightInPoints(20);
        Cell headerCell;
        for(int i=1;i<titles.length;i++){
        	headerCell = headerRow.createCell(i);
            headerCell.setCellValue(titles[i-1]);
            CellRangeAddress cra = new CellRangeAddress(1,2,i,i);
            sheet.addMergedRegion(cra);
            setBorder(cra,sheet,wb);
            headerCell.setCellStyle(styles.get("header"));
            
        }
        
        // Write the output to a file
        String file = "E:\\test.xls";
//        if(wb instanceof XSSFWorkbook) file += "x";
        FileOutputStream out = new FileOutputStream(file);
        wb.write(out);
        out.close();
    }
    
    public static void setBorder(CellRangeAddress cellRangeAddress, Sheet sheet,  
            Workbook wb) throws Exception {
        RegionUtil.setBorderLeft(1, cellRangeAddress, sheet, wb);  
        RegionUtil.setBorderBottom(1, cellRangeAddress, sheet, wb);  
        RegionUtil.setBorderRight(1, cellRangeAddress, sheet, wb);  
        RegionUtil.setBorderTop(1, cellRangeAddress, sheet, wb);  
          
} 

    /**
     * Create a library of cell styles
     */
    private static Map<String, CellStyle> createStyles(Workbook wb){
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short)18);
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("title", style);

        Font headerFont = wb.createFont();
        headerFont.setFontHeightInPoints((short)11);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerFont.setColor(IndexedColors.BLACK.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(headerFont);
//        style.setWrapText(true);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        
        styles.put("header", style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        styles.put("cell", style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula", style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("formula_2", style);

        return styles;
    }
}
