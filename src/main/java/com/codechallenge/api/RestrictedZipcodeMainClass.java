package com.codechallenge.api;

import java.util.Scanner;

import com.codechallenge.api.facts.ZipcodeDetails;


public class RestrictedZipcodeMainClass {
	
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in).useDelimiter(",");
		boolean terminate = false;
		RestrictedZipcodeLoader loader = new RestrictedZipcodeLoader();
		while(!terminate){
			String val = scan.nextLine();
			if(("done".equals(val))) {
				terminate=true;
				continue;
			}
			if(val.indexOf(",") ==-1) {
				System.out.println("Invalid Zipcode range. Please provide a upper and lower limit.");
				return;
			}else {
				String[] limits = val.split(",");
				loader.push(Integer.parseInt(limits[0]), Integer.parseInt(limits[1]));
			}
		}
		RestrictedZipcodeDelegate restrictedZipcodeDelegate = new RestrictedZipcodeDelegate(loader.getHead());
		restrictedZipcodeDelegate.prepare();
		scan.close();
	}
	
	
	

}
