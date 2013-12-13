package LinneSpel.View;

import org.newdawn.slick.geom.Vector2f;

public class Camera {

	
	
	public static Vector2f translateCoord(Vector2f logicPos, Vector2f resolution)
	{
		
		Vector2f visualPos = new Vector2f();

		float scale;
		
		
		if (resolution.x < resolution.y)
			scale = resolution.x;
		else
			scale = resolution.y;

	
		visualPos.set((logicPos.getX()) * scale, (logicPos.getY() * scale)); 
		

				
		return visualPos;
		
		
	}
	
	public float[] translateCoord(float logicX, float logicY, float width, float height)
	{
		
		float[] visualCoord = new float[2];

		//visualX
		visualCoord[0] = logicX * height; 
		
		//visualY
				
		visualCoord[1] = logicY * height;
				
		return visualCoord;
		

	}
	
	
}


