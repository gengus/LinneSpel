package LinneSpel.View;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
//import org.newdawn.slick.particles.ConfigurableEmitter.RandomValue;

public class ShockWaveParticle {
	private Vector2f pos;
	
	private float timeLived;
	private float maxLifeTime;
	private float lifePercent;
	private float minSize;
	private float maxSize;
	private float size;
		
	private Image image;
	private Color color;
	
public ShockWaveParticle(Vector2f startPos, Image img)
{
	this.pos = startPos;
	image=img;
	
	timeLived = 0;				
	maxLifeTime = 1.1f;							//tiden då shockwaven ska växa
	minSize = 0.5f;					//min storlek
	maxSize = 20.0f;				//max storlek
	
}


public void update(int elapsedTime)
{
		timeLived+=1f/60f;
		lifePercent = timeLived/maxLifeTime;
		size=minSize+lifePercent*maxSize;
	
}

public void draw(Vector2f res)
{
		color=new Color(240, 230, 140);  //färg på shockwave
			
		Vector2f drawPos = Camera.translateCoord(this.pos, res);
		
		image.draw((drawPos.getX()-(float)image.getWidth()*size/2), (drawPos.getY()-(float)image.getHeight()*size/2), 
				+ (float)image.getWidth()*size, (float)image.getHeight()*size, color);
		
}

}