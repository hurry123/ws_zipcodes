package io.ws.model;

import java.util.Objects;
import io.ws.exception.ZipcodeException;

/**
 * This is a data class which also Validates ZipRanges
 *
 */
public class ZipCodes {

	private int startZip;
	private int endZip;

	/**
	 * Constructor here would create Zipcode Range for specified bounds
	 * 
	 * @param startZip
	 *            would be lower bound of the Zipcode Range
	 * @param endZip
	 *            would be lower bound of the Zipcode Range
	 */
	public ZipCodes(int startZip, int endZip) throws ZipcodeException {

		validate(startZip, endZip);

		if (startZip <= endZip) {
			this.startZip = startZip;
			this.endZip = endZip;
		} else {
			this.startZip = endZip;
			this.endZip = startZip;
		}
	}

	/**
	 * Validates if given Zipcodes have 5-digits in it Also, makes sure ending
	 * zip is more than starting zip in a given input
	 * 
	 * @param startZip
	 *            is the starting of the zip code to be validated
	 * @param endZip
	 *            is the ending of the zip code to be validated
	 * @throws ZipcodeException
	 *             if the value to be set is not 5-digit & startZip is greater
	 *             than endZip
	 */
	public void validate(int startZip, int endZip) throws ZipcodeException {
		validate(startZip);
		validate(endZip);

		if (startZip > endZip) {
			throw new ZipcodeException(
					String.format("Validation Failed :: [%1$d,%2$d] is not in valid Zipcode Range!", startZip, endZip));
		}
	}

	/**
	 * Using Regular expression, checks given input is 5-digit otherwise, throw
	 * ZipcodeException
	 * 
	 * @param zip
	 *            is the input zip code
	 * @throws ZipcodeException
	 *             if the value to be set is not 5-digit code
	 */
	public void validate(int zip) throws ZipcodeException {
		boolean matches = Integer.toString(zip).matches("\\d{5}");
		if (!matches) {
			throw new ZipcodeException(
					String.format("Validation Failed :: %1$d is not in valid 5-digit Zipcode Range!", zip));
		}
	}

	/**
	 * Returns the startZip from the Zip code Range
	 * 
	 * @return startZip from the Zip code Range
	 */
	public int getStartZip() {
		return startZip;
	}

	/**
	 * Sets start zip code value for the Zipcode Range
	 * 
	 * @param startZip
	 *            is the start zip code value for the Zipcode Range
	 * @throws ZipcodeException
	 */
	public void setStartZip(int startZip) throws ZipcodeException {
		validate(startZip, endZip);
		this.startZip = startZip;
	}

	/**
	 * Returns the End Zip from the Zip code Range
	 * 
	 * @return endZip from the Zip code Range
	 */
	public int getEndZip() {
		return endZip;
	}

	/**
	 * Sets end zip code value for the Zipcode Range
	 * 
	 * @param endZip
	 *            is the end zip code value for the Zipcode Range
	 * @throws ZipcodeException
	 *             if the value to be set is not 5-digit & startZip is greater
	 *             than endZip
	 */
	public void setEndZip(int endZip) throws ZipcodeException {
		validate(startZip, endZip);
		this.endZip = endZip;
	}

	/*
	 * Returns String representation for the list (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return String.format("[%1$d,%2$d]", startZip, endZip);
	}

	/*
	 * Returns hash code for the given Zip code range
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.startZip, this.endZip);
	}

	/*
	 * Returns result by comparing two Objects Used to assert whether given two
	 * objects have same Zip Range.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof ZipCodes) {
			ZipCodes that = (ZipCodes) other;
			result = (this.getStartZip() == that.getStartZip() && this.getEndZip() == that.getEndZip());
		}
		return result;
	}
}