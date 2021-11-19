package com.diegopinheiro.p2_00_listaVetores;

public class List01 {
	public int [] buildVectorRepeat(int n, int i) {
		int [] arr= new int[n];
		for(int cont = 0; cont<n; cont++) {
			arr[cont]=i;
		}
		return arr;
	}
	public int [] buildVectorSequence(int n,int i) {
		int [] arr= new int[n];
		for(int cont = 0; cont<n; cont++) {
			arr[cont]=i++;
		}
		return arr;
	}
	public int dotProduct(int [] a,int [] b) throws Exception {
		int c = 0;
		if(a.length!=b.length) {
			throw new Exception("Different sizes");
		} else {
			for (int count = 0; count < b.length; count++) {
				c += a[count]*b[count];
			}
		}
		return c;
		
	}
	public boolean isPalindrome(int []v) {
		int n =v.length;
		
		boolean y = false;
		for (int i = 0; i<v.length; i++ ) {
			n--;
			if(v[i]==v[n]) {
				//x +=0;
				y = true;
			}else {
				//x+=1;
				y = false;
				break;
			}
		}
		if(y==false) {
			return false;
		}else {
			return true;
		}
		
	}
	public double calculateCableBridge(float bridgeLength, int numSteelCables) {
		float halfBridgeLength = bridgeLength / 2;
		double maxCableHeight = 1 / 20 * halfBridgeLength;
		double cableLenght = Math.sqrt(Math.pow(halfBridgeLength, 2) + Math.pow(maxCableHeight, 2));
		double sum = 0;
		double [] arr = calculateCablesSupportRod(numSteelCables, maxCableHeight, halfBridgeLength);
		if(numSteelCables>1) {
			for(int i = 0; i<arr.length; i++) {
				sum += arr[i];
			}
			cableLenght = sum;
		}
	
		return cableLenght*4;
		
	}
	public double[] calculateCablesSupportRod(int numSteelCables,double maxCableHeight, float halfBridgeLength) {
		double [] arr= new double[numSteelCables];
		double [] arrayBridgeFraction= new double[numSteelCables];
		double [] arrayHeightFraction= new double[numSteelCables];
		
		int count = 1;
		
		for(int i = 0; i<numSteelCables; i++) {
			arrayBridgeFraction[i]=(halfBridgeLength/numSteelCables)*count;
			arrayHeightFraction[i]=(maxCableHeight/numSteelCables)*count;
			arr[i]=Math.sqrt(Math.pow(arrayBridgeFraction[i], 2) + Math.pow(arrayHeightFraction[i], 2));
			
			count++;
		}
		
		return arr;
	}
	
}
