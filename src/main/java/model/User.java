package model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class User {

    protected Long id;
    protected String userId;
    protected String password;
    protected String name;
    protected List<Subject> subjects = new ArrayList<>();

    protected void addSubject(Subject subject) {
        subjects.add(subject);
    }
}
