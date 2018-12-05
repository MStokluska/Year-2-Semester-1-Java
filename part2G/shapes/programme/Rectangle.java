package programme;

public class Rectangle {
	private int lenght;
	private int height;

	public Rectangle(int length, int height) {
		this.lenght = length;
		this.height = height;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLenght() {
		return this.lenght;
	}

	public int getHeight() {
		return this.height;
	}

	public int calculateArea() {
		return this.lenght * this.height;
	}

	public int calculatePerimeter() {
		return this.lenght * 2 + this.height * 2;
	}
	public boolean areYouEqualTo(Rectangle rIn) {
		return this.lenght == rIn.lenght && this.height == rIn.height;
	}

}
