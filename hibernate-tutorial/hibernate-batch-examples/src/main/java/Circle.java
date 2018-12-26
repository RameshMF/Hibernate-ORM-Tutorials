public class Circle {
	private int xPos;
	private int yPos;
	private int radius;

// three overloaded constructors for Circle
	public Circle(int x, int y, int r) {
		xPos = x;
		yPos = y;
		radius = r;
	}

	public Circle(int x, int y) {
		xPos = x;
		yPos = y;
		radius = 10; // default radius
	}

	public Circle() {
		xPos = 20; // assume some default values for xPos and yPos
		yPos = 20;
		radius = 10; // default radius
	}

	public String toString() {
		return "center = (" + xPos + "," + yPos + ") and radius = " + radius;
	}

	public static void main(String[] s) {
		System.out.println(new Circle());
		System.out.println(new Circle(50, 100));
		System.out.println(new Circle(25, 50, 5));
	}
}