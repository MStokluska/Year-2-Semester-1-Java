package programme;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CircleTest {
	Circle c1 = new Circle(2);
	Circle c2 = new Circle(2);
	Circle c3 = new Circle(4);
	Circle c4 = new Circle(3);

	@Test
	public void testArea1() {
		assertEquals(12.57, c1.calculateArea(), 0.05);
	}

	@Test
	public void testArea2() {
		assertNotEquals(13.57, c1.calculateArea(), 0.05);
	}

	@Test
	public void testPerimeter1() {
		assertEquals(12.57, c1.calculatePerimeter(), 0.05);
	}

	@Test
	public void testPerimeter2() {
		assertNotEquals(13.57, c1.calculatePerimeter(), 0.05);
	}

	@Test
	public void testEquals1() {
		assertTrue(c1.areYouEqualTo(c1));
	}

	@Test
	public void testEquals2() {
		assertFalse(c1.areYouEqualTo(c3));
	}

}
