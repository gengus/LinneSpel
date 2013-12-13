package LinneSpel.View;

import java.util.List;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.opengl.Texture;

public class ParticleSystem {
	private final int NR_OF_SPARK_PARTICLES;
	private final int NR_OF_FLAMESMOKE_PARTICLES;
	private final int NR_OF_SHOCKWAVE_PARTICLES;
	private final int NR_OF_DEBRIS_PARTICLES;
	private ShockWaveParticle[] shockWaveParticle;
	private DebrisParticle[] debrisParticle;
	private SparkParticle[] sparkParticle;
	private Vector2f startPos;
	private Vector2f res;
	private Image image;
	private Image spark;
	private int counter;

	
//	private Texture texture;
	
public ParticleSystem(Vector2f resolution, Image img)
{
	this.startPos = new Vector2f(0.5f, 0.5f);
	image=img;
	
	this.NR_OF_SPARK_PARTICLES = 20000;
	this.NR_OF_SHOCKWAVE_PARTICLES = 5;
	this.NR_OF_FLAMESMOKE_PARTICLES = 0;
	this.NR_OF_DEBRIS_PARTICLES = 100;
	
	this.debrisParticle = new DebrisParticle[NR_OF_DEBRIS_PARTICLES];				//Debrispartiklar
	
	Image debrisImage1 = image.getSubImage(240, 240, 40, 40).copy();				//kopierar bild från spritesheet
			
	for(int j=0; j<NR_OF_DEBRIS_PARTICLES; j++)
	{
		debrisParticle[j] = new DebrisParticle(this.startPos, debrisImage1.copy());
	}

	
//	this.flamesmokeParticle = new FlameSmokeParticle[NR_OF_FLAMESMOKE_PARTICLES];
//	
//	this.flamesmokeParticle = new FlameSmokeParticle[NR_OF_FLAMESMOKE_PARTICLES];
//	Image flameSmokeImage1 = image.getSubImage(0, 0, 120, 120).copy();
//	flameSmokeImage1.setCenterOfRotation(60, 60);
//	Image flameSmokeImage2 = image.getSubImage(120, 0, 120, 120).copy();
//	flameSmokeImage1.setCenterOfRotation(60+120, 60);
//	Image flameSmokeImage3 = image.getSubImage(0, 120, 120, 120).copy();
//	flameSmokeImage1.setCenterOfRotation(60, 60+120);
//	Image flameSmokeImage4 = image.getSubImage(120, 120, 120, 120).copy();
//	flameSmokeImage1.setCenterOfRotation(60+120, 60+120);
//			
//	counter=0;
//	for(int j=0; j<NR_OF_FLAMESMOKE_PARTICLES; j++)
//	{
//		switch(counter)
//		{
//		case(0):
//			flamesmokeParticle[j] = new FlameSmokeParticle(this.startPos, 2, 2, flameSmokeImage1.copy());
//		case(1):
//			flamesmokeParticle[j] = new FlameSmokeParticle(this.startPos, 2, 2, flameSmokeImage2.copy());
//		case(2):
//			flamesmokeParticle[j] = new FlameSmokeParticle(this.startPos, 2, 2, flameSmokeImage3.copy());
//		case(3):
//			flamesmokeParticle[j] = new FlameSmokeParticle(this.startPos, 2, 2, flameSmokeImage4.copy());
//		}
//		counter++;
//		if(counter==4)
//			counter=0;
//	}
	
	this.sparkParticle = new SparkParticle[NR_OF_SPARK_PARTICLES];			//Sparkpartiklar
	spark = image.getSubImage(360, 360, 120, 120);							//kopierar bild från spritesheet
	for(int i=0; i<this.sparkParticle.length; i++)
	{
		sparkParticle[i] = new SparkParticle(this.startPos, spark.copy());
	}
	
	
	this.shockWaveParticle = new ShockWaveParticle[NR_OF_SHOCKWAVE_PARTICLES];		//Shockwavepartiklar
	Image shockwave = image.getSubImage(360, 240, 120, 120);						//kopierar bild från spritesheet
	for(int i=0; i<this.shockWaveParticle.length; i++)
	{

		shockWaveParticle[i] = new ShockWaveParticle(this.startPos, shockwave.copy());
	}
	
	this.res = resolution;
}


public void update(int elapsedTime)
{
	for(int i=0; i<NR_OF_SHOCKWAVE_PARTICLES; i++)
	{
		this.shockWaveParticle[i].update(elapsedTime);
	}
	
	for(int i=0; i<NR_OF_SPARK_PARTICLES; i++)
	{
		this.sparkParticle[i].update(elapsedTime);
	}
	
//	for(int i=0; i<NR_OF_FLAMESMOKE_PARTICLES; i++)
//	{			
//		this.flamesmokeParticle[i].update(elapsedTime);
//	}
//	
	for(int i=0; i<NR_OF_DEBRIS_PARTICLES; i++)
	{			
		this.debrisParticle[i].update(elapsedTime);
	}
	
}

public void draw(Graphics g)
{

	for(int i=0; i<NR_OF_SHOCKWAVE_PARTICLES; i++)
	{
		this.shockWaveParticle[i].draw(res);
	}
	
	for(int i=0; i<NR_OF_SPARK_PARTICLES; i++)
	{		
		this.sparkParticle[i].draw(res);
	}
	
//	for(int i=0; i<NR_OF_FLAMESMOKE_PARTICLES; i++)
//	{
//		
//		
////		if(flamesmokeParticle[i].isAlive())
//			this.flamesmokeParticle[i].draw(res,g);
//	}
	
	for(int i=0; i<NR_OF_DEBRIS_PARTICLES; i++)
	{
			this.debrisParticle[i].draw(res);
	}
}
}