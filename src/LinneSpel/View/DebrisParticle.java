package LinneSpel.View;

import java.util.Random;
import java.math.*;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.opengl.Texture;
//import org.newdawn.slick.particles.ConfigurableEmitter.RandomValue;

public class DebrisParticle {
	private Vector2f pos;
	private Vector2f velocity;
	private Random r;
	private Vector2f randomDir;
	private final float MAX_SPEED = 0.1f;
	private Image image;
	private float randomSize;
	private float rotateDir;
	
	public DebrisParticle(Vector2f startPos, Image img)
{
	this.pos = new Vector2f(startPos);
	image = img.copy();
	
	
	r=new Random();
	
	image.setCenterOfRotation(r.nextFloat()*20f, r.nextFloat()*20f);			//roteringscentret random
	
	rotateDir = r.nextFloat()-0.5f;												//roteringenshastighet semi-random
	
	randomDir = new Vector2f(r.nextFloat()-0.5f, r.nextFloat()-0.5f);

	randomDir.x = randomDir.x * (r.nextFloat() * MAX_SPEED);
	randomDir.y = randomDir.y * (r.nextFloat() * MAX_SPEED);
	
	
	
	randomSize = r.nextFloat()*2f;												//random storlek
	image = image.getScaledCopy(randomSize);
	
	
	this.pos.add(randomDir);
	
	this.velocity = new Vector2f(randomDir.x*0.1f, randomDir.y*0.1f);			//random riktning



}

public void update(int elapsedTime)
{
	pos.add(velocity);
}

public void draw(Vector2f res)
{	
	Vector2f drawPos = Camera.translateCoord(this.pos, res);

	image.rotate(2f*rotateDir*2);									//rotera	
	image.drawCentered(drawPos.getX(), drawPos.getY());				
	
}

}