package kr.board.entity;

import lombok.Data;

@Data
public class Member {
   private int idx; // 일련번호
   private String username; // 아이디
   private String password; // 비밀번호
   private String name; // 이름
   private String email; // 이메일
   // setter, getter method ... Lombok API   
}
