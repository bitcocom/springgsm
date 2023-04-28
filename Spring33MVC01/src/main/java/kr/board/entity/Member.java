package kr.board.entity;

import lombok.Data;

@Data
public class Member {
	private int idx;
	private String username; // id
	private String password;
	private String name;
	private String email;	
	// setter, getter ~~~ : Lombok API
}
