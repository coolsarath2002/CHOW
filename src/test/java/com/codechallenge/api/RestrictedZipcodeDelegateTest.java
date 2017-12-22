package com.codechallenge.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@SuppressWarnings("deprecation")
@RunWith(JUnit4ClassRunner.class)
public class RestrictedZipcodeDelegateTest {

	
	@Test
	public void testValidPrepareValid() {
		RestrictedZipcodeLoader expected = new RestrictedZipcodeLoader();
		expected.push(94200,94399);
		expected.push(94133,94133);
		
		RestrictedZipcodeLoader loader = new RestrictedZipcodeLoader();
		loader.push(94226,94399);
		loader.push(94200,94299);
		loader.push(94133,94133);
		
		RestrictedZipcodeDelegate rzd = new RestrictedZipcodeDelegate(loader.getHead());
		rzd.prepare();
		assertEquals("Matched",expected.getHead().toString(), rzd.getZipcdDetails().toString());
		
	}
	
	
	@Test
	public void testValidPrepareWithoutOverlap() {
		RestrictedZipcodeLoader expected = new RestrictedZipcodeLoader();
		expected.push(96126,96146);
		expected.push(95788,96116);
		
		RestrictedZipcodeLoader loader = new RestrictedZipcodeLoader();
		loader.push(96144,96146);
		loader.push(96126,96146);
		loader.push(96126,96127);
		loader.push(96113,96116);
		loader.push(95788, 96120);
		
		RestrictedZipcodeDelegate rzd = new RestrictedZipcodeDelegate(loader.getHead());
		rzd.prepare();
		assertEquals("Matched",expected.getHead().toString(), rzd.getZipcdDetails().toString());
		
	}

	

}
