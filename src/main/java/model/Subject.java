package model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Subject {

    private Long id;
    private String name;
    private String location;
    private String startTime;
    private String endTime;
    private Professor teacher;
    private List<Student> students;

    public void setTeacher(Professor teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
}
