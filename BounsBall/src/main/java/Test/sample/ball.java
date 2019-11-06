package Test.sample;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import GUi.Team.BounsBall.Main;

public class ball extends JFrame implements Runnable {

	public static void main(String[] args) {
		ball b=new ball(10,10,30);
		Thread t=new Thread(b);
		t.start();
		new KeyControl(b);
	}
	
	float x, y, w;
	float speedy = 10;
	float speedx = 10;
	int drive = 0;

	public ball(float x, float y, float w) {
		this.x = x;
		this.y = y;
		this.w = w;
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createBufferStrategy(4);
		setResizable(false);
	}

	@Override
	public void run() {

		while (true) {
			y += speedy;
			switch (drive) {
			case 1:
				x -= 10;
				break;
			case 2:
				x += 10;
				break;
			}
			if (y < Main.SCREEN_HEGHT / 5 * 3) {
				speedy = 10;
			} else if (y > Main.SCREEN_HEGHT - 20) {
				speedy = -10;
			}
			if (x < 0) {
				while (true) {
					speedx = 10;
					x += speedx;
					if (x > 0)
						break;
				}
			} else if (x > Main.SCREEN_WIDTH - 30) {
				while (true) {
					speedx = -10;
					x += speedx;
					if (x < Main.SCREEN_WIDTH - 30)
						break;
				}
			}
			
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException ex) {
			}
		}
	}

	public void paint(Graphics g) {

		g.setColor(Color.black);
		g.fillRect(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);

		g.setColor(Color.orange);
		g.fillOval((int) x, (int) y, (int) w, (int) w);
		g.dispose();

	}
}

class KeyControl implements KeyListener {
	ball b;

	public KeyControl(ball b) {
		this.b = b;
		b.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			b.drive = 1;
			break;
		case KeyEvent.VK_RIGHT:
			b.drive = 2;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			b.drive = 0;
			break;
		case KeyEvent.VK_RIGHT:
			b.drive = 0;
			break;
		default:
			break;
		}

	}

}
