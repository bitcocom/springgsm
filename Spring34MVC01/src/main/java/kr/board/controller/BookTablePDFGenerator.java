package kr.board.controller;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import com.itextpdf.layout.property.VerticalAlignment;

public class BookTablePDFGenerator {
    
    public static void main(String[] args) throws MalformedURLException, IOException {
        String dest = "book_table.pdf";
        File file = new File(dest);
        //file.getParentFile().mkdirs();
        new BookTablePDFGenerator().createPdf(dest);
    }

    public void createPdf(String dest) throws MalformedURLException, IOException {
        List<Map<String, String>> books = createDummyData();

        // Initialize PDF writer and PDF document
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4);

        // Initialize fonts
        PdfFont headerFont = null;
        PdfFont bodyFont = null;
        try {
            headerFont = PdfFontFactory.createFont("NANUMGOTHICLIGHT.TTF", "Identity-H", true);
            bodyFont = PdfFontFactory.createFont("NANUMGOTHICLIGHT.TTF", "Identity-H", true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Initialize table
        float[] columnWidths = {1, 2, 2, 2, 2, 2};
        Table table = new Table(UnitValue.createPercentArray(columnWidths));
        table.setWidth(UnitValue.createPercentValue(100));

        // Initialize table header cells
        Cell headerCell1 = new Cell().add(new Paragraph("순번")).setFont(headerFont);
        Cell headerCell2 = new Cell().add(new Paragraph("제목")).setFont(headerFont);
        Cell headerCell3 = new Cell().add(new Paragraph("저자")).setFont(headerFont);
        Cell headerCell4 = new Cell().add(new Paragraph("출판사")).setFont(headerFont);
        Cell headerCell5 = new Cell().add(new Paragraph("출판일")).setFont(headerFont);
        Cell headerCell6 = new Cell().add(new Paragraph("이미지")).setFont(headerFont);
        table.addHeaderCell(headerCell1);
        table.addHeaderCell(headerCell2);
        table.addHeaderCell(headerCell3);
        table.addHeaderCell(headerCell4);
        table.addHeaderCell(headerCell5);
        table.addHeaderCell(headerCell6);
        // Add table body cells
        int rowNum = 1;
        for (Map<String, String> book : books) {
            String title = book.get("title");
            String authors = book.get("authors");
            String publisher = book.get("publisher");
            String publishedDate = book.get("publishedDate");
            String thumbnail= book.get("thumbnail");
            Cell rowNumCell = new Cell().add(new Paragraph(String.valueOf(rowNum))).setFont(bodyFont);
            table.addCell(rowNumCell);
            Cell titleCell = new Cell().add(new Paragraph(title)).setFont(bodyFont);
            table.addCell(titleCell);
            Cell authorsCell = new Cell().add(new Paragraph(authors)).setFont(bodyFont);
            table.addCell(authorsCell);
            Cell publisherCell = new Cell().add(new Paragraph(publisher)).setFont(bodyFont);
            table.addCell(publisherCell);
            Cell publishedDateCell = new Cell().add(new Paragraph(publishedDate)).setFont(bodyFont);
            table.addCell(publishedDateCell);
            // 커버 이미지 추가
            if (thumbnail != null && !thumbnail.isEmpty()) {
                // URL로부터 이미지 다운로드
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                URL url = new URL(thumbnail);
                InputStream input = url.openStream();
                byte[] buffer = new byte[4096];
             // Continue with the code
                int bytesRead;
                while ((bytesRead = input.read(buffer, 0, 4096)) != -1) {
                output.write(buffer, 0, bytesRead);
                }
                output.flush();
                output.close();
                input.close();
                // 다운로드 받은 이미지를 PDF에 추가
                ImageData imageData = ImageDataFactory.create(output.toByteArray());
                Image coverImage = new Image(imageData);
                Cell imageCell = new Cell().add(coverImage.setAutoScale(true));
                table.addCell(imageCell);
                }
                rowNum++;
                }
                // Add table to document
              document.add(table);

               // Close document
              document.close();
     }
                
    private static List<Map<String, String>> createDummyData() {
    	   List<Map<String, String>> books = new ArrayList<>();
           Scanner scanner = new Scanner(System.in);
           System.out.print("책 개수를 입력하세요: ");
           int bookCount = scanner.nextInt();
           scanner.nextLine(); // 개행 문자 제거

           for (int i = 1; i <= bookCount; i++) {
               Map<String, String> book = new HashMap<>();

               System.out.printf("\n[ %d번째 책 정보 입력 ]\n", i);
               System.out.print("제목: ");
               book.put("title", scanner.nextLine());

               System.out.print("저자: ");
               book.put("authors", scanner.nextLine());

               System.out.print("출판사: ");
               book.put("publisher", scanner.nextLine());

               System.out.print("출판일(YYYY-MM-DD): ");
               book.put("publishedDate", scanner.nextLine());

               System.out.print("썸네일 URL: ");
               book.put("thumbnail", scanner.nextLine());

               books.add(book);
           }
           scanner.close();
        return books;
    }

}