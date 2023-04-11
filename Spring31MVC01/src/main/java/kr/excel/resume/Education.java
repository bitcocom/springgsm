package kr.excel.resume;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    private String graduationYear;
    private String schoolName;
    private String major;
    private String graduationStatus;

    // 생성자, Getter, Setter
}

