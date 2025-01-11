package newcode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeaderBoard {

	JPanel LBMainPanel = new JPanel(); // Leader Board

	JLabel titleLB = new JLabel();
	JLabel pagesLB = new JLabel();
	JButton nextPageLB = new JButton();
	JButton ReturnToGameLB = new JButton();
	JButton exitMenu = new JButton();
	int pageCounterLB = 0;

	LeaderBoard(String[] a, int[] scores) {

		// This is the main panel
		LBMainPanel.setPreferredSize(new Dimension(500, 500));
		LBMainPanel.setLayout(new BoxLayout(LBMainPanel, BoxLayout.Y_AXIS));
		//LBMainPanel.setLayout(new FlowLayout());
		
		titleLB.setText("[Leader Board]");
		
		// This panel holds the title and holds it in place
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(500, 50));
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(titleLB);
		//titlePanel.setBackground(Color.red);
		titlePanel.setBackground(new Color(255,192,203));
		
		// These panels centers the visible components
		// The size of the exit holder must be bigger than the component or it will act weird
		JPanel ExitHolder = new JPanel();
		ExitHolder.setLayout(new FlowLayout());
		ExitHolder.setPreferredSize(new Dimension(500, 70));
		ExitHolder.setBackground(new Color(255,192,203));
		
		ExitHolder.add(exitMenu);
		

		// These panels also relates to the columns of the words displayed
		// These panels specifies how the words will be displayed
		JPanel wordsPanelCenter = new JPanel();
		wordsPanelCenter.setPreferredSize(new Dimension(200, 250));
		//wordsPanelCenter.setLayout(new BoxLayout(wordsPanelCenter, BoxLayout.Y_AXIS));
		wordsPanelCenter.setLayout(new FlowLayout());
		wordsPanelCenter.setBackground(new Color(255,192,203));
		//wordsPanelCenter.setBackground(Color.gray);

	
		exitMenu.setBackground(new Color(255,248,249));
		exitMenu.setText("BACK");
		exitMenu.setPreferredSize(new Dimension(150, 60));
		exitMenu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,  new Color(25,25,25)));
				
		// This is the array for the list of completed words
		JLabel[] words = new JLabel[a.length];
		
		// This is the font settings
		Font retroPixLarge;
		try {
			retroPixLarge = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));			
			titleLB.setFont(retroPixLarge);
			
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		Font retroPixMid;
		try {
			retroPixMid = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));			
			
			retroPixMid = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 15f);
			exitMenu.setFont(retroPixMid);
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		// This one specifically sets the font and creates the labels
		Font retroPix;
		try {
			retroPix = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));			
			for(int i = 0; i < scores.length; i++) {
				insertionSort(a);
				words[i] = new JLabel("  " + (i+1) + ") " + a[i] + "  :" + scores[i]);
				words[i].setPreferredSize(new Dimension(250, 75)); // 125 to give space for big words
				words[i].setFont(retroPix);
			}
		
		} catch (Exception e1) {
			System.out.println(e1);
		}
		

		for(int i = 0; i < scores.length; i ++) {
			wordsPanelCenter.add(words[i]);
			if(i==0) {
				words[i].setOpaque(true);
				words[i].setBackground(new Color(255, 215, 0));
				words[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(102,102,102)));
			}else if(i==1) {
				words[i].setOpaque(true);
				words[i].setBackground(new Color(192, 192, 192));
				words[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,  new Color(102,102,102)));
			}else {
				words[i].setOpaque(true);
				words[i].setBackground(new Color(239, 189, 130));
				words[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,  new Color(102,102,102)));
			}
		}
		
		
		LBMainPanel.add(titlePanel);
		//LBMainPanel.add(wordsPanelLeft);
		LBMainPanel.add(wordsPanelCenter);
		//LBMainPanel.add(wordsPanelRight);
		LBMainPanel.add(ExitHolder);
		/*
		// words limit is 20
		// This big block is to calculate words display on page (needs to be tweaked more to work)
		if(a.length > 10 && a.length % 10 !=0) { // if number > 10 and does not give remainder of 0 when divided by 10
			int variable = a.length;
			int temp = 0;
			
			temp = temp + 10;
			variable = variable - 10;
			if(variable >= 10) { // if 
				pageCounterLB ++;
				pagesLB.setText("" + pageCounterLB);
				for(int i = 0; i < 10; i ++) {
					if(i<5) {
						wordsPanel.add(words[temp+i]);
					}else {
						wordsPanel2.add(words[temp+i]);
					}
				}
			}else { // Else within 10
				for(int j = 0; j < 1; j ++) {
					for(int i = 0; i < variable; i ++) {
						if(i<5) {
							wordsPanel.add(words[temp+i]);
						}else {
							wordsPanel2.add(words[temp+i]);
						}
			
					}
				}
			}
		}else {
			for(int i = 0; i < words.length; i ++) {
				if(i < 5) {
					wordsPanel.add(words[i]);
				}else {
					wordsPanel2.add(words[i]);
				}
			}
		}
		*/
	

	}
    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

}
