package com.codechallenge.api;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

@RunWith(JUnit4ClassRunner.class)
public class RestrictedZipcodeDelegateTest {

	
	@Test
	public void testValidPrepareValid1() {
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
	public void testValidPrepareValid2() {
		RestrictedZipcodeLoader expected = new RestrictedZipcodeLoader();
		expected.push(94600,94699);
		expected.push(94200,94399);
		expected.push(94133,94133);
		
		
		RestrictedZipcodeLoader loader = new RestrictedZipcodeLoader();
		loader.push(94133,94133);
		loader.push(94200,94299);
		loader.push(94600,94699);
		
		RestrictedZipcodeDelegate rzd = new RestrictedZipcodeDelegate(loader.getHead());
		rzd.prepare();
		assertEquals("Matched",expected.getHead().toString(), rzd.getZipcdDetails().toString());
		
	}
	
	
	@Test
	public void testValidPrepareWithoutOverlap() {
		RestrictedZipcodeLoader expected = new RestrictedZipcodeLoader();
		expected.push(96144,96187);
		expected.push(95788,96120);
		
		
		RestrictedZipcodeLoader loader = new RestrictedZipcodeLoader();
		loader.push(96144,96146);
		loader.push(96147,96187);
		loader.push(96119,96120);
		loader.push(95788, 96118);
		
		RestrictedZipcodeDelegate rzd = new RestrictedZipcodeDelegate(loader.getHead());
		rzd.prepare();
		assertEquals("Matched",expected.getHead().toString(), rzd.getZipcdDetails().toString());
		
	}

	
	@Test
	public void testValidPrepareInvalidOverlap() {
		RestrictedZipcodeLoader expected = new RestrictedZipcodeLoader();
		expected.push(94600,94699);
		expected.push(94200,94299);
		expected.push(94133,94133);
		
		RestrictedZipcodeLoader loader = new RestrictedZipcodeLoader();
		loader.push(94133,94133);
		loader.push(94200,94299);
		loader.push(94600,94699);
		
		
		RestrictedZipcodeDelegate rzd = new RestrictedZipcodeDelegate(loader.getHead());
		rzd.prepare();
		assertEquals("No change Matched",expected.getHead().toString(), rzd.getZipcdDetails().toString());
		
	}
	

}
