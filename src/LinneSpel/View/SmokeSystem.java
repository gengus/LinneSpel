package LinneSpel.View;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class SmokeSystem {
	private final int NR_OF_PARTICLES;
	private SmokeParticle[] smokeParticle;
	private Vector2f startPos;
	private Vector2f res;

public SmokeSystem(Vector2f resolution)
{
	this.startPos = new Vector2f(0.8f, 0.9f);
	this.NR_OF_PARTICLES = 500;
	this.smokeParticle = new SmokeParticle[NR_OF_PARTICLES];
	
	for(int i=0; i<this.smokeParticle.length; i++)
	{
		smokeParticle[i] = new SmokeParticle(this.startPos);
	}
	
	this.res = resolution;
}


public void update(int elapsedTime)
{
	for(int i=0; i<NR_OF_PARTICLES; i++)
	{
		this.smokeParticle[i].update(elapsedTime);
	}
}

public void draw(Image img, Graphics g)
{

	for(int i=0; i<NR_OF_PARTICLES; i++)
	{
		this.smokeParticle[i].draw(img, res, g);
	}
}

}