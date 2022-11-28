package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class Subject {

    private Long id;
    private String name;
    private String location;
    private String startTime;
    private String endTime;
    private User teacher;
    private List<User> students;

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public void addStudent(User student) {
        students.add(student);
    }
}
