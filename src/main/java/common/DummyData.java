package common;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import model.GradeInfo;
import model.Professor;
import model.Student;
import model.Subject;

@Getter
public class DummyData {

    private final List<Professor> professors = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();
    private final List<GradeInfo> gradeInfos = new ArrayList<>();

    public void init() {
        // TODO: 2022/11/04 @정민석 이런식으로 더미데이터 만들면 될 것 같습니다!! 많이는 말고 저희 정도만 만들면 될 것같아요
        Student student = Student.builder()
                                 .id(0L)
                                 .name("한현수")
                                 .userId("201814043")
                                 .password("1111")
                                 .build();
        
        students.add(student);

    }
}
