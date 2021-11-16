package com.diegopinheiro.p2_00_listaVetores;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestList01 {

	private List01 list01;

	@Before
	public void setUp() {
		this.list01 = new List01();
	}

	@Test
	public void test01BuildVectorRepeat() {
		List01 list = this.list01;
		int n = 3;
		int i = 1;
		int[] actual = list.buildVectorRepeat(n, i);
		int[] expected = { 1, 1, 1 };
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test02BuildVectorRepeatZeroElements() {
		List01 list = this.list01;
		int n = 0;
		int i = 1;
		int[] actual = list.buildVectorRepeat(n, i);
		int[] expected = {};
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test03BuildVectorSequence() {
		List01 list = this.list01;
		int n = 3;
		int i = 1;
		int[] actual = list.buildVectorSequence(n, i);
		int[] expected = { 1, 2, 3 };
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test04BuildVectorSequenceZeroElements() {
		List01 list = this.list01;
		int n = 0;
		int i = 1;
		int[] actual = list.buildVectorSequence(n, i);
		int[] expected = {};
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void test05DotProduct() {
		List01 list = this.list01;
		int[] a = list.buildVectorRepeat(3, 1);
		int[] b = list.buildVectorSequence(3, 3);
		try {
			int actual = list.dotProduct(a, b);
			int expected = 12;
			Assert.assertEquals(expected, actual, 0.001);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test06DotProductDifferentSizes() {
		List01 list = this.list01;
		int sizeA = 3;
		int sizeB = 4;

		int[] a = list.buildVectorRepeat(sizeA, 1);
		int[] b = list.buildVectorSequence(sizeB, 1);

		try { 
			int result = list.dotProduct(a, b);
			Assert.fail("Vectors with different sizes but returned " + result);
		} catch (Exception e) {

		}
	}

	@Test
	public void test07IsPalindromeTrue() {
		List01 list = this.list01;
		int[] a = { 1, 5, 5, 1 };
		boolean result = list.isPalindrome(a);
		Assert.assertTrue(result);
	}

	@Test
	public void test08IsPalindromeFalse() {
		List01 list = this.list01;
		int[] a = { 1, 5, 4, 1 };
		boolean result = list.isPalindrome(a);
		Assert.assertTrue(!result);
	}

	@Test
	public void test09IsPalindromeUnit() {
		List01 list = this.list01;
		int[] a = { 1 };
		boolean result = list.isPalindrome(a);
		Assert.assertTrue(result);
	}

	@Test
	public void test10CalculateCableBridgeOneCableSteel() {
		List01 list = this.list01;

		final float bridgeLenght = 2;
		final int numSteelCables = 1;
		float halfBridgeLenght = bridgeLenght / 2;
		float maxCableHeight = 1 / 20 * halfBridgeLenght;
		double cableLenght = Math.sqrt(Math.pow(halfBridgeLenght, 2) + Math.pow(maxCableHeight, 2));
		double expected = 4 * cableLenght;
		double actual = list.calculateCableBridge(bridgeLenght, numSteelCables);
		Assert.assertEquals(expected, actual, .001);
	}

	@Test
	public void test11CalculateCableBridgeTwoCableSteel() {
		List01 list = this.list01;
		final float bridgeLenght = 2;
		final int numSteelCables = 2;
		float halfBridgeLenght = bridgeLenght / 2;
		float maxCableHeight = 1 / 20 * halfBridgeLenght;

		double cableLenghtMax = Math.sqrt(Math.pow(halfBridgeLenght, 2) + Math.pow(maxCableHeight, 2));
		double cableLenghtMin = Math.sqrt(Math.pow(halfBridgeLenght / 2, 2) + Math.pow(maxCableHeight / 2, 2));
		double expected = 4 * (cableLenghtMax + cableLenghtMin);

		double actual = list.calculateCableBridge(bridgeLenght, numSteelCables);
		Assert.assertEquals(expected, actual, .001);
	}
}
