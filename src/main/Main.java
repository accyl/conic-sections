package main;
import math.ConesMath;
import math.PointsRenderer;
import processing.core.PApplet;

public class Main extends PApplet{

	public static Main main;
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	@Override
	public void settings() {
		this.size(1000, 1000);
		Main.main = this;
	}
	
	@Override
	public void setup() {
		// TODO Auto-generated method stub
		super.setup();
		this.surface.setResizable(true);
		background(0x00FFFFFF); 
	}

	
	final ConesMath conesParabola = new ConesMath(0.5F,0.5F,-30);
	final ConesMath conesHyperbola = new ConesMath(0.1F,0F,-30); 
	// this is a dummy visualization because you would have to view the hyperbola at the plane perpen
	final ConesMath conesEllipse = new ConesMath(0.3F,0.4F,-30);

	ConesMath cones = conesEllipse;
	PointsRenderer renderer = new PointsRenderer(cones.tracker);
	int z = 0;
	@Override
	public void draw() {
		if(pause) return;
		translate(500, 500);
		
//		main.clear();
		background(0x00FFFFFF); 
		cones.setZ(z++);
		cones.planeXCone();
//		cones.tracker.draw(-1);
		renderer.draw(-1);

	}
	boolean pause = false;
	@Override
	public void keyPressed() {
		if(keyCode == 32) {
			pause = !pause; // pause unpause
		}
	}
}
