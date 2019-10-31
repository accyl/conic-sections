package math;

import java.util.ArrayList;

import java.util.List;

import main.Main;



public class PointsTracker {
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
	boolean interpolation = true;
	boolean hybrid = false;
	public void draw() {
		Main main = Main.main;
		main.pushStyle();
		main.strokeWeight(2);
		main.stroke(255, 0, 0);
		if(xs.size() < 1) return;
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
		
	

		for(;i<xs.size();i++) {
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
