package kr.board.controller;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelImageInsert {

    public static void main(String[] args) throws IOException {
        // 콘솔에서 이미지 파일 경로를 입력받습니다.
        System.out.print("이미지 파일 경로를 입력하세요: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String imagePath = reader.readLine();

        try (
                FileInputStream fis = new FileInputStream(imagePath);
                Workbook workbook = new XSSFWorkbook();
                FileOutputStream fos = new FileOutputStream("output.xlsx")
        ) {
            // 이미지 파일을 읽어서 바이트 배열로 변환합니다.
            byte[] imageBytes = IOUtils.toByteArray(fis);
            int imageIndex = workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);

            // 시트를 생성하고 1행 1열 셀에 이미지를 추가합니다.
            Sheet sheet = workbook.createSheet("Image Sheet");
            CreationHelper helper = workbook.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();

            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(0);

            Picture picture = drawing.createPicture(anchor, imageIndex);
            picture.resize(); // 이미지 크기를 셀 크기에 맞게 조절합니다.

            // 엑셀 파일을 저장합니다.
            workbook.write(fos);
        }

        System.out.println("이미지가 엑셀 파일에 저장되었습니다.");
    }
}

