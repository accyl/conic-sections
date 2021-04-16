package math.points.tracker;

import java.util.ArrayList;
import java.util.List;



public class PointsTracker implements IPointsTracker{
	public List<Float> xs, ys;

	public PointsTracker() {
		this.xs = new ArrayList<>();
		this.ys = new ArrayList<>();
	}
	
	public float cachx, cachy;
	
	/**
	 * Only add one copy, please - the other one generated at draw
	 * @param x
	 * @param y
	 */
	public void add(float x, float y) {
		if(x != x || y != y) return; // NaN
		if(cachx == x && cachy == y) return; // remove redundancies
		cachx = x;
		cachy = y;
		xs.add(x); 
		ys.add(y);
	}

	@Override
	public float getX(int z) {
		return xs.get(z);
	}

	@Override
	public float getY(int z) {
		return ys.get(z);
	}

	
}
