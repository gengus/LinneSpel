package LinneSpel.View;

import LinneSpel.Model.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BallView {
	Image ball;
	Camera cam = new Camera();	
	float width;
	float height;
	float displacement = 0.1f;
	
	public BallView(int width, int height)
	{		
		try {
			ball = new Image("res/eightball.png");
		} catch (SlickException e) {
			
			e.printStackTrace();
		}
		this.width = width;
		this.height = height;
	}
	
	public void render(Graphics g, BallSimulation ballSim)
	{
		float[] coord = new float[2];
		coord = cam.translateCoord(displacement, displacement, this.width, this.height);
		
		g.setColor(Color.cyan);
		g.drawRect(coord[0], coord[1], this.width-(coord[0]*2), this.height-(coord[0])*2);   	      		  //ram
		
		coord = cam.translateCoord(ballSim.b.getPos().x, ballSim.b.getPos().y, this.width, this.height);
		ball.draw(coord[0], coord[1], 0.1f*height, 0.1f*height);											  //boll
		
		g.drawString("x: " + ballSim.b.getPos().x + " y: " + ballSim.b.getPos().y, 10, 10);
		g.drawString("\n\nspeedx: " + ballSim.b.getSpeedX() + "speedy: " + ballSim.b.getSpeedY(), 10, 10);
	}
}
