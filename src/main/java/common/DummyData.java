package common;

import lombok.Getter;
import model.GradeInfo;
import model.Subject;
import model.User;
import model.UserType;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DummyData{

    private final List<User> users = new ArrayList<>();
    private final List<User> students = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();
    private final List<GradeInfo> gradeInfos = new ArrayList<>();
  
    public DummyData(){
    	
    }
    
    //더미데이터 초기화
    public void init() {

        //교수
        User user_1 = User.builder().id(0L).name("홍성준").userId("홍성준")
                .password("1111").userType(UserType.PROFESSOR).build();

        users.add(user_1);

        //학생
        User user_2 = User.builder().id(1L).name("한현수").userId("201814043")
                .password("1111").userType(UserType.STUDENT).build();

        User user_3 = User.builder().id(2L).name("한상훈").userId("201732037")
                .password("1111").userType(UserType.STUDENT).build();

        User user_4 = User.builder().id(3L).name("최준호").userId("201632033")
                .password("1111").userType(UserType.STUDENT).build();

        User user_5 = User.builder().id(4L).name("정민석").userId("201632028")
                .password("1111").userType(UserType.STUDENT).build();

        users.add(user_2);
        users.add(user_3);
        users.add(user_4);
        users.add(user_5);

        students.add(user_2);
        students.add(user_3);
        students.add(user_4);
        students.add(user_5);

        //과목
        Subject subject_1 = Subject.builder().id(100L).name("자바 프로젝트").location("6201")
                .startTime("09:00").endTime("11:50").teacher(user_1).students(students)
                .build();

        subjects.add(subject_1);

        //성적
        //자바 프로젝트
        //한현수 학생
        GradeInfo gradeInfo_1 = GradeInfo.builder().id(0L).subject(subject_1).student(user_2)
                .attendanceScore(10).midtermExamScore(42).finalExamScore(43).totalScore(95)
                .grade("A+").note("참 잘했어요.").build();

        //한상훈 학생
        GradeInfo gradeInfo_2 = GradeInfo.builder().id(1L).subject(subject_1).student(user_3)
                .attendanceScore(9).midtermExamScore(41).finalExamScore(42).totalScore(92)
                .grade("A").note("참 잘했어요.").build();

        //최준호 학생
        GradeInfo gradeInfo_3 = GradeInfo.builder().id(3L).subject(subject_1).student(user_4)
                .attendanceScore(8).midtermExamScore(40).finalExamScore(40).totalScore(88)
                .grade("B+").note("잘했어요.").build();

        //정민석 학생
        GradeInfo gradeInfo_4 = GradeInfo.builder().id(4L).subject(subject_1).student(user_5)
                .attendanceScore(7).midtermExamScore(30).finalExamScore(40).totalScore(77)
                .grade("C+").note("분발하세요.").build();

        gradeInfos.add(gradeInfo_1);
        gradeInfos.add(gradeInfo_2);
        gradeInfos.add(gradeInfo_3);
        gradeInfos.add(gradeInfo_4);

    }
       
    //메인메소드
//    public static void main(String[] args) {
//
//    	//더미데이터 초기화
//        DummyData dummyData = new DummyData();
//        dummyData.init();
//    }
}
