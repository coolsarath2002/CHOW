package com.codechallenge.api;

import com.codechallenge.api.facts.ZipcodeDetails;

public class RestrictedZipcodeDelegate {
	private ZipcodeDetails zipcdDetails;

	
	/**
	 * constructor with ZipcodeDetails info.
	 * @param zipcdDetails
	 */
	public RestrictedZipcodeDelegate(ZipcodeDetails zipcdDetails) {
		this.zipcdDetails=zipcdDetails;
	}
	/**
	 * Load the list of ZipcodeDetails, sort them in asc order to find the overlap zipcode
	 */
	public void  prepare(){
		//merge
		ZipcodeDetailsHelper helper = new ZipcodeDetailsHelper();
		zipcdDetails = helper.mergesort(zipcdDetails);
		//reorderRanges
		reOrderRanges(zipcdDetails);
		helper.printList(zipcdDetails);
	}
	/**
	 * Check if there is an overlap of zipcode in multiple sets.If there is a overlap of the zipcode then 
	 * group then and create a new set.
	 * @param node
	 */
	public void reOrderRanges(ZipcodeDetails node){
		ZipcodeDetails next = null;
		ZipcodeDetails current = node;
		
		while(current!=null && current.next!=null) {
			next = current.next;
			if(current.upperLimit == next.lowerLimit 
					|| current.upperLimit+1 == next.lowerLimit || current.upperLimit > next.lowerLimit) {
				current.upperLimit = next.upperLimit;
				current.next=next.next;
				reOrderRanges(current);
			}else {
				reOrderRanges(current.next);
			}
			current=null;
		}
	}
	
	public ZipcodeDetails getZipcdDetails() {
		return zipcdDetails;
	}
	public void setZipcdDetails(ZipcodeDetails zipcdDetails) {
		this.zipcdDetails = zipcdDetails;
	}
}
