package kr.excel.resume;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Career {
	private String workPeriod;
	private String companyName;
	private String jobTitle;
	private String employmentYears;

    // 생성자, Getter, Setter
}

