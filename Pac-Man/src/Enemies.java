import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

public class Enemies extends Main
{
	private static JLabel red, pink, cyan, orange;
	private static int redX=50, redY=50, pinkX=50, pinkY=400, 
				cyanX=600, cyanY=50, orangeX=600, orangeY=400;
	private static boolean shown = false;
	private static JLabel score = new JLabel("Score = 0");
	private static int score1 = 0;
	public Enemies()
    {
		red = new JLabel(new ImageIcon("images/red.gif"));
		panel.add(red);
		red.setBounds(redX, redY, 30, 42);
		red.setVisible(true);
		
		pink = new JLabel(new ImageIcon("images/pink.gif"));
		panel.add(pink);
		pink.setBounds(pinkX, pinkY, 30, 42);
		pink.setVisible(true);
		
		cyan = new JLabel(new ImageIcon("images/cyan.gif"));
		panel.add(cyan);
		cyan.setBounds(cyanX, cyanY, 30, 42);
		cyan.setVisible(true);
		
		orange = new JLabel(new ImageIcon("images/orange.gif"));
		panel.add(orange);
		orange.setBounds(orangeX, orangeY, 30, 42);
		orange.setVisible(true);	
		
		panel.add(score);
		score.setBounds(460, 613, 100, 60);
		score.setForeground(Color.YELLOW); 
		score.setVisible(true);
    }
	void easyMode()
	{
		Timer t = new Timer();  
		TimerTask tt = new TimerTask() {  
		    @Override  
		    public void run() {  
		    	if((Math.abs(redX - X) <= 28 && Math.abs(redY - Y) <= 28) || (Math.abs(pinkX - X) <= 28 && Math.abs(pinkY - Y) <= 28) || (Math.abs(cyanX - X) <= 28 && Math.abs(cyanY - Y) <= 28) || (Math.abs(orangeX - X) <= 28 && Math.abs(orangeY - Y) <= 28) || win == true)
				{
					gameOver = true;
					if(!shown)
					{
						if(win == true)
						{
							JOptionPane.showMessageDialog(null, "YOU WIN!");
					    	nameLabel.setText("You won!!");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "GAME OVER!");
					    	nameLabel.setText("Game Over");
						}
						shown = true;
				    	PacManLabel.setVisible(false);
				    	red.setVisible(false);
				    	pink.setVisible(false);
				    	cyan.setVisible(false);
				    	orange.setVisible(false);
				    	for(int i = 0; i < borders.size(); i++)
				    	{
				    		borders.get(i).border.setVisible(false);
				    	}
				    	for(int i = 0; i < pellets.size(); i++)
				    	{
				    		pellets.get(i).border.setVisible(false);
				    	}
				    	nameLabel.setVisible(true);
				    	nameLabel.setFont(new Font("", Font.PLAIN, 50)); 
				    	nameLabel.setBounds(380,100,300,100);
						score.setBounds(400, 400, 350, 100);
						score.setFont(new Font("", Font.BOLD, 40));
				    	pacman_right.setVisible(false);
						pacman_left.setVisible(false);
						pacman_up.setVisible(false);
						pacman_down.setVisible(false);
						topBorder1.setVisible(false);
						bottomBorder1.setVisible(false);
						sideBorder1.setVisible(false);
						sideBorder2.setVisible(false);
						cherry.setVisible(false);
					}
				}
		    	else
		    	{
		    		for(int i = 0; i < pellets.size(); i++)
			    	{
			    		if((Math.abs(pellets.get(i).getX() - X - 20) <= 20 && Math.abs(pellets.get(i).getY() - Y - 20) <= 20))
			    		{
			    			if(pellets.get(i).border.isVisible())
		    				{
		    					score1++;
			    				pellets.get(i).border.setVisible(false);
						       	score.setText("Score = " + score1);
						       	if(score1 == 50)
						       	{
						       		cherry.setVisible(true);
						       	}
		    				}
			    		}
			    	}
		    		if(cherry.isVisible())
		    		{
		    			if((X > 285) && (X < 365) && (Y > 205) && (Y < 295))
		    			{
		    				win = true;
		    			}
		    		}
			        redX = move(redX); 						if(redX >= 948){ redX = 948;} if(redX <= 10){ redX = 10;} 
			        redY = move(redY); 						if(redY >= 611){ redY = 611;} if(redY <= 10){ redY = 10;} 
					red.setBounds(redX, redY, 30, 42);
					pinkX = move(pinkX); 					if(pinkX >= 948){ pinkX = 948;} if(pinkX <= 10){ pinkX = 10;} 
					pinkY = move(pinkY);					if(pinkY >= 611){ pinkY = 611;} if(pinkY <= 10){ pinkY = 10;} 
			        pink.setBounds(pinkX, pinkY, 30, 42);
			        cyanX = move(cyanX); 					if(cyanX >= 948){ cyanX = 948;} if(cyanX <= 10){ cyanX = 10;} 
			        cyanY = move(cyanY);					if(cyanY >= 611){ cyanY = 611;} if(cyanY <= 10){ cyanY = 10;} 
			        cyan.setBounds(cyanX, cyanY, 30, 42);
			        orangeX = move(orangeX); 		if(orangeX >= 948){ orangeX = 948;} if(orangeX <= 10){ orangeX = 10;} 
			        orangeY = move(orangeY);		if(orangeY >= 611){ orangeY = 611;} if(orangeY <= 10){ orangeY = 10;} 
			        orange.setBounds(orangeX, orangeY, 30, 42);
		    	}
		    };  
		}; 
	    t.scheduleAtFixedRate( tt, 50, 100);
	}
	void hardMode()
	{
		Timer t = new Timer();  
		TimerTask tt = new TimerTask() 
		{  
		    @Override  
		    public void run() 
		    {  
		    	if((Math.abs(redX - X) <= 28 && Math.abs(redY - Y) <= 28) || (Math.abs(pinkX - X) <= 28 && Math.abs(pinkY - Y) <= 28) || (Math.abs(cyanX - X) <= 28 && Math.abs(cyanY - Y) <= 28) || (Math.abs(orangeX - X) <= 28 && Math.abs(orangeY - Y) <= 28) || win == true)
				{
					gameOver = true;
					if(!shown)
					{
						if(win == true)
						{
							JOptionPane.showMessageDialog(null, "YOU WIN!");
					    	nameLabel.setText("You won!!");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "GAME OVER!");
					    	nameLabel.setText("Game Over");
						}
				    	shown = true;
				    	PacManLabel.setVisible(false);
				    	red.setVisible(false);
				    	pink.setVisible(false);
				    	cyan.setVisible(false);
				    	orange.setVisible(false);
				    	for(int i = 0; i < borders.size(); i++)
				    	{
				    		borders.get(i).border.setVisible(false);
				    	}
				    	for(int i = 0; i < pellets.size(); i++)
				    	{
				    		pellets.get(i).border.setVisible(false);
				    	}
				    	nameLabel.setVisible(true);
				    	nameLabel.setFont(new Font("", Font.PLAIN, 50)); 
				    	nameLabel.setBounds(380,100,300,100);
						score.setBounds(400, 400, 350, 100);
						score.setFont(new Font("", Font.BOLD, 40));
				    	pacman_right.setVisible(false);
						pacman_left.setVisible(false);
						pacman_up.setVisible(false);
						pacman_down.setVisible(false);
						topBorder1.setVisible(false);
						bottomBorder1.setVisible(false);
						sideBorder1.setVisible(false);
						sideBorder2.setVisible(false);
						cherry.setVisible(false);
					}
				}
		    	else
		    	{
		    		for(int i = 0; i < pellets.size(); i++)
			    	{
			    		if((Math.abs(pellets.get(i).getX() - X - 20) <= 20 && Math.abs(pellets.get(i).getY() - Y - 20) <= 20))
			    		{
			    			if(pellets.get(i).border.isVisible())
			    			{
			    				score1++;
				    			pellets.get(i).border.setVisible(false);
							    score.setText("Score = " + score1);
							    if(score1 == 50)
							    {
							    	cherry.setVisible(true);
							    }
			    			}
			    		}
			    	}
		    		if(cherry.isVisible())
		    		{
		    			if((X > 285) && (X < 365) && (Y > 205) && (Y < 295))
		    			{
		    				win = true;
		    			}
		    		}
		    		redX = hardMoveX(redX); 			
		    		redY = hardMoveY(redY); 
		    		red.setBounds(redX, redY, 30, 42);
		    		pinkX = hardMoveX(pinkX); 		
		    		pinkY = hardMoveY(pinkY);
		    		pink.setBounds(pinkX, pinkY, 30, 42);
		    		cyanX = hardMoveX(cyanX); 		
		    		cyanY = hardMoveY(cyanY);
		    		cyan.setBounds(cyanX, cyanY, 30, 42);
		    		orangeX = hardMoveX(orangeX); 	
		    		orangeY = hardMoveY(orangeY);
		    		orange.setBounds(orangeX, orangeY, 30, 42);
		    	}
		    };
		}; 
	    t.scheduleAtFixedRate( tt, 50, 100);
	}
	
	int move(int coord)
	{
		return (int)  (Math.random() * (100) + 10) % 2 == 0  ?  coord + 10 :  coord - 10;
	}
	
	int hardMoveX(int coord)
	{
		if(coord < X)
		{
			return coord + 2;
		}
		else if(coord > X)
		{
			return coord - 2;
		}
		return coord;
	}
	
	int hardMoveY(int coord)
	{
		if(coord < Y)
		{
			return coord + 2;
		}
		else if(coord > Y)
		{
			return coord - 2;
		}
		return coord;
	}
}
