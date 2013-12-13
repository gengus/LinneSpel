package LinneSpel.View;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class SplitterSystem {
	private final int NR_OF_PARTICLES;
	private SplitterParticle[] splitterParticle;
	private Vector2f startPos;
	private Vector2f res;

public SplitterSystem(Vector2f resolution)
{
	this.startPos = new Vector2f(0.5f, 0.5f);
	this.NR_OF_PARTICLES = 100;
	this.splitterParticle = new SplitterParticle[NR_OF_PARTICLES];
	
	for(int i=0; i<this.splitterParticle.length; i++)
	{
		splitterParticle[i] = new SplitterParticle(this.startPos);
	}
	
	this.res = resolution;
}


public void update(int elapsedTime)
{
	for(int i=0; i<NR_OF_PARTICLES; i++)
	{
		this.splitterParticle[i].update(elapsedTime);
	}
}

public void draw(Image img, Graphics g)
{

	for(int i=0; i<NR_OF_PARTICLES; i++)
	{
		this.splitterParticle[i].draw(img, res, g);
	}
}

}