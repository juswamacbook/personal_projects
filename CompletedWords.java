package newcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CompletedWords {

	JPanel CWMainPanel = new JPanel();
	
	JLabel title = new JLabel();
	JPanel wordsPanel;
	JLabel pagesCW = new JLabel();
	JButton nextPageCW = new JButton();
	JButton ReturnToGameCW = new JButton();
	int pageCounterCW = 0;
	
	CompletedWords(String[] a){
		// This is the main panel
		//JPanel mainPanel = new JPanel();
		CWMainPanel.setPreferredSize(new Dimension(500, 500));
		CWMainPanel.setLayout(new FlowLayout());
		
		// This section sets the stuff for title
		title.setText("[Completed Words]:");
		
		// This panel holds the title and holds it in place
		JPanel titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(500, 50));
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(title);
		
		// These panels centers the visible components
		JPanel Obstructor = new JPanel();
		Obstructor.setPreferredSize(new Dimension(500, 50));
		Obstructor.setLayout(new FlowLayout());
		
		wordsPanel = new JPanel();
		wordsPanel.setPreferredSize(new Dimension(380, 250));
		wordsPanel.setLayout(new FlowLayout());
		
		// Pages settings, button settings
		pagesCW.setText("(Page): " + pageCounterCW);
		nextPageCW.setText("(Next)");
		nextPageCW.setPreferredSize(new Dimension(90, 45));
		nextPageCW.setOpaque(true);
		nextPageCW.setBorderPainted(true);
		nextPageCW.setBackground(new Color(248, 249, 241));
		ReturnToGameCW.setText("(Back)");
		ReturnToGameCW.setPreferredSize(new Dimension(200, 45));
		ReturnToGameCW.setOpaque(true);
		ReturnToGameCW.setBorderPainted(true);
		ReturnToGameCW.setBackground(new Color(248, 249, 241));
		
		// Placement settings
		
		Obstructor.add(Box.createHorizontalStrut(20)); // Horizontally spreads by x pixels
		Obstructor.add(pagesCW);
		Obstructor.add(Box.createHorizontalStrut(20));
		Obstructor.add(nextPageCW);
		//Obstructor.add(ReturnToGameCW);
		
		// This is the array for the list of completed words
		JLabel[] words = new JLabel[a.length];
		
		// This is the font settings
		Font retroPixLarge;
		try {
			retroPixLarge = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 30f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));			
			title.setFont(retroPixLarge);
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		Font retroPixMid;
		try {
			retroPixMid = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));			
			pagesCW.setFont(retroPixMid);
			nextPageCW.setFont(retroPixMid);
			ReturnToGameCW.setFont(retroPixMid);
			
		} catch (Exception e1) {
			System.out.println(e1);
		}
		Font retroPix;
		try {
			retroPix = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));			
			for(int i = 0; i < a.length; i++) {
				insertionSort(a);
				words[i] = new JLabel(a[i] + ", ");
				words[i].setFont(retroPix);
			}
		
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		// Adding words to the panel
		CWMainPanel.add(titlePanel);
		//, BorderLayout.NORTH);
		//mainPanel.add(ObstructorR, BorderLayout.EAST);
		//mainPanel.add(ObstructorL, BorderLayout.WEST);
		CWMainPanel.add(wordsPanel);
		CWMainPanel.add(Obstructor);
		CWMainPanel.add(ReturnToGameCW);
		
		// words limit is 20
		// This big block is to calculate words display on page (probably needs to be tweaked to work)
		if(a.length >= 20 && a.length % 20 !=0) {
			int variable = a.length;
			int temp = 0;
			
			temp = temp + 20;
			variable = variable - 20;
			if(variable >= 20) {
				pageCounterCW ++;
				pagesCW.setText("" + pageCounterCW);
				for(int i = 0; i < 20; i ++) {
					wordsPanel.add(words[temp+i]);
				}
			}else {
				for(int i = 0; i < variable; i ++) {
					wordsPanel.add(words[temp + i]);
				}
			}
		}else {
			for(int i = 0; i < words.length; i ++) {
				wordsPanel.add(words[i]);
			}
		}
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
