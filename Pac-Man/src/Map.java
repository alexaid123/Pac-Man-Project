import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Map extends Main {
	// Constructor for the Map class
	public Map(String path, int y, int x, int height, int width)
	{
		JLabel border = new JLabel(new ImageIcon(path)); 
		panel.add(border);
		border.setBounds(x, y, width, height);
		border.setVisible(true);
	}
}
