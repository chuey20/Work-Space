import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class Ball extends JComponent
{
	private static final long serialVersionUID = 8291798221537007867L;
	private int x, y;
	private int dx, dy;
	

	public Ball(int x, int y)
	{
		this.x = x;
		this.y = y;
		setLocation(x,y);
		setSize(4, 4);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D.Double ball = new Ellipse2D.Double(0,0,4,4);
		g2.fill(ball);
	}
	
	public void setDY(int y)
	{
		dy = y;
	}
	
	public void setDX(int x)
	{
		dx = x;
	}
	
	public void update()
	{
		setLocation(getX() + dx, getY() + dy);
	}
	
}
