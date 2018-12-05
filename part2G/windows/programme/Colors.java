package programme;
//this is a class just to keep color values for RGB, unfortunately as static as I do not know how to transfer values in setup
//class to another class if the values are already within method in class of origin.
public class Colors {
private static int red;
private static int green;
private static int blue;
public Colors() {
}
public static int getRed() {
	return red;
}
public static int getGreen() {
	return green;}
public static int getBlue() {
	return blue;}
public static void setRed(int rIn) {
	red = rIn;
}
public static void setGreen(int gIn) {
	green = gIn;
}
public static void setBlue(int bIn) {
	blue = bIn;
}
}
