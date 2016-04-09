package com.allg.asteroides.engine;

public class Collision {

	public static boolean isCollided(GameObject a, GameObject b) {
		
		if (a.x >= b.x && a.x <= (b.x + b.width))
			if (a.y >= b.y && a.y <= (b.y + b.height))
				return true;

        if (b.x >= a.x && b.x <= (a.x + a.width))
            if (b.y >= a.y && b.y <= (a.y + a.height))
                return true;
		
		return false;
	
	}
	
}
