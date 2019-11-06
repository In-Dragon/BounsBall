package GUi.Team.BounsBall;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

public class MoveButton extends Thread{
	JButton b = null;
	int x;
	int y;

	int speedy;

	public MoveButton(JButton b, int x, int y) {
		this.b = b;
		this.x = x;
		this.y = y;

	}

	public void move(int x, int y) {
		b.setLocation(x, y);
	}

	@Override
	public void run() {
		

		while (true) {
			y += speedy;
			if (y < Main.SCREEN_HEGHT / 5 * 4) {
				speedy = 10;
			} else if (y > Main.SCREEN_HEGHT - 20) {
				speedy = -10;
			}
			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					move(x, y);
				}
			});

			try {
				Thread.sleep(20);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
