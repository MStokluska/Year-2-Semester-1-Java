
package programme;

public class Triangle {
	private double base;
	private double height;

	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public void setheight(int height) {
		this.height = height;
	}

	public double getBase() {
		return this.base;
	}

	public double getHeight() {
		return this.height;
	}

	public double calculatePerimeter() {
		return this.base + this.height * 2;
	}

	public double calculateArea() {
		return ((base * height) / 2);
	}

	public boolean areYouEqualTo(Triangle rIn) {
		return this.base == rIn.base && this.height == rIn.height;
	}

}
