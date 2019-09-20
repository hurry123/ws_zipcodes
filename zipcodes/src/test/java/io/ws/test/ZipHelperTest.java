package io.ws.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import io.ws.exception.ZipcodeException;
import io.ws.model.ZipCodes;
import io.ws.service.ZipCodeService;

public class ZipHelperTest {

	/**
	 * Asserts input with expected output(hardcoded)
	 * @throws ZipcodeException
	 */
	@Test
	public void testWithInput1() throws ZipcodeException {
			
		List<ZipCodes> input = new ArrayList<ZipCodes>();	
		List<ZipCodes> output = new ArrayList<ZipCodes>();
		
		input.add(new ZipCodes(94133, 94133));
		input.add(new ZipCodes(94200, 94299));
		input.add(new ZipCodes(94600, 94699));
		
		output.addAll(input);
		
		assertThat(ZipCodeService.calculate(input), is(equalTo(output)));
	}

	/**
	 * Asserts input with expected output(hardcoded)
	 * @throws ZipcodeException
	 */
	@Test
	public void testWithInput2() throws ZipcodeException {
		List<ZipCodes> input  = new ArrayList<ZipCodes>();	
		List<ZipCodes> output = new ArrayList<ZipCodes>();
		
		input.add(new ZipCodes(94133, 94133));
		input.add(new ZipCodes(94200, 94299));
		input.add(new ZipCodes(94226, 94399));
		
		output.add(new ZipCodes(94133, 94133));
		output.add(new ZipCodes(94200, 94399));
		
		assertThat(ZipCodeService.calculate(input), is(equalTo(output)));
	}
}