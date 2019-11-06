package GUi.Team.BounsBall;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Ball extends Thread {

	private Image BallImage = new ImageIcon(Main.class.getResource("/images/tennisBall.png")).getImage();
	private int x, y;
	private int g = 1;
	int speedx;

	public Ball(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(BallImage, x, y, null);
	}

	public void press() {
		Main.BALL_SPEEDX = 5;
	}

	public void close() {
		this.interrupt();
	}

	@Override
	public void run() {
		while (MainFrame.isGameScreen) {
			Main.BALL_SPEEDY += g;
			y += Main.BALL_SPEEDY;
			if (KeyControler.Left) {
				MainFrame.MoveBall.x -= Main.BALL_SPEEDX;
			}
			if (KeyControler.Right) {
				MainFrame.MoveBall.x += Main.BALL_SPEEDX;
			}
			if (y > Main.SCREEN_HEGHT - 30) {
				if (Math.abs(Main.BALL_SPEEDY) < 5) {
					Main.BALL_SPEEDY = 0;
					g = 0;
				} else {
					Music ballsound = new Music("BallSound.mp3", false);
					ballsound.start();
					Main.BALL_SPEEDY = -Main.BALL_SPEEDY;
				}
			}
			if (MainFrame.MoveBall.x < 0) {
				do {
					MainFrame.MoveBall.x += Main.BALL_SPEEDX;
				} while (MainFrame.MoveBall.x < 10);
			}
			if (MainFrame.MoveBall.x > Main.SCREEN_WIDTH - 30) {
				do {
					MainFrame.MoveBall.x -= Main.BALL_SPEEDX;
				} while (MainFrame.MoveBall.x > Main.SCREEN_WIDTH - 50);
			}
			try {
				Thread.sleep(Main.SLEEP_TIME);
			} catch (InterruptedException e) {
				System.out.println("메인화면으로 돌아감");
			}
		}
	}
}
