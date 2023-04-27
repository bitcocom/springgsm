package kr.board.entity;

import lombok.Data;

// 번호, 아이디, 패스워드, 이름, 이메일...
@Data
public class Member {
  private int idx; 
  private String username;
  private String password;
  private String name;
  private String email;
  // 권한?
}
