package main;
import math.ConesMath;
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
	
	ConesMath cones = new ConesMath(0.4F,0.4F,-30);
	int z = 0;
	@Override
	public void draw() {
		if(pause) return;
		translate(500, 500);
		
//		main.clear();
		background(0x00FFFFFF); 
		cones.setZ(z++);
		cones.planeXCone();
	}
	boolean pause = false;
	@Override
	public void keyPressed() {
		if(keyCode == 32) {
			pause = !pause; // pause unpause
		}
	}
}
