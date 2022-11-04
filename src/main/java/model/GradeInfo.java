package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class GradeInfo {

    private Long id;
    private Subject subject;
    private Student student;
    private Integer attendanceScore;
    private Integer midtermExamScore;
    private Integer finalExamScore;
    private Integer totalScore;
    private String grade;
    private String note;
}
