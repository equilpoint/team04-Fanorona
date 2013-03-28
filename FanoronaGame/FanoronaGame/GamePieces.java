package FanoronaGame;


import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GamePieces extends JButton {
	Color c;

	public GamePieces(char color) {
		// get the color of the piece based on the data array
		if (color == 'B') {
			c = Color.black;
		} else if (color == 'W') {
			c = Color.white;
		} else {
			c = new Color(110,110,110);
			setContentAreaFilled(false);
			setBorderPainted(false);
		}
		// These statements enlarge the button so that it
		// becomes a circle rather than an oval.
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);

		// This call causes the JButton not to paint
		// the background.
		// This allows us to paint a round background.
		setContentAreaFilled(false);
	}

	// Paint the round background and label.
	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
			// You might want to make the highlight color
			// a property of the GamePieces class.
			g.setColor(Color.red);
		} else {
			g.setColor(getBackground()) ;
			if(this.c == new Color(110,110,110) )
				g.clearRect(getX(), getY(), getWidth()-10, getHeight()-10);
				this.setContentAreaFilled(false);
		}
		g.fillOval(10, 10,  getWidth()-10, getWidth()-10);
		
		// This call will paint the label and the
		// focus rectangle.
		super.paintComponent(g);
	}

	// Paint the border of the button using a simple stroke.
	@Override
	protected void paintBorder(Graphics g) {
		g.drawOval(10, 10, getWidth()-10, getWidth()-10);
		//g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight()); // very
		// ghetto grid solution
	}
	
//	@Override
//	public void setLocation(int x, int y) {
//		GamePieces graphics = this;	
//		graphics.setLocation(x, y);
//	}
	

//	// Hit detection.
	Shape shape;

	public boolean contains(int x, int y) {
		// If the button has changed size,
		// make a new shape object.
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		}
		return shape.contains(x, y);
	}
}