import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import javax.swing.JComponent;

public class Goal extends JComponent
{
	
	public Goal(int x, int y)
	{
		setLocation(x,y);
		setSize(30, 70);
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Rectangle goal = new Rectangle(0, 0, 20, 70);
		g2.fill(goal);
	}
	
	
}
