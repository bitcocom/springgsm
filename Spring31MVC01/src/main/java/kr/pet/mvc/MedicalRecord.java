package kr.pet.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {
	    private String phoneNumber;
	    private String date;
	    private String content;
}
