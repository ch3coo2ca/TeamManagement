package view;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class AbsView {

	protected String getKeyInputString(String str) {
		String input = JOptionPane.showInputDialog(str + "입력  : ");
		return input;
	}

	protected String getEnter() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();
	}

	protected void msg(String stSr) {
		JOptionPane.showMessageDialog(null, stSr);
	}

	abstract public void show();

}
