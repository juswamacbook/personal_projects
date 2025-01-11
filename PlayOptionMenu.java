package newcode;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayOptionMenu {

	JPanel POMMainPanel = new JPanel();

	JButton PVC = new JButton();
	JButton PVP = new JButton();
	JButton PVT = new JButton();
	JButton back = new JButton();
	JLabel title = new JLabel();
	

	// PLAY OPTION MENU
	PlayOptionMenu(int a, int b, int c, int d) {
		// Main panel, everything is attached to this
		// JPanel panel = new JPanel();
		POMMainPanel.setPreferredSize(new Dimension(500, 500));
		POMMainPanel.setLayout(new FlowLayout());

		// Holds all the panels together
		JPanel PanelHolder = new JPanel();
		PanelHolder.setPreferredSize(new Dimension(500, 400));
		PanelHolder.setLayout(new FlowLayout());

		// This panel is responsible for holding the title
		JPanel TitlePanel = new JPanel();
		// TitlePanel.setPreferredSize(new Dimension (400, 125));
		TitlePanel.setLayout(new FlowLayout());

		// Sub main panels to hold buttons
		JPanel PlayerVsComputer = new JPanel();
		// PausePanel.setPreferredSize(new Dimension(300, 500/3));
		PlayerVsComputer.setLayout(new FlowLayout());

		JPanel PlayerVsPlayer = new JPanel();
		// ExitPanel.setPreferredSize(new Dimension(300, 500/3));
		PlayerVsPlayer.setLayout(new FlowLayout());

		JPanel PlayerVsTime = new JPanel();
		// CompletedWordsPanel.setPreferredSize(new Dimension(300, 500/3));
		PlayerVsTime.setLayout(new FlowLayout());

		// Setting components
		title.setText("[Play Options]");
		PVC.setText("(Player vs Computer)");
		PVP.setText("(Player vs Player)"); // Click this, go back to main menu
		PVT.setText("(Player vs Time)");
		back.setText("BACK");
		title.setPreferredSize(new Dimension(184, 125)); // JLabel doesn't center
		PVC.setPreferredSize(new Dimension(300, 50));
		PVP.setPreferredSize(new Dimension(300, 50));
		PVT.setPreferredSize(new Dimension(300, 50));
		back.setPreferredSize(new Dimension(150, 50));
		PVC.setBackground(new Color(248, 249, 241));
		PVP.setBackground(new Color(248, 249, 241));
		PVT.setBackground(new Color(248, 249, 241));
		back.setBackground(new Color(255,127,127));

		// Adding all components to sub main panels
		PlayerVsComputer.add(PVC);
		PlayerVsPlayer.add(PVP);
		PlayerVsTime.add(PVT);
		// TitlePanel.add(Box.createHorizontalStrut(50));
		TitlePanel.add(title);

		// Adds everything to panel
		PanelHolder.add(TitlePanel);
		PanelHolder.add(PlayerVsComputer);
		PanelHolder.add(PlayerVsPlayer);
		PanelHolder.add(PlayerVsTime);
		POMMainPanel.add(PanelHolder);
		POMMainPanel.add(back);

		// Registering custom font
		Font retroPixLarge;
		try {
			retroPixLarge = Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")).deriveFont(Font.BOLD, 28f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("retropix.ttf")));
			PVC.setFont(retroPixLarge);
			PVP.setFont(retroPixLarge);
			PVT.setFont(retroPixLarge);
			title.setFont(retroPixLarge);
			back.setFont(retroPixLarge);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
