package kr.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Picture;

public class ExcelImageExample {
    public static void main(String[] args) throws IOException {
        // 1. Create Workbook
        Workbook workbook = new XSSFWorkbook();

        // 2. Create Sheet
        Sheet sheet = workbook.createSheet("Image Sheet");

        // 3. Load Image
        InputStream inputStream = new FileInputStream("kim.PNG");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
        inputStream.close();

        // 4. Create Drawing Object
        Drawing<?> drawing = sheet.createDrawingPatriarch();

        // 5. Create Anchor for Image
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 0, 1, 1);

        // 6. Create Picture Object
        Picture pict = drawing.createPicture(anchor, pictureIdx);

        // 7. Set Height of the Row
        int imageHeight = pict.getImageDimension().height;       
        Row row = sheet.createRow(0);
        row.setHeightInPoints(imageHeight*72/96);

        // 8. Get Image Width
        int imageWidth = pict.getImageDimension().width;

        // 9. Set Column Width
        int columnWidth = (int) Math.floor(((float) imageWidth / (float) 8) * 256);
        sheet.setColumnWidth(0, columnWidth);

        // 10. Write to File
        FileOutputStream out = new FileOutputStream(new File("ExcelWithImage.xlsx"));
        workbook.write(out);
        out.close();

        System.out.println("Excel file written successfully!");
    }
}

