package programme;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TriangleTest {
	Triangle t1 = new Triangle(2, 3);
	Triangle t2 = new Triangle(2, 4);
	Triangle t3 = new Triangle(4, 3);

	@Test
	public void testArea1() {
		assertEquals(3, t1.calculateArea(), 0);
	}

	@Test
	public void testArea2() {
		assertNotEquals(3.1, t1.calculateArea(), 0);
	}

	@Test
	public void testPerimeter1() {
		assertEquals(8, t1.calculatePerimeter(), 0);
	}

	@Test
	public void testPerimeter2() {
		assertNotEquals(8.1, t1.calculatePerimeter(), 0);
	}
	@Test
	public void testEquals1() {
		assertTrue(t1.areYouEqualTo(t1));
	}

	@Test
	public void testEquals2() {
		assertFalse(t1.areYouEqualTo(t2));
	}
	@Test
	public void testEquals3() {
		assertFalse(t1.areYouEqualTo(t3));
	}

}
