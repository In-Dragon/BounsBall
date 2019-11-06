package GUi.Team.BounsBall;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyControler extends KeyAdapter {
	static boolean Left = false;
	static boolean Right = false;

	@Override
	public void keyPressed(KeyEvent e) {
		if (MainFrame.MoveBall == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Left = true;
			MainFrame.MoveBall.press();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Right = true;
			MainFrame.MoveBall.press();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (MainFrame.MoveBall == null) {
			return;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			Left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			Right = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
