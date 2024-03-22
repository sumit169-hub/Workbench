package mygroup.workbench;

import java.io.*;
import javax.swing.*;

public class WorkBench {

	static String path = new File("").getAbsolutePath();
	static File f = new File(path + "/theme.txt");

	static int getInt() throws IOException {
		if (f.createNewFile()) {
			setInt(0);
		}
		try (FileReader fr = new FileReader(f)) {
			return fr.read();
		}
	}

	static void setInt(int i) throws IOException {
		try (FileWriter fw = new FileWriter(f)) {
			fw.write(i);
		}
	}

	public static void setLook() {
		try {
			UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[getInt()].getClassName());
		} catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(new JFrame(), "Theme not available");
		}
	}

	public static void changeLook(JFrame f) {
		try {
			setInt((getInt() + 1) % 5);
			setLook();
			SwingUtilities.updateComponentTreeUI(f);
			f.pack();
		} catch (IOException e) {
		}
	}

	public static void main(String[] args) {
		setLook();
		new HomePage();
	}
}
