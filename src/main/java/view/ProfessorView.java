package view;

import common.DummyData;
import model.GradeInfo;
import model.Subject;
import model.User;
import model.UserType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorView {

	private DummyData dummyData;
	private User professor;

	//메인메소드
    public static void main(String[] args) {
		DummyData d = new DummyData();
		d.init();
		User user = d.getUsers().get(0);
        //뷰 생성
        View view = new View(d, user);
        view.MakeView();
    }

	public void init() {
		View view = new View(dummyData, professor);
		view.MakeView();
	}

	public ProfessorView(DummyData dummyData, User professor) {
		this.dummyData = dummyData;
		this.professor = professor;
	}
}

//View 관련
class View extends JFrame implements ActionListener{
	private DummyData dummyData;
	private User professor;

	public View(DummyData dummyData, User professor) {
		this.dummyData = dummyData;
		this.professor = professor;
	}

	//과목, 학생 관리, 메세지 버튼
  private JButton manageSubject, manageStudent, messageBtn, createStudent, createSubject, logout;
  //패널
  private JPanel panel;
  //라벨(과목 관리 시스템, 학교 로고)
  private JLabel label, logo;
  //배경
  private JLabel bgLabel;
  private JPanel bgPanel;
 
  void MakeView(){
	
  	//프레임
  	setTitle("성적관리 시스템");
  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	
  	Container c = getContentPane();
  	c.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
  	
  	setSize(1280, 720);
  	setResizable(false);
  	setLocationRelativeTo(null);

	  this.dummyData = dummyData;
  	//패널
  	panel = new JPanel(null);
  	panel.setBackground(Color.cyan);
  	
  	bgPanel = new JPanel(null);
  	
  	//라벨
  	//배경
  	bgLabel = new JLabel();
  	bgLabel.setIcon(new ImageIcon("images/professor/backGround.png"));
  	bgLabel.setBounds(0, 0, 1080, 720);
  	bgPanel.add(bgLabel);
  	bgPanel.setVisible(true);
  	//로고
  	logo = new JLabel();
    logo.setIcon(new ImageIcon("images/professor/logo(1)(1).png"));
  	logo.setBounds(10, 20, 180, 30);
  	panel.add(logo);
  	//제목
  	label = new JLabel();	
  	label.setBounds(20, 60, 180, 30);
  	label.setFont(new Font("Serif", Font.BOLD, 20));
  	label.setText("성적 관리 시스템");
  	panel.add(label);
  	
  	//과목 관리 버튼
  	manageSubject = new JButton("과목 관리");
  	manageSubject.setBounds(50, 120, 100, 30);
  	panel.add(manageSubject);
  	
  	//학생 관리 버튼
  	manageStudent = new JButton("학생 관리");
  	manageStudent.setBounds(50, 200, 100, 30);
  	panel.add(manageStudent);

	  createStudent = new JButton("학생 생성");
	  createStudent.setBounds(50, 280, 100, 30);
	  createStudent.addActionListener(this);
	  panel.add(createStudent);

	  createSubject = new JButton("과목 생성");
	  createSubject.setBounds(50, 360, 100, 30);
	  createSubject.addActionListener(this);
	  panel.add(createSubject);
  	
  	//메세지 버튼
  	messageBtn = new JButton("메세지");
  	messageBtn.setBounds(50, 440, 100, 30);
  	panel.add(messageBtn);

	  logout = new JButton("로그아웃");
	  logout.setBounds(50, 520, 100, 30);
	  panel.add(logout);

	  manageSubject.addActionListener(this);
  	manageStudent.addActionListener(this);
  	messageBtn.addActionListener(this);
	  logout.addActionListener(this);
  	
  	panel.setPreferredSize(new Dimension(200, 720));
  	add(panel);
  	
  	bgPanel.setPreferredSize(new Dimension(1065, 720));
  	add(bgPanel);
  	
  	setVisible(true);  	
  }
	
