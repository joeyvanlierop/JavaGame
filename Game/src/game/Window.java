package game;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window
{
	public Window(int width, int height, Game main)
	{
		JFrame frame = new JFrame("Game");
		
		main.setPreferredSize(new Dimension(width, height));
		main.setMaximumSize(new Dimension(width, height));
		main.setMinimumSize(new Dimension(width, height));
		
		frame.add(main);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		main.start();
	}
}
