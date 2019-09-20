package io.ws.test;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import io.ws.model.*;
import io.ws.exception.ZipcodeException;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class ZipCodesTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/*
	 * @Test(expected = ZipcodeException.class) public void testValidateRange()
	 * throws ZipcodeException {
	 * 
	 * new ZipCodes(90, 12354); // not a 5-digit code new ZipCodes(654321, 123456);
	 * // not a 5-digit code new ZipCodes(90564, 12354); // startZip > endZip
	 * 
	 * thrown.
	 * expectMessage("Validation Failed :: [90564, 12354] is not in valid Zipcode Range!"
	 * ); thrown.
	 * expectMessage("Validation Failed :: 90 is not in valid 5-digit Zipcode Range!"
	 * ); thrown.
	 * expectMessage("Validation Failed :: 654321 is not in valid 5-digit Zipcode Range!"
	 * );
	 * 
	 * }
	 */

	@Test
	public void testConstructorBounds() throws ZipcodeException {
		ZipCodes range = new ZipCodes(90804, 95747);

		assertThat(range.getStartZip(), is(equalTo(90804)));
		assertThat(range.getEndZip(), is(equalTo(95747)));
	}

	/*
	 * @Test public void testSetBounds() throws ZipcodeException {
	 * thrown.expect(ZipcodeException.class);
	 * 
	 * ZipCodes range = new ZipCodes(0, 123456);
	 * thrown.expect(ZipcodeException.class);
	 * 
	 * thrown.
	 * expectMessage("Validation Failed :: 0 is not in valid 5-digit Zipcode Range!"
	 * ); range.setStartZip(45); range.setEndZip(145632); }
	 */

	@Test
	public void testEquals() throws ZipcodeException {
		ZipCodes range1 = new ZipCodes(90804, 95747);
		ZipCodes range2 = new ZipCodes(90815, 95677);
		ZipCodes range3 = new ZipCodes(90815, 95677);

		assertThat(range1, is(equalTo(range1)));
		assertThat(range2, is(not(equalTo(range1))));
		assertThat(range2, is(equalTo(range3)));
		assertThat(range3, is(not(equalTo(range1))));

		assertThat(range2, is(equalTo(range2)));
		assertThat(range2, is(not(equalTo(range1))));
		assertThat(range1, is(not(equalTo(range2))));
		assertThat(range3, is(not(equalTo(range1))));

	}

	@Test
	public void testHashCode() throws ZipcodeException {

		ZipCodes range1 = new ZipCodes(90804, 95747);
		ZipCodes range2 = new ZipCodes(90815, 95677);

		assertThat(range1.hashCode(), is(equalTo(range1.hashCode())));
		assertThat(range2.hashCode(), is(equalTo(range2.hashCode())));
	}

	@Test
	public void testToString() throws ZipcodeException {
		ZipCodes range1 = new ZipCodes(90804, 95747);
		ZipCodes range2 = new ZipCodes(90815, 95677);

		assertThat(range1.toString(), is(equalTo("[90804,95747]")));
		assertThat(range2.toString(), is(equalTo("[90815,95677]")));
	}
}