	//버튼 클릭 이벤트
  @Override
  public void actionPerformed(ActionEvent e) {
  	if(e.getSource()==manageSubject) {
  		//과목 관리 버튼
  		JFrame SubjectFrame = new SubjectManage(dummyData);
  		SubjectFrame.setSize(1080, 690);
  		SubjectFrame.setLocation(310, 145);
  		//SubjectFrame.setLocationRelativeTo(null);
  		SubjectFrame.setVisible(true);
  		
  	}else if(e.getSource()==manageStudent) {
  		//학생 관리 버튼
  		JFrame StudentFrame = new StudentManage("학생 관리", dummyData.getStudents());
  		StudentFrame.setSize(1080, 690);
  		StudentFrame.setLocation(310, 145);
  		//StudentFrame.setLocationRelativeTo(null);
  		StudentFrame.setVisible(true);
  	} else if (e.getSource()==createStudent) {
		  JFrame jFrame = new JFrame();
		  jFrame.setLayout(new GridLayout(0, 1));
		  jFrame.setSize(150, 200);
//		  JPanel jFrame = new JPanel();
		JTextField nameField = new JTextField();
		JTextField userIdField = new JTextField();
		jFrame.add(new JLabel("이름", SwingConstants.CENTER));
		jFrame.add(nameField);
		jFrame.add(new JLabel("학번", SwingConstants.CENTER));
		jFrame.add(userIdField);
		jFrame.add(new JLabel());
		JButton jButton = new JButton("추가");
		jButton.addActionListener(e1 -> {
			User user = User.builder()
					.id(dummyData.getUsers().size() + 1L)
					.userId(userIdField.getText())
					.password("1111")
					.name(nameField.getText())
					.userType(UserType.STUDENT)
					.build();

			dummyData.getUsers().add(user);
			dummyData.getStudents().add(user);
			jFrame.dispose();
		});
		jFrame.add(jButton);

//		jFrame.add(jFrame);
		jFrame.setVisible(true);
	} else if (e.getSource()==createSubject) {
		JFrame jFrame = new JFrame();
		jFrame.setLayout(new GridLayout(1, 2));
		jFrame.setSize(300, 400);
//		  JPanel jFrame = new JPanel();
		JTextField nameField = new JTextField();
		JTextField locationField = new JTextField();
		JTextField startTimeField = new JTextField();
		JTextField endTimeField = new JTextField();

		Object[][] data = new Object[dummyData.getStudents().size()][2];

		int index = 0;
		for (User student : dummyData.getStudents()) {
			data[index][0] = student.getUserId();
			data[index][1] = student.getName();
			index++;
		}

		String[] columns = {"학번", "이름"};

		JTable table = new JTable(data, columns);
		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(new JLabel("과목명", SwingConstants.CENTER));
		panel.add(nameField);
		panel.add(new JLabel("위치", SwingConstants.CENTER));
		panel.add(locationField);
		panel.add(new JLabel("시작시간", SwingConstants.CENTER));
		panel.add(startTimeField);
		panel.add(new JLabel("종료시간", SwingConstants.CENTER));
		panel.add(endTimeField);
		panel.add(new JLabel());
		JButton jButton = new JButton("추가");
		jButton.addActionListener(e1 -> {
			List<User> students = new ArrayList<>();

			for (int i : table.getSelectedRows()) {
				students.add(dummyData.getStudents().get(i));
			};

			Subject subject = Subject.builder()
					.id(dummyData.getSubjects().size() + 1L)
					.name(nameField.getText())
					.location(locationField.getText())
					.startTime(startTimeField.getText())
					.endTime(endTimeField.getText())
					.teacher(professor)
					.students(students)
					.build();

			students.forEach(x -> {
				x.addSubject(subject);

				GradeInfo gradeInfo = GradeInfo.builder()
						.id(dummyData.getGradeInfos().size() + 1L)
						.subject(subject)
						.student(x)
						.attendanceScore(null)
						.midtermExamScore(null)
						.finalExamScore(null)
						.totalScore(null)
						.grade("미정")
						.note("")
						.build();

				dummyData.getGradeInfos().add(gradeInfo);
			});

			dummyData.getSubjects().add(subject);
			jFrame.dispose();
		});
		panel.add(jButton);
		jFrame.add(panel);

		JPanel panel2 = new JPanel();
		JLabel rightLabel = new JLabel("수강 학생 선택");
		rightLabel.setSize(150, 100);
		panel2.add(rightLabel);
		panel2.add(table);
		jFrame.add(panel2);

//		jFrame.add(jFrame);
		jFrame.setVisible(true);
	} else if(e.getSource()==messageBtn) {
		//메세지 버튼
		JFrame messageFrame = new MessageToStudent();
		messageFrame.setSize(1080, 690);
		messageFrame.setLocation(310, 145);
		//messageFrame.setLocationRelativeTo(null);
		messageFrame.setVisible(true);
	} else if (e.getSource() == logout) {
		  this.dispose();
		  new Loginframe(dummyData).setVisible(true);
	}
  }
}

