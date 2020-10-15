import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;

public class Main
{
	//Initializes all required objects
	public static JFrame frame = new JFrame();
	public static JPanel panel = new JPanel();
	public static JLabel PacManLabel, nameLabel; 
	public static JTextField nameText; 
	public static JButton startButton = new JButton(new ImageIcon("images/start.png")); 
	static ArrayList<Map> borders = new ArrayList<Map>();
	public static int X, Y;

	public static void main(String args[])
	{
		makeHomePage();
	}
	
	public static void makeHomePage()
	{
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(700,500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		frame.setFocusable(true);
		frame.add(panel);
		panel.setBackground(Color.BLACK);
		panel.setLayout(null);
		
		panel.add(startButton);
		startButton.setBounds(100,300,500,115); 
		
		nameLabel = new JLabel("Enter your name:"); 
		nameLabel.setBounds(263,150,200,50); 
		nameLabel.setFont(new Font("", Font.PLAIN, 20)); 
		nameLabel.setForeground(Color.RED); 
		panel.add(nameLabel);
		
		nameText = new JTextField("");
		panel.add(nameText);
		nameText.setBounds(250,200,200,30);
		 
		PacManLabel = new JLabel("Pac-Man");
		panel.add(PacManLabel);
		PacManLabel.setBounds(193,20,400,50); 
		PacManLabel.setFont(new Font("", Font.BOLD, 70)); 
		PacManLabel.setForeground(Color.YELLOW); 
		
		startButton.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				startButton.setVisible(false);  
				nameText.setVisible(false);
				nameLabel.setVisible(false);
				PacManLabel.setVisible(false);
				makeMap();
			} 
		} ); 
	}
//	public static int x_coord(JLabel R, JLabel L)
//	{
//		if(R.isVisible())
//			return R.getX();
//		if(L.isVisible())
//			return L.getX();
//		return 0;
//	}
//	public static int y_coord(JLabel U, JLabel D)
//	{
//		if(U.isVisible())
//			return U.getY();
//		if(D.isVisible())
//			return D.getY();
//		return 0;
//	}
	public static void makeMap()
	{
		//Outputs the Welcome name! message
		String s1 = nameText.getText();
		JOptionPane.showMessageDialog(nameText,"Welcome " + s1 + "!", "Pac-Man", 1); 
		
		// Adding maze borders with a loop using Map class objects
		for(int i = 100; i <= 1000; i++)
		{
			borders.add(new Map("images/horizontalBorder.png",0,i,100,10));
			i += 99;
		}
			borders.add(new Map("images/horizontalBorder.png",150,0,10,300));
			borders.add(new Map("images/horizontalBorder.png",150,350,10,350));
			borders.add(new Map("images/horizontalBorder.png",300,0,10,300));
			borders.add(new Map("images/horizontalBorder.png",300,350,10,350));
		
		//Side Borders in the map
		JLabel topBorder1 = new JLabel(new ImageIcon("images/horizontalBorder.png"));
		panel.add(topBorder1);
		topBorder1.setBounds(-110,0,800,10); 
		
		JLabel bottomBorder1 = new JLabel(new ImageIcon("images/horizontalBorder.png")); 
		panel.add(bottomBorder1);
		bottomBorder1.setBounds(-110,453,800,10); 
		
		JLabel sideBorder1 = new JLabel(new ImageIcon("images/verticalBorder.png")); 
		panel.add(sideBorder1);
		sideBorder1.setBounds(0,0,10,463); 
		
		JLabel sideBorder2 = new JLabel(new ImageIcon("images/verticalBorder.png")); 
		panel.add(sideBorder2);
		sideBorder2.setBounds(690,0,10,463); 
		
		//Adds 4 PacMans facing different directions
		JLabel pacman_right = new JLabel(new ImageIcon("images/pacman_right.gif")); 
		JLabel pacman_left = new JLabel(new ImageIcon("images/pacman_left.gif")); 
		JLabel pacman_up = new JLabel(new ImageIcon("images/pacman_up.gif")); 
		JLabel pacman_down = new JLabel(new ImageIcon("images/pacman_down.gif")); 
		pacman_right.setBounds(150, 90,400,365);
		panel.add(pacman_right); panel.add(pacman_left); 
		panel.add(pacman_up); 	 panel.add(pacman_down);
		X = 330; Y = 250;
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					pacman_right.setVisible(true);
					pacman_left.setVisible(false);
					pacman_up.setVisible(false);
					pacman_down.setVisible(false);
					
					if(X >= 648)
					{
						X = 648;
					}
					else
					{
						X += 5;
					}
					pacman_right.setBounds( X, Y, 42, 42); 
				}
				if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
				{
					pacman_right.setVisible(false);
					pacman_left.setVisible(true);
					pacman_up.setVisible(false);
					pacman_down.setVisible(false);
					
					if(X <= 10)
					{
						X = 10;
					}
					else
					{
						X -= 5;
					}
					pacman_left.setBounds(X, Y, 42, 42); 
				}
				if(arg0.getKeyCode() == KeyEvent.VK_UP)
				{
					pacman_right.setVisible(false);
					pacman_left.setVisible(false);
					pacman_up.setVisible(true);
					pacman_down.setVisible(false);
					
					if(Y <= 10)
					{
						Y = 10;
					}
					else
					{
						Y -= 5;
					}
					pacman_up.setBounds(X, Y, 42, 42); 
				}
				if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
				{
					pacman_right.setVisible(false);
					pacman_left.setVisible(false);
					pacman_up.setVisible(false);
					pacman_down.setVisible(true);
					
					if(Y >= 411)
					{
						Y = 411;
					}
					else
					{
						Y += 5;
					}
					pacman_down.setBounds(X, Y, 42, 42); 
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
}

