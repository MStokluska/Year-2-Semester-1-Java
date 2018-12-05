package programme;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
	Rectangle r1 = new Rectangle(2, 3);
	Rectangle r2 = new Rectangle(2, 4);
	Rectangle r3 = new Rectangle(4, 3);

	@Test
	public void testArea1() {
		assertEquals(6, r1.calculateArea(), 0);
	}

	@Test
	public void testArea2() {
		assertNotEquals(7, r1.calculateArea(), 0);
	}

	@Test
	public void testPerimeter1() {
		assertEquals(10, r1.calculatePerimeter(), 0);
	}

	@Test
	public void testPerimeter2() {
		assertNotEquals(11, r1.calculatePerimeter(), 0);
	}
	@Test
	public void testEquals1() {
		assertTrue(r1.areYouEqualTo(r1));
	}

	@Test
	public void testEquals2() {
		assertFalse(r1.areYouEqualTo(r2));
	}
	@Test
	public void testEquals3() {
		assertFalse(r1.areYouEqualTo(r3));
	}

}
