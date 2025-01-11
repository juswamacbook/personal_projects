package newcode;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class GameOver {

	JPanel GOMainPanel = new JPanel();
	JLabel winner = new JLabel();
	JLabel p2s = new JLabel();
	JLabel p1s = new JLabel();
	String win = "";
	JButton restart = new JButton();
	
	
	GameOver(){
		
		GOMainPanel.setPreferredSize(new Dimension(500, 500));
		
		JLabel label = new JLabel();
		label.setText("G");
		//label.setPreferredSize(new Dimension(200, 70));
		
		JLabel label2 = new JLabel();
		label2.setText("A");
		//label2.setPreferredSize(new Dimension(70, 70));

		JLabel label3 = new JLabel();
		label3.setText("M");
		//label3.setPreferredSize(new Dimension(160, 70));

		JLabel label4 = new JLabel();
		label4.setText("E");
		//label4.setPreferredSize(new Dimension(160, 70));

		JLabel label5 = new JLabel();
		label5.setText(" ");
		//label5.setPreferredSize(new Dimension(170, 60));

		JLabel label6 = new JLabel();
		label6.setText("O");
		//label6.setPreferredSize(new Dimension(170, 60));

		JLabel label7 = new JLabel();
		label7.setText("V");
		//label7.setPreferredSize(new Dimension(170, 60));
		
		JLabel label8 = new JLabel();
		label8.setText("E");
		//label8.setPreferredSize(new Dimension(170, 60));
		
		JLabel label9 = new JLabel();
		label9.setText("R");
		//label9.setPreferredSize(new Dimension(170, 60));
		
		JLabel label10 = new JLabel();
		label10.setText("!");
		//label10.setPreferredSize(new Dimension(170, 60));
	 
		 
		 
		JPanel winnerHolder = new JPanel();
		winnerHolder.setPreferredSize(new Dimension(500, 100));
		winnerHolder.setLayout(new FlowLayout());
	
		label.setBackground(Color.gray);
		label2.setBackground(Color.green);
		
		label.setOpaque(true);
		label2.setOpaque(true);
		
		//winner.setPreferredSize(new Dimension(100, 100));
		winner.setText("YOU WON");
		
		restart.setPreferredSize(new Dimension(120, 60));
		restart.setText("RESTART");
		restart.setBackground(new Color(217,217,217));
		
		JPanel spacer = new JPanel();
		spacer.setLayout(new BorderLayout());
		spacer.setPreferredSize(new Dimension(400, 100));
		spacer.add(p2s, BorderLayout.WEST);
		spacer.add(p1s, BorderLayout.EAST);
		
		p2s.setText("Score: wfqw");
		p1s.setText("Computer: fwqffqw");
		//p2s.setPreferredSize(new Dimension(240, 60));
		//p1s.setPreferredSize(new Dimension(240, 60));
		
		Font retroPixXL;
		try {
			retroPixXL = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(60f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			label.setFont(retroPixXL);
			label2.setFont(retroPixXL);
			
			
			label3.setFont(retroPixXL);
			label4.setFont(retroPixXL);
			label5.setFont(retroPixXL);
			label6.setFont(retroPixXL);
			label7.setFont(retroPixXL);
			label8.setFont(retroPixXL);
			label9.setFont(retroPixXL);
			label10.setFont(retroPixXL);
			
			
			retroPixXL = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(40f);
			winner.setFont(retroPixXL);
			
			retroPixXL = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(30f);
			p2s.setFont(retroPixXL);
			p1s.setFont(retroPixXL);
			
			retroPixXL = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(20f);
			restart.setFont(retroPixXL);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		//JFrame frame = new JFrame();
		//frame.setMinimumSize(new Dimension(500, 500));
		//frame.setVisible(true);
		//frame.setLayout(new FlowLayout());
		//frame.setResizable(true);
		
		//spacer.add(label);
		//spacer.add(label2);
		GOMainPanel.add(label);
		GOMainPanel.add(label2);
		GOMainPanel.add(label3);
		GOMainPanel.add(label4);
		GOMainPanel.add(label5);
		//GOMainPanel.add(winnerHolder);
		GOMainPanel.add(label6);
		GOMainPanel.add(label7);
		GOMainPanel.add(label8);
		GOMainPanel.add(label9);
		GOMainPanel.add(label10);
		
		
		winnerHolder.add(winner);
		GOMainPanel.add(winnerHolder);
		GOMainPanel.add(spacer);
		//GOMainPanel.add(p2s);
		//GOMainPanel.add(p1s);
		//GOMainPanel.add(restart); :sob: brian's wowrk no!!!
		
		
		//frame.add(GOMainPanel);
		
		
		//
	}
	
	public static void main(String[] args) {
		GameOver gg = new GameOver();
	}
}
