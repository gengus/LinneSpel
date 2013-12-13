package LinneSpel.View;

import java.util.Random;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;


public class SplitterParticle {
	private Vector2f pos;
	private Vector2f velocity;
	private Vector2f newVelocity;
	private Vector2f acceleration;
	private Random r;
	private Vector2f randomDir;
	private final float MAX_SPEED = 0.1f;
	private Vector2f newPos;
	
public SplitterParticle(Vector2f startPos)
{
	this.pos = new Vector2f(startPos);
	
	r=new Random();

	randomDir = new Vector2f(r.nextFloat()-0.5f, r.nextFloat()-0.5f);
	randomDir.normalise();	

	randomDir.x = randomDir.x * (r.nextFloat() * MAX_SPEED);
	randomDir.y = randomDir.y * (r.nextFloat() * MAX_SPEED);
	

	velocity = new Vector2f(randomDir);
	newVelocity = new Vector2f();
	newPos = new Vector2f();

	
	this.acceleration = new Vector2f(0.0f,0.1f);

}

public void update(int elapsedTime)
{
	

	newVelocity.x = ((float)elapsedTime/1000f)*acceleration.x + velocity.x;
	newVelocity.y = ((float)elapsedTime/1000f)*acceleration.y + velocity.y;
	
	newPos.x = ((float)elapsedTime/1000f)*newVelocity.x + pos.x; 
	newPos.y = ((float)elapsedTime/1000f)*newVelocity.y + pos.y;
	

	velocity=newVelocity;
	pos=newPos;
	

}

public void draw(Image image, Vector2f res, Graphics g)
{

	Vector2f drawPos = Camera.translateCoord(this.pos, res);
	image.draw(drawPos.getX(), drawPos.getY(), image.getHeight(), image.getWidth());
}

}