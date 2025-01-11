package newcode;
import java.awt.*;
import java.io.File;

import javax.swing.*;

//import testing.PlayerVsPlayer;


public class ViewCredits {
	
	JPanel VCMainPanel = new JPanel();
	JButton exit = new JButton("EXIT");
	
	ViewCredits(){
		JLabel title = new JLabel();
		title.setPreferredSize(new Dimension(150, 50));
		title.setText("[Credits]");
		
		JLabel AC = new JLabel();
		JLabel BR = new JLabel();
		JLabel BY = new JLabel();
		JLabel JR = new JLabel();
		
		AC.setText("Alex Chan: ");
		BR.setText("Barsam Rahimi");
		BY.setText("Brian Yu");
		JR.setText("Joshua Ranin");
		
		AC.setPreferredSize(new Dimension(300, 50));
		BR.setPreferredSize(new Dimension(300, 50));
		BY.setPreferredSize(new Dimension(300, 50));
		JR.setPreferredSize(new Dimension(300, 50));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(500, 50));
		titlePanel.setLayout(new FlowLayout());
		//titlePanel.setBackground(Color.red);
		
		JPanel mainBody = new JPanel();
		mainBody.setPreferredSize(new Dimension(300, 375));
		mainBody.setLayout(new FlowLayout());
		//mainBody.setLayout(new BoxLayout(mainBody, BoxLayout.Y_AXIS));


		JLabel PM = new JLabel();
		JLabel LD = new JLabel();
		JLabel GD = new JLabel();
		JLabel CL = new JLabel();
		JLabel IML = new JLabel();
		JLabel P = new JLabel();
		JLabel R = new JLabel();
		PM.setText("Project Manager - Barsam");
		LD.setText("Developer lead, developer - Alex");
		GD.setText("Gui designer - Brian/Joshua");
		CL.setText("Communications Lead - Alex");
		IML.setText("Information management lead - Joshua");
		P.setText("Planner - Barsam/Brian");
		R.setText("Researcher - Brian");
		
		PM.setPreferredSize(new Dimension(300, 30));
		LD.setPreferredSize(new Dimension(300, 30));
		GD.setPreferredSize(new Dimension(300, 30));
		CL.setPreferredSize(new Dimension(300, 30));
		IML.setPreferredSize(new Dimension(300, 30));
		P.setPreferredSize(new Dimension(300, 30));
		R.setPreferredSize(new Dimension(300, 30));
			
		//mainBody.setBackground(Color.green);
		
		titlePanel.add(title);
		VCMainPanel.setLayout(new BoxLayout(VCMainPanel, BoxLayout.Y_AXIS));
		VCMainPanel.add(titlePanel);
		VCMainPanel.add(mainBody);
		
		JPanel spacer = new JPanel();
		spacer.setPreferredSize(new Dimension(500, 15));
	
		exit.setOpaque(true);
		exit.setPreferredSize(new Dimension(210, 50));
		exit.setBorderPainted(true);
		exit.setBackground(new Color(248, 249, 241));
		
		
		Font retroPix;
		try {
			retroPix = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			title.setFont(retroPix);
			
			retroPix = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 25f);
			exit.setFont(retroPix);
			
			retroPix = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(20f);
			//AC.setFont(retroPix);
			//BR.setFont(retroPix);
			//BY.setFont(retroPix);
			//JR.setFont(retroPix);
			PM.setFont(retroPix);
			LD.setFont(retroPix);
			GD.setFont(retroPix);
			CL.setFont(retroPix);
			IML.setFont(retroPix);
			P.setFont(retroPix);
			R.setFont(retroPix);
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		//mainBody.add(AC);
		//mainBody.add(BR);
		//mainBody.add(BY);
		//mainBody.add(JR);
		mainBody.add(PM);
		mainBody.add(LD);
		mainBody.add(GD);
		mainBody.add(CL);
		mainBody.add(IML);
		mainBody.add(P);
		mainBody.add(R);
		mainBody.add(spacer);
		mainBody.add(exit);
		
		
	}
	public static void main(String[] args) {
		//ViewCredits vc = new ViewCredits();
		String[] a = new String[]{"dates", "elderberry", "fig", "grapes", "hackberry", "apple", "banana", "cranberry", "laugh", 
				"hi", "op", "gjgj", "jifwifni", "eig"};
		int[] b = new int[]{99, 100, 66};
		ViewCredits tester = new ViewCredits();
		//LeaderBoard lb = new LeaderBoard(a, b);
		
	}

}
