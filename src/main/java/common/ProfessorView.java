package common;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import model.GradeInfo;
import model.Professor;
import model.Student;
import model.Subject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

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
	
	//과목, 학생 관리 버튼
  private JButton manageSubject, manageStudent;
  //패널
  private JPanel panel;
  //라벨(과목 관리 시스템)
  private JLabel label;
  
	void MakeView()
  {
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
  	panel.setBackground(Color.gray);
  	
  	//라벨
  	label = new JLabel();	
  	label.setBounds(20, -350, 200, 800);
  	label.setFont(new Font("Serif", Font.BOLD, 20));
  	label.setText("성적 관리 시스템");
  	panel.add(label);
  	
  	//과목 관리 버튼
  	manageSubject = new JButton("과목 관리");
  	manageSubject.setBounds(50, 100, 100, 30);
  	panel.add(manageSubject);
  	
  	//학생 관리 버튼
  	manageStudent = new JButton("학생 관리");
  	manageStudent.setBounds(50, 180, 100, 30);
  	panel.add(manageStudent);
  	
  	manageSubject.addActionListener(this);
  	manageStudent.addActionListener(this);
  	
  	panel.setPreferredSize(new Dimension(200, 720));
  	add(panel);
  	
  	setVisible(true);  	
  }
	
	//버튼 클릭 이벤트
  @Override
  public void actionPerformed(ActionEvent e) {
  	if(e.getSource()==manageSubject) {
  		//과목 관리 버튼
  		JFrame SubjectFrame = new SubjectManage();
  		SubjectFrame.setSize(640, 360);
  		SubjectFrame.setLocationRelativeTo(null);
  		SubjectFrame.setVisible(true);
  		
  	}else if(e.getSource()==manageStudent) {
  		//학생 관리 버튼
  		JFrame StudentFrame = new StudentManage();
  		StudentFrame.setSize(640, 360);
  		StudentFrame.setLocationRelativeTo(null);
  		StudentFrame.setVisible(true);
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