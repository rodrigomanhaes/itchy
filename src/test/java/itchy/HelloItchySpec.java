package itchy;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HelloItchySpec {
	@Test
	public void itSums() {
		HelloItchy hi = new HelloItchy();
		assertThat(hi.sum(1, 2), is(3));
	}
}
 