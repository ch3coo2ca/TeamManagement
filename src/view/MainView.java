package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainView extends AbsViewTemplate {

	SelectTeamView selectTeamView;
	InsertMemberView insertMemberView;
	SelectMemberView selectMemberView;
	DeleteMemberView deleteMemberView;

	public void setDeleteMemberView(DeleteMemberView deleteMemberView) {
		this.deleteMemberView = deleteMemberView;
	}

	public void setSelectMemberView(SelectMemberView selectMemberView) {
		this.selectMemberView = selectMemberView;
	}

	public void setSelectTeamView(SelectTeamView selectTeamView) {
		this.selectTeamView = selectTeamView;
	}

	public void setInsertMemberView(InsertMemberView insertMemberView) {
		this.insertMemberView = insertMemberView;
	}

	@Override
	public void showMenu() {
		System.out.println("***************");
		System.out.println("");
		System.out.println("1. 종료");
		System.out.println("2. 팀 리스트");
		System.out.println("3. 팀원 추가");
		System.out.println("4. 팀원 관리");
		System.out.println("");
		System.out.println("***************");
		System.out.println("번호 입력(Enter)");
	}

	@Override
	public int getMinMenuNumber() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getMaxMenuNumber() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public void execute(int number) {
		switch (number) {
		case 1:
			msg("프로그램 종료");
			System.exit(0);
		case 2:
			selectTeamView.show();
			break;
		case 3:
			insertMemberView.show();
			break;
		case 4:
			selectMemberView.show();
			break;
		}
	}

	public static void main(String[] args) {
		GenericApplicationContext ac = new GenericXmlApplicationContext("appContext.xml");
		MainView mv = (MainView) ac.getBean("mainView");

		MainFrame mf = new MainFrame(mv);
	}
}

class MainFrame extends JFrame implements ActionListener {
	private JButton btnExit, btnTeamList, btnAddMember, btnTeamManage;
	private MainView mv;

	public void setMv(MainView mv) {
		this.mv = mv;
	}

	public void init() {

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screen.getWidth() / 2) - 200;
		int height = (int) (screen.getHeight() / 2) - 200;
		setLocation(width, height);
		setSize(300, 300);

		btnExit = new JButton("종료");
		btnTeamList = new JButton("팀 리스트");
		btnAddMember = new JButton("팀원 추가");
		btnTeamManage = new JButton("팀원 관리");

		btnExit.addActionListener(this);
		btnTeamList.addActionListener(this);
		btnAddMember.addActionListener(this);
		btnAddMember.addActionListener(this);

		setLayout(new GridLayout(4, 1));
		this.add(btnTeamList);
		this.add(btnAddMember);
		this.add(btnTeamManage);
		this.add(btnExit);

	}

	public MainFrame(MainView mv) {
		init();
		setMv(mv);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			mv.execute(1);
		} else if (e.getSource() == btnTeamList) {
			mv.execute(2);
		} else if (e.getSource() == btnAddMember) {
			mv.execute(3);
		} else if (e.getSource() == btnTeamManage) {
			mv.execute(4);
		}

	}

}
