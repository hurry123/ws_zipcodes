package io.ws.service;

import io.ws.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.ws.exception.*;

/**
 * This class holds helper methods that work on Data Object called ZipRange. It
 * contains a static method which calculates overlapping zipcodes.
 */
public class ZipCodeService {

	public static List<ZipCodes> resultList = new ArrayList<ZipCodes>();

	public static void main(String[] args) throws NumberFormatException, ZipcodeException {

		List<ZipCodes> inputList = new ArrayList<ZipCodes>();

		// get input from args
		for (String s : args) {
			String[] str = s.split(",");
			ZipCodes obj = new ZipCodes(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			inputList.add(obj);
		}

		// core method to calculate result
		resultList = calculate(inputList);

		// Print Result
		printResult();
	}

	/**
	 * Input List is list of Objects, goal of this method is to
	 * produce minimum number of ranges required to represent the same ranges
	 * from the input. Input Ranges may vary, can or cannot overlap but output
	 * has to be merged to minimum count of ranges
	 * 
	 * @param ranges
	 * @return a list of merged ranges for given Zip Code Objects
	 * @throws ZipcodeException
	 */
	public static List<ZipCodes> calculate(List<ZipCodes> ranges) throws ZipcodeException {

		List<ZipCodes> result = new ArrayList<ZipCodes>();

		if (ranges == null || ranges.size() == 0)
			return result;

		// takes O(n logn)
		Collections.sort(ranges, new Comparator<ZipCodes>() {
			public int compare(ZipCodes r1, ZipCodes r2) {

				if (r1.getStartZip() != r2.getStartZip())
					return r1.getStartZip() - r2.getStartZip();
				else
					return r1.getEndZip() - r2.getEndZip();
			}
		});

		// Once sorted merging would take O(n)
		ZipCodes prev = ranges.get(0);

		for (int i = 0; i < ranges.size(); i++) {
			ZipCodes curr = ranges.get(i);
			if (curr.getStartZip() > prev.getEndZip()) {
				result.add(prev);
				prev = curr;
			} else {
				ZipCodes merged = new ZipCodes(prev.getStartZip(), Math.max(prev.getEndZip(), curr.getEndZip()));
				prev = merged;
			}
		}
		result.add(prev);

		// total complexity would be, T(n) = O (n logn)
		return result;
	}

	public static void printResult() {

		if (resultList.size() > 0) {
			for (ZipCodes result : resultList) {
				System.out.println(result.toString());
			}
		} else {
			new ZipcodeException(String.format("No Result to display, please check Input or Input Format"));
		}
	}

}