package math;

import java.util.List;

import main.Main;
import math.points.tracker.PointsTracker;

public class PointsRenderer {
	public PointsTracker tracker;
	public PointsRenderer(PointsTracker pointsToDraw) {
		this.tracker = pointsToDraw;
	}
	public boolean interpolation = true;
	public boolean hybrid = false;
	/**
	 * Stop at stopIndex. stopIndex will NOT be included.
	 * if stopIndex is -1, then it will draw until the end of the list.
	 * @param stopIndex
	 */
	public void draw(int stopIndex) {
		List<Float> xs = tracker.xs;
		List<Float> ys = tracker.ys;
		if(stopIndex == -1) {
			stopIndex = xs.size();
		}

		Main main = Main.main;
		main.pushStyle();
		main.strokeWeight(2);
		main.stroke(255, 0, 0);
		if(stopIndex < 1) return;
		int i;
		float cachx = 0;
		float cachy = 0 ;
		if(interpolation) {
			
			i=1;
			cachx = xs.get(0);
			cachy = ys.get(0);
//			System.out.println(cachx);
			main.line(cachx, cachy, -cachx, cachy); // 
//			System.out.print("fgakshdgf");
		} else {
			i=0;
		}
		
	

		for(;i<stopIndex;i++) {
			float x = xs.get(i);
			float y = ys.get(i);
			if(interpolation) {

			
				main.line(x, y, cachx, cachy);
				main.line(-x, y, -cachx, cachy);
			
				cachx = x;
				cachy = y;
				if(hybrid && i==5) {
					interpolation = false;
				}
			} else {
				main.point(x, y);
				main.point(-x, y);
			}
		}
	

	
		main.popStyle();
		main.pushStyle();
		main.strokeWeight(2);
		main.stroke(255, 0, 0);
		main.translate(-200, -200);
		
//		int z =0;
//		for(int i=0;i<xs.size();i++) {
//			float x = xs.get(i);
////			float y = ys.get(i);
//			main.point(x, z);
//			main.point(-x, z);
//			z++;
//		}
		main.popStyle();
	}
}
