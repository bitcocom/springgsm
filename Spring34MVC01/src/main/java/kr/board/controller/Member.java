package kr.board.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
    private String name;
    private int age;
    private Date birthdate;
    private String email;
    private String address;
    private boolean married;
    public Member() {   }
    public Member(String name, int age, Date birthdate, String email, String address, boolean married) {
        this.name = name;
        this.age = age;
        this.birthdate = birthdate;
        this.email = email;
        this.address = address;
        this.married = married;
    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
    // getter/setter 생략
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedBirthdate = dateFormat.format(birthdate);
		return "Member [name=" + name + ", age=" + age + ", birthdate=" + formattedBirthdate + ", email=" + email + ", address="
				+ address + ", married=" + married + "]";
	}
	
}

