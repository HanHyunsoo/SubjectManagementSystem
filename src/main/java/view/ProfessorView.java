package view;

import common.DummyData;
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
  private JButton manageSubject, manageStudent, messageBtn, createStudent, createSubject;
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
  	
  	manageSubject.addActionListener(this);
  	manageStudent.addActionListener(this);
  	messageBtn.addActionListener(this);
  	
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
		
		JTable table = new JTable(data, columns);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable table1 = (JTable) e.getSource();
				System.out.println(table1.getSelectedColumn());
				System.out.println(table1.getSelectedRow());
				Subject target = subjects.get(table1.getSelectedRow());
				StudentManage studentManage = new StudentManage(target.getName() + " 학생 목록", target.getStudents());
				studentManage.setSize(200, 300);
				studentManage.setVisible(true);
			}
		});
//		dtm.addTableModelListener(e -> System.out.println(e.getSource()));

		add(new JScrollPane(table), BorderLayout.CENTER);
		
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
		
		JTable table = new JTable(data, columns);
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}

class StudentBySubjectManage extends StudentManage {

	StudentBySubjectManage(String title, List<User> students) {
		super(title, students);
		JButton button = new JButton("학생 추가");
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