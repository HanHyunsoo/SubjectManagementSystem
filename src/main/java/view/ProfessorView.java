package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfessorView {

	//메인메소드
    public static void main(String[] args) {
    	
        //뷰 생성
        View view = new View();
        view.MakeView();
    }
}

//View 관련
class View extends JFrame implements ActionListener{
	
  //과목, 학생 관리, 메세지 버튼
  private JButton manageSubject, manageStudent, messageBtn;
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
  	
  	//메세지 버튼
  	messageBtn = new JButton("메세지");
  	messageBtn.setBounds(50, 280, 100, 30);
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
  		JFrame SubjectFrame = new SubjectManage();
  		SubjectFrame.setSize(1080, 690);
  		SubjectFrame.setLocation(310, 145);
  		//SubjectFrame.setLocationRelativeTo(null);
  		SubjectFrame.setVisible(true);
  		
  	}else if(e.getSource()==manageStudent) {
  		//학생 관리 버튼
  		JFrame StudentFrame = new StudentManage();
  		StudentFrame.setSize(1080, 690);
  		StudentFrame.setLocation(310, 145);
  		//StudentFrame.setLocationRelativeTo(null);
  		StudentFrame.setVisible(true);
  	}else if(e.getSource()==messageBtn) {
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
	
	SubjectManage(){
		
		super("과목 관리");
		
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return !(col==0);
			}
		};
		
		
		
		Object[][] data = new Object[1][3];
		
		data[0][0] = "자바 프로젝트";
		data[0][1] = "6201";
		data[0][2] = "30";
		
		String[] columns = {"강의 과목", "강의실", "수강 인원"};
		
		dtm.setDataVector(data, columns);
		
		JTable table = new JTable(dtm);
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		
	}
}

//학생 관리 버튼 클릭 -> 학생 관리 창
class StudentManage extends JFrame{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	
	StudentManage(){
		super("학생 관리");
		
		DefaultTableModel dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int col) {
				return !(col==0);
			}
		};
		
		
		
		Object[][] data = new Object[4][3];
		
		//일단 그냥 문자열 그대로 넣었습니다..
		data[0][0] = "201814043";
		data[0][1] = "한현수";
		data[0][2] = "3";
		
		data[1][0] = "201732037";
		data[1][1] = "한상훈";
		data[1][2] = "4";
		
		data[2][0] = "201632033";
		data[2][1] = "최준호";
		data[2][2] = "4";
		
		data[3][0] = "201632028";
		data[3][1] = "정민석";
		data[3][2] = "4";
		
		String[] columns = {"학번", "이름", "학년"};
		
		dtm.setDataVector(data, columns);
		
		JTable table = new JTable(dtm);
		
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