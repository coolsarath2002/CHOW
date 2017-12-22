package com.codechallenge.api;

import com.codechallenge.api.facts.ZipcodeDetails;

public class RestrictedZipcodeLoader {
	
	private ZipcodeDetails head = null;
	
	public RestrictedZipcodeLoader() {
		
	}
	
	public void push(int lowerLimit,int upperLimit) {
		ZipcodeDetails zipCdDtls = new ZipcodeDetails(lowerLimit,upperLimit);
		zipCdDtls.next = head;
		head = zipCdDtls;
	}

	public ZipcodeDetails getHead() {
		return head;
	}

	public void setHead(ZipcodeDetails head) {
		this.head = head;
	}

}
