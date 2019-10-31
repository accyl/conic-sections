package math;

import main.Main;

public class ConesMath {
	float dc; // slope of cone
	float dp; // slope of plane
	float plane0; // initial position of plane
	
	
	
	public ConesMath(float dc, float dp, float plane0) {
		this.dc = dc;
		this.dp = dp;
		this.plane0 = plane0;
	}

	int z=0;
	public void setZ(int z) {
		this.z = z;
	}
	
	private float coner;
	public void cone() {
		coner = z * dc;
		Main.main.ellipse(0, 0, coner*2, coner*2);
		
	}
	
	
	private float yshift;
	public void plane() {
		yshift = z * dp + plane0;
		Main.main.line(-1000, yshift, 1000, yshift);
	}
	
	public PointsTracker tracker = new PointsTracker();
	public void planeXCone() {
		
		Main main = Main.main;
//		main.pushStyle();
//		main.fill(0,0,0,0);
//		main.stroke(255,255,255,30);
//		cone();
//		plane();
//		main.popStyle();
//		

		//
		main.pushStyle();
		main.fill(0,0,0,0);

		main.stroke(0,0,0,256);
		cone();
		plane();
		main.strokeWeight(2);
		main.stroke(0,256,0); // center of circle
		main.point(0, 0);
		main.popStyle();
		if(Math.abs(coner) < Math.abs(yshift)) return; // NaN
		float ptspositive = (float) Math.sqrt(coner*coner - yshift * yshift);

//		main.point(ptspositive, yshift);
//		main.point(-ptspositive, yshift);
		tracker.add(ptspositive, yshift);
//		tracker.add(-ptspositive, yshift); this one is automatically generated at draw
		tracker.draw();

	}
	
	
	
}
