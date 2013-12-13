package LinneSpel.View;

import java.util.Random;
import java.math.*;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.opengl.Texture;
//import org.newdawn.slick.particles.ConfigurableEmitter.RandomValue;

public class SparkParticle {
	private Vector2f pos;
	private Vector2f velocity;
	private Random r;
	private Vector2f randomDir;
	private final float MAX_SPEED = 0.5f;
	private Image image;
	private Color c;
	
public SparkParticle(Vector2f startPos, Image img)
{
	this.pos = new Vector2f(startPos);
	image = img.copy();
	
	r=new Random();

	randomDir = new Vector2f(r.nextFloat()-0.5f, r.nextFloat()-0.5f);
	randomDir.normalise();	

	randomDir.x = randomDir.x * (r.nextFloat() * MAX_SPEED);		
	randomDir.y = randomDir.y * (r.nextFloat() * MAX_SPEED);
	
	this.pos.add(randomDir);												
	image.setCenterOfRotation(120f, (float)image.getHeight()/2f);				//roteringscentrum längs in på texturen
	image.rotate((float)randomDir.getTheta()+180f);								//riktning i grader = positionsvektorn
	
	this.velocity = new Vector2f(randomDir.x*0.1f, randomDir.y*0.1f);



}

public void update(int elapsedTime)
{
	pos.add(velocity);	
}

public void draw(Vector2f res)
{

	c = new Color(250, 215, 0);			//färg på spark
	
	Vector2f drawPos = Camera.translateCoord(this.pos, res);
		
	image.draw(drawPos.getX()-image.getWidth(), drawPos.getY()-image.getHeight()/2, image.getHeight(), image.getWidth(),c);
	
}

}