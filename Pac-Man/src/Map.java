import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Map extends Main {
	// Constructor for the Map class
	int x;
	int y;
	JLabel border;
	public Map(String path, int y1, int x1, int height, int width)
	{
		 border = new JLabel(new ImageIcon(path)); 
		panel.add(border);
		border.setBounds(x1, y1, width, height);
		border.setVisible(true);
		x = x1;
		y = y1;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