//과목 관리 버튼 클릭 -> 과목 관리 창
class SubjectManage extends JFrame{

	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	SubjectManage(DummyData dummyData){
		
		super("과목 관리");
		
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return !(col==0);
			}
		};
		
		List<Subject> subjects = dummyData.getSubjects();
		
		Object[][] data = new Object[subjects.size()][6];

		int index = 0;
		for (Subject subject : subjects) {
			data[index][0] = subject.getId();
			data[index][1] = subject.getName();
			data[index][2] = subject.getLocation();
			data[index][3] = subject.getStartTime();
			data[index][4] = subject.getEndTime();
			data[index][5] = subject.getStudents().size();
			index++;
		}


		String[] columns = {"ID", "과목명", "강의실", "시작 시간", "종료 시간", "수강 인원"};
		
//		dtm.setDataVector(data, columns);
		
		JTable table = new JTable();
		table.setModel(new DefaultTableModel(data, columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable table1 = (JTable) e.getSource();
				Subject target = subjects.get(table1.getSelectedRow());

				List<GradeInfo> gradeInfos = dummyData.getGradeInfos().stream().filter(x -> x.getSubject() == target).collect(Collectors.toList());

				GradeManage gradeManage = new GradeManage(target.getName() + " 학생 목록", gradeInfos);
				gradeManage.setSize(700, 500);
				gradeManage.setVisible(true);
			}
		});
//		dtm.addTableModelListener(e -> System.out.println(e.getSource()));

		add(new JScrollPane(table), BorderLayout.CENTER);
		
	}
}

class GradeManage extends JFrame {

