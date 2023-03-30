package kr.board.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInfo {
    private String photo;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthDate;

    // 생성자, Getter, Setter
}
