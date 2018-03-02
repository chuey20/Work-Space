import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class WalkingFrame extends JFrame implements ActionListener
{
	private Man man;
	private Man man2;
	private Ball ball;
	public ArrayList<Ball> ballList;
	public Goal goal;
	private int balls = 21;
	private JLabel ballCount;
	private boolean done = false;
	
	public WalkingFrame()
	{
		ballList = new ArrayList<Ball>();
		setBounds(100,100,600,400);
		setLayout(null);
		man = new Man(0,0);
		add(man);
		man2 = new Man(565, 0);
		add(man2);
		goal = new Goal(530, 150);
		add(goal);
		ballCount = new JLabel(""+(balls-1));
		ballCount.setBounds(0, 340, 20, 20);
		add(ballCount);
		Timer timer = new Timer(10, this);
		timer.start();
		addKeyListener(new KeyListener()
			{
				public void keyPressed(KeyEvent e) 
				{
					if(e.getKeyCode()==e.VK_W)
					{
						man.setDY(-2);
					}
					if(e.getKeyCode()==e.VK_S)
					{
						man.setDY(2);
					}
					if(e.getKeyCode()==e.VK_A)
					{
						man.setDX(-2);
					}
					if(e.getKeyCode()==e.VK_D)
					{
						man.setDX(2);
					}
					
					//movements for second man are JIKL
					
					if(e.getKeyCode()==e.VK_I)
					{
						man2.setDY(-2);
					}
					if(e.getKeyCode()==e.VK_K)
					{
						man2.setDY(2);
					}
					if(e.getKeyCode()==e.VK_J)
					{
						man2.setDX(-2);
					}
					if(e.getKeyCode()==e.VK_L)
					{
						man2.setDX(2);
					}
					
					if(e.getKeyCode() == e.VK_SPACE)
					{	
						if(!done)
						{
						ball = new Ball(man.getX()+8,man.getY()+10);
						add(ball);
						ball.setDX(4);
						ballList.add(ball);	
						balls--;
						ballCount.setText(""+(balls-1));
						}
					}	
				}
				
				public void keyReleased(KeyEvent e) 
				{
					if(e.getKeyCode()==e.VK_W)
					{
						man.setDY(0);
					}
					if(e.getKeyCode()==e.VK_S)
					{
						man.setDY(0);
					}
					if(e.getKeyCode()==e.VK_A)
					{
						man.setDX(0);
					}
					if(e.getKeyCode()==e.VK_D)
					{
						man.setDX(0);
					}
					
					
					if(e.getKeyCode()==e.VK_I)
					{
						man2.setDY(0);
					}
					if(e.getKeyCode()==e.VK_K)
					{
						man2.setDY(0);
					}
					if(e.getKeyCode()==e.VK_J)
					{
						man2.setDX(0);
					}
					if(e.getKeyCode()==e.VK_L)
					{
						man2.setDX(0);
					}
				}
				public void keyTyped(KeyEvent e) 
				{
					
				}
			
			});
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args)
	{
		new WalkingFrame();
	}
	
	
	public boolean intersects(JComponent testa, JComponent testb)
	{
	    Area areaA = new Area(testa.getBounds());
	    Area areaB = new Area(testb.getBounds());

	    return areaA.intersects(areaB.getBounds2D());
	}
	

	public void actionPerformed(ActionEvent arg0) 
	{
		for(int k = 0; k < ballList.size(); k++)
		{

			if(intersects(ballList.get(k), goal))
			{
				done = true;
			}
			
			else if(intersects(ballList.get(k), man2))
			{
				remove(ballList.get(k));
				ballList.remove(k);
			}
		}	
		
		if(done)
		{
			remove(ball);
			remove(man);
			remove(man2);
			remove(goal);
			remove(ballCount);
			JLabel end = new JLabel("Player 1 Wins!");
			end.setBounds(260, 150, 100, 10);
			add(end);
			JLabel play = new JLabel("Play Again? Hit Enter");
			play.setBounds(255, 170, 150, 20);
			add(play);
			

			this.addKeyListener(new KeyListener()
			{
				public void keyPressed(KeyEvent e)
				{
					if(e.getKeyCode() == e.VK_ENTER)
					{
						balls = 21;
						man.setLocation(0,0);
						add(man);
						man2.setLocation(565, 0);
						add(man2);
						goal.setLocation(530, 150);
						add(goal);
						ballCount.setText(""+(balls-1));
						ballCount.setBounds(0, 340, 20, 20);
						add(ballCount);
						remove(play);
						remove(end);
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});	
		}
		else if(balls <= 0)
		{
			remove(ball);
			remove(man);
			remove(man2);
			remove(goal);
			remove(ballCount);
			JLabel end2 = new JLabel("Player 2 Wins!");
			end2.setBounds(260, 150, 100, 10);
			add(end2);
			JLabel play2 = new JLabel("Play Again? Hit Enter");
			play2.setBounds(255, 170, 150, 20);
			add(play2);
			
			this.addKeyListener(new KeyListener()
			{
				public void keyPressed(KeyEvent e)
				{
					if(e.getKeyCode() == e.VK_ENTER)
					{ 
						balls = 21;
						man.setLocation(0,0);
						add(man);
						man2.setLocation(565, 0);
						add(man2);
						goal.setLocation(530, 150);
						add(goal);
						ballCount.setText(""+(balls-1));
						ballCount.setBounds(0, 340, 20, 20);
						add(ballCount);
						remove(play2);
						remove(end2);
					}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		
		if(ballList.size() != 0)
		{
			for(int i = 0; i < ballList.size(); i++)
			{
				ballList.get(i).update();
				if(ballList.get(i).getX() > 600 || ballList.get(i).getY() > 400)
				{
					remove(ballList.get(i));
					ballList.remove(i);
				}
			}
		}
		
		if(man.getY() > 340)
		{
			man.setLocation(man.getX(), man.getY() - 20);
		}
		else if(man.getY() < 0)
		{
			man.setLocation(man.getX(), man.getY() + 20);
		}
		if(man.getX() > 260)
		{
			man.setLocation(man.getX() - 20,  man.getY());
		}
		else if(man.getX() < 0)
		{
			man.setLocation(man.getX() + 20,  man.getY());
		}
		
		
		if(man2.getY() > 340)
		{
			man2.setLocation(man2.getX(), man2.getY() - 20);
		}
		else if(man2.getY() < 0)
		{
			man2.setLocation(man2.getX(), man2.getY() + 20);
		}
		
		if(man2.getX() < 300)
		{
			man2.setLocation(man2.getX() + 20,  man2.getY());
		}
		else if(man2.getX() > 565)
		{
			man2.setLocation(man2.getX() - 20,  man2.getY());
		}
		
		man.update();
		man2.update();
		repaint();
	}
}

