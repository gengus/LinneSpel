package LinneSpel.View;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class Explosion {
	private Vector2f pos;

	private float maxLifeTime;
	private float timeElapsed;
	private float percentAnimated;
	
	private int frame;
	private int nrOfFrames;
	private int nrOfFramesX;
	private int nrOfFramesY;
	
	
public Explosion(Vector2f startPos, int nrOfFramesX,  int nrOfFramesY)
{
	this.pos = new Vector2f(startPos);
	this.nrOfFrames = nrOfFramesX*nrOfFramesY;
	this.nrOfFramesX = nrOfFramesX;
	this.nrOfFramesY = nrOfFramesY;
			
	this.pos = startPos;
	
	maxLifeTime = 0.5f;					//lever 0.5 sekunder
}


public void update(int elapsedTime)
{
	timeElapsed+=1f/60f;
	percentAnimated = timeElapsed/maxLifeTime;	
	frame = (int)(percentAnimated*nrOfFrames); 
}

public void draw(Image image, Vector2f res)
{
	int frameX = frame%nrOfFramesX;
	int frameY = frame/nrOfFramesX;
		
	float spriteHeight = (float)image.getHeight()/(float)nrOfFramesY;
	float spriteWidth  = (float)image.getWidth()/(float)nrOfFramesX;

	Vector2f drawPos = Camera.translateCoord(this.pos, res);	
	
	image.draw(drawPos.getX(), drawPos.getY(), 
				+ drawPos.getX()+spriteWidth, drawPos.getX()+spriteHeight,  
				+ spriteWidth*(float)frameX, spriteHeight*(float)frameY, 
				+ spriteWidth*(float)frameX+spriteWidth, spriteHeight*(float)frameY+spriteHeight);
}

}