package Test.sample;

import java.awt.*;

import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class student2 extends JFrame {
	boolean left = false;
	boolean right = false;
	boolean up = false;
	boolean down = false;
	int x;
	int y;
	JPanel pan;
	JButton btn;
	ActionListener al;

	student2() {

		Container con = getContentPane();
		x = 800;
		y = 850;
		pan = new JPanel();
		pan.setBackground(Color.green);
		pan.setSize(50, 50);
		btn = new JButton();
		con.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					left = false;

				if (e.getKeyCode() == KeyEvent.VK_UP)
					up = false;

				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					down = false;

				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					right = false;
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					left = true;

				if (e.getKeyCode() == KeyEvent.VK_UP)
					up = true;

				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					down = true;

				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					right = true;
			}
		});
		Runnable move = () -> {
			while (true) {

				if (right)
					pan.setLocation(pan.getX() + 5, pan.getY());
				if (left)
					pan.setLocation(pan.getX() - 5, pan.getY());
				if (up)
					pan.setLocation(pan.getX(), pan.getY() - 5);
				if (down)
					pan.setLocation(pan.getX(), pan.getY() + 5);
				try {
					Thread.sleep(1000 / 60);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		btn.setLocation(50, 50);
		btn.setSize(100, 100);
		con.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				btn.setLocation(e.getX(), e.getY());

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		Thread th = new Thread(move);
		setTitle("study");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		con.setLayout(null);
		con.add(pan);
		con.add(btn);
		con.setFocusable(true);
		setVisible(true);
		setSize(x, y);
		th.start();
	}

	public static void main(String args[]) {
		new student2();
	}
}
