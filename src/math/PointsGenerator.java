package math;

import math.points.tracker.PointsTracker;

public class PointsGenerator {
	float dc; // slope of cone
	float dp; // slope of plane
	float plane0; // initial position of plane
	
	public PointsTracker tracker = new PointsTracker();
	
	public PointsGenerator(float dc, float dp, float plane0) {
		this.dc = dc;
		this.dp = dp;
		this.plane0 = plane0;
	}

	public int upperbound, lowerbound;


	private void generateAtZ(int z) {
		

		float coner = z * dc; // cone()
		float yshift = z * dp + plane0; // plane()

		if(Math.abs(coner) >= Math.abs(yshift))  {// Test for NaN
			float ptspositive = (float) Math.sqrt(coner*coner - yshift * yshift);
	

			tracker.add(ptspositive, yshift);
		}
	}
	/**
	 * if z exceeds the upper bound, then the new upper bound is z
	 * @param z
	 */
	public void generateUntilZ(int z) {
		if(z > upperbound) {
			for(int i=upperbound; i<z; i++) {
				generateAtZ(z);
			}
			upperbound = z;
		}
	}
	
}
