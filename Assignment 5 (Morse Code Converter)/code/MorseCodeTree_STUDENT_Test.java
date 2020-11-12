import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTree_STUDENT_Test {
	
	MorseCodeTree tree = new MorseCodeTree();

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFetch() {
		assertEquals("e", tree.fetch("."));
	}

	@Test
	void testToArrayayList() {
		assertEquals("[h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o]", tree.toArrayList().toString());
	}
}
