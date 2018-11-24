package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Font;

import model.*;
import controller.*;

public class KlotskiApp extends JFrame {

	Board board;
	
	private JPanel contentPane;
	public JLabel lblMoves;
	
	PuzzleView puzzleView;

	public PuzzleView getPuzzleView() {
		return puzzleView;
	}

	/**
	 * Create the frame.
	 */
	public KlotskiApp(Board b) {
		super();
		this.board = b;
		setFocusable(true);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnKlotski = new JMenu("Klotski");
		menuBar.add(mnKlotski);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnKlotski.add(mntmQuit);
		
		mntmQuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (new ExitApplication().confirm(KlotskiApp.this)) {
					KlotskiApp.this.dispose();
				}
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAboutKlotski = new JMenuItem("About Klotski");
		mnHelp.add(mntmAboutKlotski);
		
		mntmAboutKlotski.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new HelpController().printHelp(KlotskiApp.this);
			}
		});
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ResetPuzzle(KlotskiApp.this, board).reset();
				KlotskiApp.this.requestFocusInWindow();
			}
		});
		
		lblMoves = new JLabel("Moves: " + board.moves());
		lblMoves.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		puzzleView = new PuzzleView(board);
		
		puzzleView.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				new SelectTile(KlotskiApp.this, board).select(e.getX(),e.getY());
			}
		});

		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				new MoveTile(KlotskiApp.this, board).move(e.getKeyChar());
			}
		});
		
		this.addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
			    if (new ExitApplication().confirm(KlotskiApp.this)) {
			      KlotskiApp.this.dispose();
			    }
			  }
			});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(puzzleView, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnReset, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
						.addComponent(lblMoves))
					.addContainerGap(137, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(puzzleView, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMoves)
							.addGap(18)
							.addComponent(btnReset)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
