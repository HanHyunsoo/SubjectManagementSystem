package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {

    private Long id;
    private String userId;
    private String password;
    private String name;
    @Builder.Default
    private List<Subject> subjects = new ArrayList<>();
    private UserType userType;

    private void addSubject(Subject subject) {
        subjects.add(subject);
    }
}
