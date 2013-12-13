package LinneSpel.View;

import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
//import org.newdawn.slick.particles.ConfigurableEmitter.RandomValue;

public class SmokeParticle {
	private Vector2f pos;
	private Vector2f velocity;
	private Vector2f newVelocity;
	private Vector2f acceleration;
	private Random r;
	private Vector2f randomDir;
	private final float MAX_SPEED = 0.1f;
	private Vector2f newPos;
	private Vector2f startPos;
	
	private float timeLived;
	private float maxLifeTime;
	private float lifePercent;
	private float minSize;
	private float maxSize;
	private float size;
	
	private float delayTime;
	private boolean render = false;
	private boolean isAlive = false;
	
	private Color fadeColor;
	private float transparency;
	private float minTransparency;
	private float maxTransparency;
	
public SmokeParticle(Vector2f startPos)
{
	this.startPos = new Vector2f(startPos);
	initParticle(0f);
}

public void initParticle(float timeOffset)
{
	this.pos = startPos;
	
	r=new Random();

	randomDir = new Vector2f(r.nextFloat()-0.5f, r.nextFloat()-1.5f);			//random direction
	randomDir.normalise();	

	randomDir.x = randomDir.x * (r.nextFloat() * MAX_SPEED);			
	randomDir.y = randomDir.y * (r.nextFloat() * MAX_SPEED);
	

	velocity = new Vector2f(randomDir);										//velocity = randomdir 
	newVelocity = new Vector2f();
	newPos = new Vector2f();

	this.acceleration = new Vector2f(0.0f,-0.02f);				//accelererar sakta uppåt
	
	timeLived = 0;
	maxLifeTime = 4.0f;										//rökpartikelns levnadstid
	minSize = 0.5f;											//storlek min & max
	maxSize = 4.5f;								
	
	delayTime = r.nextFloat()*3f+timeOffset;			//random tid innan rökpartikeln spawnas

	minTransparency=1.0f;								//transparens
	maxTransparency=1.0f;
}


public void update(int elapsedTime)
{
	delayTime-=(float)elapsedTime/1000;
	
	if(delayTime<0||isAlive)						//partikeln startas eller är fortfarande levande
	{
		timeLived+=1f/60f;
		lifePercent = timeLived/maxLifeTime;
		size=minSize+lifePercent*maxSize;
	
		newVelocity.x = ((float)elapsedTime/1000f)*acceleration.x + velocity.x;			
		newVelocity.y = ((float)elapsedTime/1000f)*acceleration.y + velocity.y;
		newPos.x = ((float)elapsedTime/1000f)*newVelocity.x + pos.x; 
		newPos.y = ((float)elapsedTime/1000f)*newVelocity.y + pos.y;
	
		velocity=newVelocity;
		pos=newPos;
		
		
		
		if (timeLived>=maxLifeTime)				//parikeln är död och ominitieras
		{
			initParticle(timeLived);		
			isAlive=true;
			render=false;					//ska inte ritas ut
			
		}
		else
		{
			render=true;				//fortfarande levande, ska ritas ut
		}
	}
	
}

public void draw(Image image, Vector2f res, Graphics g)
{
	if(render=true)
	{
		transparency=minTransparency-(maxTransparency*lifePercent);			//transparens går mellan 1(helt synlig) till >0 (helt osynlig)
		
		fadeColor=new Color(transparency, transparency, transparency, transparency);  //filterfärg för partikel
				
		Vector2f drawPos = Camera.translateCoord(this.pos, res);
		image.rotate(0.0005f);											//svag rotation
		image.draw(drawPos.getX(), drawPos.getY(), (float)image.getHeight()*size, (float)image.getWidth()*size, fadeColor);
	}

}

}