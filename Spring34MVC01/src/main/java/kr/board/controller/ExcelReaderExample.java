package kr.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReaderExample {
    public static void main(String[] args) throws IOException {
        // 엑셀 파일 경로
        String filePath = "C:\\basic\\member.xlsx";

        // 엑셀 파일 읽기
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        // 회원 정보 처리
        List<Member> members = new ArrayList<>();
        for (Row row : sheet) {
            String name = null;
            int age = 0;
            Date birthdate = null;
            String formattedBirthdate=null;
            String email = null;
            String address = null;
            boolean married = false;

            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex) {
                    case 0: // 이름
                        name = getStringCellValue(cell);
                        break;
                    case 1: // 나이
                        age = (int) getNumericCellValue(cell);
                        break;
                    case 2: // 생년월일
                        if (DateUtil.isCellDateFormatted(cell)) {
                            birthdate = cell.getDateCellValue();  
                        }
                        break;
                    case 3: // 이메일
                        email = getStringCellValue(cell);
                        break;
                    case 4: // 주소
                        address = getStringCellValue(cell);
                        break;
                    case 5: // 결혼여부
                        married = getBooleanCellValue(cell);
                        break;
                }
            }

            Member member = new Member(name, age, birthdate, email, address, married);
            members.add(member);
        }

        // 회원 정보 출력
        for (Member member : members) {
			/*
			 * System.out.println("Name: " + member.getName()); System.out.println("Age: " +
			 * member.getAge()); System.out.println("Birthdate: " + member.getBirthdate());
			 * System.out.println("Email: " + member.getEmail());
			 * System.out.println("Address: " + member.getAddress());
			 * System.out.println("Married: " + member.isMarried()); System.out.println();
			 */
        	System.out.println(member);
        }

        // 엑셀 파일 닫기
        workbook.close();
        fis.close();
    }

    private static String getStringCellValue(Cell cell) {
        return cell.getStringCellValue();
    }

    private static double getNumericCellValue(Cell cell) {
        return cell.getNumericCellValue();
    }

    private static boolean getBooleanCellValue(Cell cell) {
        return cell.getBooleanCellValue();
    }
}
