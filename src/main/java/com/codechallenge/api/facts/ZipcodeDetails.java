package com.codechallenge.api.facts;
/**
 * The facts to maintain the range of restricted Zipcode details
 * @author sarathbabu
 *
 */
public class ZipcodeDetails {
	/* Upper Zip limit */
	public int upperLimit;
	/* Upper Zip limit */
	public int lowerLimit;
	/* pointer for the next node */
	public ZipcodeDetails next;
	
	public ZipcodeDetails(int lowerLimit,int upperLimit) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	
	public String toString(){
		StringBuffer strbuffer = new StringBuffer();
		ZipcodeDetails temp = this;
		while (temp != null) {
			strbuffer.append("{");
			strbuffer.append(this.lowerLimit + "," + this.upperLimit);
			strbuffer.append("}");
			temp = temp.next;
		}
		
		return strbuffer.toString();
	}

}