	private String title;
	private List<GradeInfo> gradeInfos;
	private JTable table = new JTable();
	private static final String[] columns = {"학번", "학생명", "출석점수", "중간점수", "기말점수", "최종점수", "학점", "비고"};
	GradeManage(String title, List<GradeInfo> gradeInfos) {
		super(title);
		this.title = title;
		this.gradeInfos = gradeInfos;

		Object[][] data = new Object[gradeInfos.size()][8];

		int index = 0;
		for (GradeInfo gradeInfo : gradeInfos) {
			data[index][0] = gradeInfo.getStudent().getUserId();
			data[index][1] = gradeInfo.getStudent().getName();
			data[index][2] = gradeInfo.getAttendanceScore();
			data[index][3] = gradeInfo.getMidtermExamScore();
			data[index][4] = gradeInfo.getFinalExamScore();
			data[index][5] = gradeInfo.getTotalScore();
			data[index][6] = gradeInfo.getGrade();
			data[index][7] = gradeInfo.getNote();
			index++;
		}

		String[] columns = {"학번", "학생명", "출석점수", "중간점수", "기말점수", "최종점수", "학점", "비고"};

		table.setModel(new DefaultTableModel(data, columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});

		GradeManage thisG = this;

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable table1 = (JTable) e.getSource();
				GradeInfo target = gradeInfos.get(table1.getSelectedRow());
				String title = String.format("(%s, %s) 학점 수정", target.getStudent().getUserId(), target.getStudent().getName());

				EditGradeInfo editGradeInfo = new EditGradeInfo(title, target, thisG);
				editGradeInfo.setSize(300, 500);
				editGradeInfo.setVisible(true);
			}
		});

		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	@Override
	public void repaint() {
		Object[][] data = new Object[gradeInfos.size()][8];

		int index = 0;
		for (GradeInfo gradeInfo : gradeInfos) {
			data[index][0] = gradeInfo.getStudent().getUserId();
			data[index][1] = gradeInfo.getStudent().getName();
			data[index][2] = gradeInfo.getAttendanceScore();
			data[index][3] = gradeInfo.getMidtermExamScore();
			data[index][4] = gradeInfo.getFinalExamScore();
			data[index][5] = gradeInfo.getTotalScore();
			data[index][6] = gradeInfo.getGrade();
			data[index][7] = gradeInfo.getNote();
			index++;
		}

		table.setModel(new DefaultTableModel(data, columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	}
}

class EditGradeInfo extends JFrame {

	private JTextField aScoreField, mScoreField, fScoreField, tScoreField, gradeField;
	private JTextArea noteField;
	EditGradeInfo(String title, GradeInfo gradeInfo, GradeManage gradeManage) {
		setTitle(title);
		setLayout(new GridLayout(0, 2));

		aScoreField = new JTextField();
		aScoreField.setText(gradeInfo.getAttendanceScore().toString());
		mScoreField = new JTextField();
		mScoreField.setText(gradeInfo.getMidtermExamScore().toString());
		fScoreField = new JTextField();
		fScoreField.setText(gradeInfo.getFinalExamScore().toString());
		tScoreField = new JTextField();
		tScoreField.setText(gradeInfo.getTotalScore().toString());
		gradeField = new JTextField();
		gradeField.setText(gradeInfo.getGrade());
		noteField = new JTextArea();
		noteField.setText(gradeInfo.getNote());

		add(new JLabel("출석 점수", SwingConstants.CENTER));
		add(aScoreField);
		add(new JLabel("중간 점수", SwingConstants.CENTER));
		add(mScoreField);
		add(new JLabel("기말 점수", SwingConstants.CENTER));
		add(fScoreField);
		add(new JLabel("최종 점수", SwingConstants.CENTER));
		add(tScoreField);
		add(new JLabel("학점", SwingConstants.CENTER));
		add(gradeField);
		add(new JLabel("비고", SwingConstants.CENTER));
		add(new JScrollPane(noteField));
		JButton ok = new JButton("수정");
		JButton cancel = new JButton("취소");
		add(ok);
		add(cancel);

		ok.addActionListener(e -> {
			Integer attendanceScore = Integer.parseInt(aScoreField.getText());
			Integer midtermExamScore = Integer.parseInt(mScoreField.getText());
			Integer finalExamScore = Integer.parseInt(fScoreField.getText());
			Integer totalScore = Integer.parseInt(tScoreField.getText());
			String grade = gradeField.getText();
			String note = noteField.getText();

			gradeInfo.update(attendanceScore, midtermExamScore, finalExamScore, totalScore, grade, note);
			JOptionPane.showMessageDialog(null, "수정 완료");
			gradeManage.repaint();
			dispose();
		});

		cancel.addActionListener(e -> dispose());

	}
}

//학생 관리 버튼 클릭 -> 학생 관리 창
class StudentManage extends JFrame{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	StudentManage(String title, List<User> students){
		super(title);
		
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return !(col==0);
			}
		};
		
		Object[][] data = new Object[students.size()][2];

		int index = 0;
		for (User student : students) {
			data[index][0] = student.getUserId();
			data[index][1] = student.getName();
			index++;
		}
		
		String[] columns = {"학번", "이름"};
		
		JTable table = new JTable();

		table.setModel(new DefaultTableModel(data, columns) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});

		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}

//메세지 버튼 클릭 -> 메세지 창
class MessageToStudent extends JFrame{
	
	MessageToStudent(){
		super("메세지");
		
		// JTextArea
		JTextArea jt1 = new JTextArea();
		jt1.setBounds(50, 75, 200, 200);
		jt1.setFont(new Font("바탕",Font.BOLD,17));
				
		// JButton
		JButton bt1 = new JButton("전송");
		bt1.setBounds(50, 300, 100, 30);
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String text = jt1.getText();
				String words[] =text.split("\\s");
				}
			});
		add(jt1);add(bt1);
		setSize(1080, 690);
		setLayout(null);
		setVisible(true);
	}
}