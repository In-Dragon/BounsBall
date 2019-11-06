package GUi.Team.BounsBall;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private Image screenI;
	private Graphics screenG;

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("/images/menuBar.png")));

	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("/images/exitButton.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/StartButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("/images/StartButton.png"));
	private ImageIcon DownButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/DownButtonEntered.png"));
	private ImageIcon DownButtonBasicImage = new ImageIcon(Main.class.getResource("/images/DownButton.png"));
	private ImageIcon BackButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/BackButtonEntered.png"));
	private ImageIcon BackButtonBasicImage = new ImageIcon(Main.class.getResource("/images/BackButton.png"));

	private Image BackGround = new ImageIcon(Main.class.getResource("/images/BackGround.jpg")).getImage();;

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton DownButton = new JButton(DownButtonBasicImage);
	private JButton BackButton = new JButton(BackButtonBasicImage);

	private int mouseX, mouseY;
	Music BackGroundMusic = new Music("BackGroundmusic.mp3", true);

	static boolean isGameScreen = false;

	public static Ball MoveBall;

	public MainFrame() {
		setUndecorated(true);
		setTitle("Bouns Ball");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		addKeyListener(new KeyControler());
		setFocusable(true);
		requestFocusInWindow();

		BackGroundMusic.start();

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();

			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(exitButton);
		add(BackButton);
		add(menuBar);
		add(startButton);
		add(DownButton);

		exitButton.setBounds(1245, 1, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("mouseEnteredmusic.mp3", false);
				ButtonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonexitMusic = new Music("exitmusic.mp3", false);
				ButtonexitMusic.start();
				try {
					Thread.sleep(600);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
				System.exit(0);
			}
		});
		BackButton.setBounds(1, 1, 30, 30);
		BackButton.setBorderPainted(false);
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
		BackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BackButton.setIcon(BackButtonEnteredImage);
				BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("mouseEnteredmusic.mp3", false);
				ButtonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				BackButton.setIcon(BackButtonBasicImage);
				BackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonexitMusic = new Music("exitmusic.mp3", false);
				ButtonexitMusic.start();
				backMain();
			}
		});

		startButton.setBounds(50, 50, 540, 137);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("mouseEnteredmusic.mp3", false);
				ButtonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonexitMusic = new Music("exitmusic.mp3", false);
				ButtonexitMusic.start();
				// 게임시작이벤트
				gameStart();

			}
		});

		DownButton.setBounds(140, 220, 540, 137);
		DownButton.setBorderPainted(false);
		DownButton.setContentAreaFilled(false);
		DownButton.setFocusPainted(false);
		DownButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				DownButton.setIcon(DownButtonEnteredImage);
				DownButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music ButtonEnteredMusic = new Music("mouseEnteredmusic.mp3", false);
				ButtonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				DownButton.setIcon(DownButtonBasicImage);
				DownButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music ButtonexitMusic = new Music("exitmusic.mp3", false);
				ButtonexitMusic.start();
				try {
					Thread.sleep(800);
				} catch (InterruptedException e2) {
					e2.printStackTrace();
				}
				System.exit(0);
			}
		});

	}

	public void paint(Graphics g) {
		screenI = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);
		screenG = screenI.getGraphics();
		screenDraw((Graphics2D) screenG);
		g.drawImage(screenI, 0, 0, null);

	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(BackGround, 0, 0, null);
		if (isGameScreen) {
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Level 1", 600, 200);
			MoveBall.screenDraw(g);
		}
		paintComponents(g);
		this.repaint();
	}

	public void gameStart() {
		startButton.setVisible(false);
		DownButton.setVisible(false);
		BackGroundMusic.close();
		BackGround = new ImageIcon(Main.class.getResource("/images/GameScreen.png")).getImage();
		isGameScreen = true;
		MoveBall = new Ball(500, 500);
		MoveBall.start();
		addKeyListener(new KeyControler());
		setFocusable(true);
		requestFocusInWindow();

//		ButtonTest(200, 200, Color.BLUE);	
	}

//	public void ButtonTest(int x, int y, Color c) {
//		JButton b = new JButton();
//		b.setBackground(c);
//		b.setSize(10, 10);
//		b.setLocation(x, y);
//		add(b);
//
//		new MoveButton(b, x, y).start();
//	}
	public void backMain() {
		isGameScreen = false;
		startButton.setVisible(true);
		DownButton.setVisible(true);
		BackGround = new ImageIcon(Main.class.getResource("/images/BackGround.jpg")).getImage();
		Main.BALL_SPEEDY = 5;
		Main.BALL_SPEEDX = 0;
		MoveBall.close();
	}
}