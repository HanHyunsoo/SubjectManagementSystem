package common;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import model.GradeInfo;
import model.Professor;
import model.Student;
import model.Subject;
import model.User;

@Getter
public class DummyData {

    private final List<Professor> professors = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Subject> subjects = new ArrayList<>();
    private final List<GradeInfo> gradeInfos = new ArrayList<>();

    public void init() {
    	
    	//����
    	//Professor�� UserŬ������ �ִ� �ʵ� �� �޾ƿ�����?
    	Professor professor_1 = Professor.builder()
    									.build();
    									
    	professors.add(professor_1);	
    	
    	//�л�
        Student student_1 = Student.builder()
                                 .id(0L)
                                 .name("������")
                                 .userId("201814043")
                                 .password("1111")
                                 .build();
        
        Student student_2 = Student.builder()
						         .id(1L)
						         .name("�ѻ���")
						         .userId("201714043")
						         .password("2222")
						         .build();
        
        Student student_3 = Student.builder()
						         .id(2L)
						         .name("����ȣ")
						         .userId("201632033")
						         .password("3333")
						         .build();
        
        Student student_4 = Student.builder()
						         .id(3L)
						         .name("���μ�")
						         .userId("201632028")
						         .password("4444")
						         .build();
        
        students.add(student_1);
        students.add(student_2);
        students.add(student_3);
        students.add(student_4);
        
        //����
        Subject subject_1 = Subject.builder()
        							.id(100L)
        							.name("�ڹ� ������Ʈ")
        							.location("6201")
        							.startTime("09:00")
        							.endTime("11:50")
        							.teacher(professor_1)
        							.students(students)
        							.build();
        
        subjects.add(subject_1);
        
        //����
        //�ڹ� ������Ʈ
        //������ �л�
        GradeInfo gradeInfo_1 = GradeInfo.builder()
        								.id(0L)
        								.subject(subject_1)
        								.student(student_1)
        								.attendanceScore(10)
        								.midtermExamScore(42)
        								.finalExamScore(43)
        								.totalScore(95)
        								.grade("A+")
        								.note("�� ���߾��.")
        								.build();
        
        //�ѻ��� �л�
        GradeInfo gradeInfo_2 = GradeInfo.builder()
										.id(1L)
										.subject(subject_1)
										.student(student_2)
										.attendanceScore(9)
										.midtermExamScore(41)
										.finalExamScore(42)
										.totalScore(92)
										.grade("A")
										.note("�� ���߾��.")
										.build();
        
        //����ȣ �л�
        GradeInfo gradeInfo_3 = GradeInfo.builder()
										.id(3L)
										.subject(subject_1)
										.student(student_3)
										.attendanceScore(8)
										.midtermExamScore(40)
										.finalExamScore(40)
										.totalScore(88)
										.grade("B+")
										.note("���߾��.")
										.build();
        
        //���μ� �л�
        GradeInfo gradeInfo_4 = GradeInfo.builder()
										.id(4L)
										.subject(subject_1)
										.student(student_4)
										.attendanceScore(7)
										.midtermExamScore(30)
										.finalExamScore(40)
										.totalScore(77)
										.grade("C+")
										.note("�й��ϼ���.")
										.build();
        
        gradeInfos.add(gradeInfo_1);
        gradeInfos.add(gradeInfo_2);
        gradeInfos.add(gradeInfo_3);
        gradeInfos.add(gradeInfo_4);
        
    }
}
