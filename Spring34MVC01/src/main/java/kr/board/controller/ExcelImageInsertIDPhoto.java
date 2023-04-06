package kr.board.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Font;
import java.awt.font.FontRenderContext;
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
        
         // 4. Create Drawing Object
            Drawing<?> drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 0, 1, 1);
         // 6. Create Picture Object
            Picture pict = drawing.createPicture(anchor, imageIndex);

            // 7. Set Height of the Row           
            Row row = sheet.createRow(0);
            row.setHeightInPoints(newHeight*72/96); // 픽셀을 point로변경

            // 8. Get Image Width
            // int imageWidth = pict.getImageDimension().width;

            // 9. Set Column Width
            int columnWidth = (int) Math.floor(((float) newWidth / (float) 8) * 256);
            sheet.setColumnWidth(0, columnWidth);

            //picture.resize(); // 이미지 크기를 원본 크기로 유지합니다.

            // 엑셀 파일을 저장합니다.
            workbook.write(fos);
        }

        System.out.println("이미지와 셀 크기가 조절된 엑셀 파일에 저장되었습니다.");
    }
}
