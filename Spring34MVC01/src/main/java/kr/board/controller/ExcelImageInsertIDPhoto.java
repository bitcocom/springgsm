package kr.board.controller;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ExcelImageInsertIDPhoto {

    public static void main(String[] args) throws IOException {
        // 콘솔에서 이미지 파일 경로를 입력받습니다.
        System.out.print("이미지 파일 경로를 입력하세요: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String imagePath = reader.readLine();

        // 원본 이미지를 읽어옵니다.
        BufferedImage originalImage = ImageIO.read(new File(imagePath));

        // 증명사진 크기로 이미지를 조절합니다. (가로 35mm, 세로 45mm)
        int newWidth = (int) (35 * 2.83465); // mm 단위를 픽셀 단위로 변환합니다 (1mm = 2.83465px).
        int newHeight = (int) (45 * 2.83465); // mm 단위를 픽셀 단위로 변환합니다 (1mm = 2.83465px).
        Image resizedImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage resizedBufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedBufferedImage.createGraphics();
        g2d.drawImage(resizedImage, 0, 0, null);
        g2d.dispose();

        try (
                Workbook workbook = new XSSFWorkbook();
                FileOutputStream fos = new FileOutputStream("output.xlsx")
        ) {
            // 조절된 이미지를 바이트 배열로 변환합니다.
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(resizedBufferedImage, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            int imageIndex = workbook.addPicture(imageBytes, Workbook.PICTURE_TYPE_PNG);

            // 시트를 생성하고 이미지 크기에 맞게 1행 1열 셀의 크기를 조절합니다.
            Sheet sheet = workbook.createSheet("Image Sheet");
         // 이미지의 너비를 포인트 단위로 변환합니다.
            double widthInPoints = (newWidth / 96.0) * 72.0; // (1px = 1/96 inches, 1 inch = 72 points)

            // 문자 '0'의 너비를 고려하여 열 너비를 설정합니다.
            double defaultCharWidthInPoints = sheet.getDefaultColumnWidth() * 0.5 * 72 / 96; // 기본 열 너비를 포인트 단위로 변환합니다.
            double widthInChars = widthInPoints / defaultCharWidthInPoints;
            int widthInUnits = (int) (Math.ceil(widthInChars * 256)); // 엑셀의 열 너비 단위에 맞추기 위해 256을 곱해줍니다.
            sheet.setColumnWidth(0, (int) widthInChars); // 셀 너비를 설정합니다.
            
            float cellHeight = newHeight * 0.75f; // 이미지 높이를 포인트로 변환합니다.
            sheet.createRow(0).setHeightInPoints(cellHeight); // 셀 높이를 설정합니다.

            // 1행 1열 셀에 이미지를 추가합니다.
            CreationHelper helper = workbook.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();

            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(0);
            anchor.setDx1(0);
            anchor.setDy1(0);
            anchor.setDx2(Units.pixelToEMU(newWidth));
            anchor.setDx2(Units.pixelToEMU(newHeight));
            //anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);

            Picture picture = drawing.createPicture(anchor, imageIndex);
            picture.resize(); // 이미지 크기를 원본 크기로 유지합니다.
            
            //picture.resize(); // 이미지 크기를 원본 크기로 유지합니다.

            // 엑셀 파일을 저장합니다.
            workbook.write(fos);
        }

        System.out.println("이미지와 셀 크기가 조절된 엑셀 파일에 저장되었습니다.");
    }
}
