package math.points.tracker;

public class DoublePointsTracker implements IPointsTracker{
	PointsTracker pos, neg;

	public DoublePointsTracker(PointsTracker pos, PointsTracker neg) {
		this.pos = pos;
		this.neg = neg;
	}
	@Override
	public void add(float x, float y) {
		pos.add(x, y);
	}
	public void addNegative(float x, float y) {
		neg.add(x, y);
	}
	public float getX(int i) {
		if(i >= 0) {
			return pos.xs.get(i);
		}
		return neg.xs.get(-i - 1);
	}
	public float getY(int i) {
		if(i >= 0) {
			return pos.ys.get(i);
		}
		return neg.ys.get(-i - 1);
	}
	
}
