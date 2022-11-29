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
    private User student;
    private Integer attendanceScore;
    private Integer midtermExamScore;
    private Integer finalExamScore;
    private Integer totalScore;
    private String grade;
    private String note;

    public void update(Integer attendanceScore, Integer midtermExamScore, Integer finalExamScore, Integer totalScore, String grade, String note) {
        this.attendanceScore = attendanceScore;
        this.midtermExamScore = midtermExamScore;
        this.finalExamScore = finalExamScore;
        this.totalScore = totalScore;
        this.grade = grade;
        this.note = note;
    }
}
