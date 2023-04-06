package kr.book.search;

import java.io.IOException;
import java.util.List;

public class BookSearchMain {
    public static void main(String[] args) {
        try {
            String bookTitle = "자바";
            List<Book> books = KakaoBookApi.searchBooks(bookTitle);

            if (books.isEmpty()) {
                System.out.println("검색 결과가 없습니다.");
            } else {
                String fileName = "도서목록.pdf";
                PdfGenerator.generateBookListPdf(books, fileName);
                System.out.println(fileName + " 파일이 생성되었습니다.");
            }
        } catch (IOException e) {
            System.err.println("에러가 발생했습니다: " + e.getMessage());
        }
    }
}

