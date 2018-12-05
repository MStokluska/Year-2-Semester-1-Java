package programme;

public class Circle {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return this.radius;
	}

	public double calculateArea() {
		double pi = 3.14159;
		return pi * this.radius * this.radius;
	}

	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}

	public boolean areYouEqualTo(Circle rIn) {
		return this.radius == rIn.radius;
	}

}
