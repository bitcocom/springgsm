package kr.board.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResumeController {
    private ResumeView view;
    private Workbook workbook;

    public ResumeController() {
        view = new ResumeView();
        workbook = new XSSFWorkbook();
    }

    public void createResume() {
        PersonInfo personInfo = view.inputPersonInfo();
        List<Education> educationList = view.inputEducationList();
        List<Career> careerList = view.inputCareerList();
        String selfIntroduction = view.inputSelfIntroduction();

        createResumeSheet(personInfo, educationList, careerList);
        createSelfIntroductionSheet(selfIntroduction);

        saveWorkbookToFile();
        
        System.out.println("이력서 생성이 완료되었습니다.");
    }

    private void createResumeSheet(PersonInfo personInfo, List<Education> educationList, List<Career> careerList) {
        Sheet sheet = workbook.createSheet("이력서");

        // 헤더 생성
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("사진");
        headerRow.createCell(1).setCellValue("이름");
        headerRow.createCell(2).setCellValue("이메일");
        headerRow.createCell(3).setCellValue("주소");
        headerRow.createCell(4).setCellValue("전화번호");
        headerRow.createCell(5).setCellValue("생년월일");

        // 데이터 삽입
        Row dataRow = sheet.createRow(1);
        String photoFilename = personInfo.getPhoto();
        try (InputStream photoStream = new FileInputStream(photoFilename)) {
            byte[] photoBytes = IOUtils.toByteArray(photoStream);
            int pictureIndex = workbook.addPicture(photoBytes, Workbook.PICTURE_TYPE_PNG);
            CreationHelper creationHelper = workbook.getCreationHelper();
            ClientAnchor anchor = creationHelper.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(1);
            anchor.setCol2(1);
            anchor.setRow2(2);
            Drawing<?> drawing = sheet.createDrawingPatriarch();
            Picture picture = drawing.createPicture(anchor, pictureIndex);
            picture.resize();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        dataRow.createCell(1).setCellValue(personInfo.getName());
        dataRow.createCell(2).setCellValue(personInfo.getEmail());
        dataRow.createCell(3).setCellValue(personInfo.getAddress());
        dataRow.createCell(4).setCellValue(personInfo.getPhoneNumber());
        dataRow.createCell(5).setCellValue(personInfo.getBirthDate());

        // 학력사항 헤더 생성
        int educationStartRow = 3;
        Row educationHeaderRow = sheet.createRow(educationStartRow - 1);
        educationHeaderRow.createCell(0).setCellValue("졸업년도");
        educationHeaderRow.createCell(1).setCellValue("학교명");
        educationHeaderRow.createCell(2).setCellValue("전공");
        educationHeaderRow.createCell(3).setCellValue("졸업여부");

        // 학력사항 데이터 삽입
        int educationRowNum = educationStartRow;
        for (Education education : educationList) {
            Row educationDataRow = sheet.createRow(educationRowNum++);
            educationDataRow.createCell(0).setCellValue(education.getGraduationYear());
            educationDataRow.createCell(1).setCellValue(education.getSchoolName());
            educationDataRow.createCell(2).setCellValue(education.getMajor());
            educationDataRow.createCell(3).setCellValue(education.getGraduationStatus());
        }

        // 경력사항 헤더 생성
        int careerStartRow = educationRowNum + 1;
        Row careerHeaderRow = sheet.createRow(careerStartRow - 1);
        careerHeaderRow.createCell(0).setCellValue("근무기간");
        careerHeaderRow.createCell(1).setCellValue("근무처");
        careerHeaderRow.createCell(2).setCellValue("담당업무");
        careerHeaderRow.createCell(3).setCellValue("근속연수");

        // 경력사항 데이터 삽입
        int careerRowNum = careerStartRow;
        for (Career career : careerList) {
            Row careerDataRow = sheet.createRow(careerRowNum++);
            careerDataRow.createCell(0).setCellValue(career.getWorkPeriod());
            careerDataRow.createCell(1).setCellValue(career.getCompanyName());
            careerDataRow.createCell(2).setCellValue(career.getJobTitle());
            careerDataRow.createCell(3).setCellValue(career.getEmploymentYears());

        }
    }

    private void createSelfIntroductionSheet(String selfIntroduction) {
        Sheet sheet = workbook.createSheet("자기소개서");

        // 데이터 삽입
        Row dataRow = sheet.createRow(0);
        Cell selfIntroductionCell = dataRow.createCell(0);
        selfIntroductionCell.setCellStyle(getWrapCellStyle());
        selfIntroductionCell.setCellValue(new XSSFRichTextString(selfIntroduction.replaceAll("\n", String.valueOf((char) 10))));
    }

    private XSSFCellStyle getWrapCellStyle() {
        XSSFCellStyle style = (XSSFCellStyle) workbook.createCellStyle();
        style.setWrapText(true);
        return style;
    }

    private void saveWorkbookToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("이력서.xlsx")) {
            workbook.write(fileOut);          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ResumeController controller = new ResumeController();
        controller.createResume();
    }
}
