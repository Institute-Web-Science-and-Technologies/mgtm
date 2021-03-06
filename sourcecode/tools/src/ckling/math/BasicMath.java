package ckling.math;

import java.math.BigDecimal;

public class BasicMath {

	public static double sum(double[] a) {

		double result = 0;
		for (int i = 0;i < a.length; i++) {

			result += a[i];

		}
		return(result);

	}
	

	public static int sum(int[] a) {

		int result = 0;
		for (int i = 0;i < a.length; i++) {

			result += a[i];

		}
		return(result);


	}

	
	public static long factorial (int a) {
		
		long result = 1;
		
		for (int i = 1; i < a; i++) {
			result *= i;			
		}
		
		return result;
	}



	public static double mean(double[] a) {

		double result = 0;
		int count = 0;
		for (int i = 0;i < a.length; i++) {
			if (!Double.isInfinite(a[i])) {
				result += a[i];
				count++;
			}
		}
		return(result/count);

	}
	
	public static double max(double[] a) {

		double result = -Double.MAX_VALUE;
		for (int i = 0;i < a.length; i++) {

			if (!Double.isInfinite(a[i]))
				result = Math.max(result,a[i]);

		}
		return(result);

	}
	
	public static BigDecimal sin(BigDecimal x) {
		return sin(x,10);
	}
	
	public static BigDecimal cos(BigDecimal x) {
		return cos(x,10);
	}
	
	public static BigDecimal cos(BigDecimal x, int limit) {
		
		BigDecimal result = new BigDecimal(0);
		for (int i=0; i < limit; i+=2) {
			
			if (i%4==0) {			
				result = result.subtract(x.pow(i).divide(new BigDecimal(BasicMath.factorial(i)),BigDecimal.ROUND_HALF_EVEN));
			}
			else {
				result = result.add(x.pow(i).divide(new BigDecimal(BasicMath.factorial(i)),BigDecimal.ROUND_HALF_EVEN));
			}
			
		}
		
		return result;
		
	}
		
	public static BigDecimal sin(BigDecimal x, int limit) {
		
		BigDecimal result = new BigDecimal(0);
		for (int i=1; i < limit+1; i+=2) {
			
			if ((i-1)%4==0) {			
				result = result.subtract(x.pow(i).divide(new BigDecimal(BasicMath.factorial(i)),BigDecimal.ROUND_HALF_EVEN));
			}
			else {
				result = result.add(x.pow(i).divide(new BigDecimal(BasicMath.factorial(i)),BigDecimal.ROUND_HALF_EVEN));
			}
			
		}
		
		return result;
		
	}


	public static double entropy (double[] absCount) {

		double entropy = 0;

		double sum = sum(absCount);
		if (sum == 0) return 0;

		double[] p = new double[absCount.length];

		for (int i = 0;i < absCount.length; i++) {
			p[i] = absCount[i]/sum;
		}




		for (int i=0;i<absCount.length;i++) {
			System.out.println(p[i]);
			if (p[i] > 0)
				entropy += p[i] * Math.log(p[i]);
		}
		entropy /= Math.log(2);
		entropy = -entropy;

		return entropy;

	}

	public static double deg2rad(double x){
		return x*(Math.PI/180.);
	}
	
	public static double rad2deg(double x){
		return x/(Math.PI/180.);
	}
	
	public static BigDecimal DegtoRad(BigDecimal x){
		return x.multiply(new BigDecimal(Math.PI)).divide(new BigDecimal(180),BigDecimal.ROUND_HALF_EVEN);
	}
	
	public static BigDecimal RadtoDeg(BigDecimal x){
		return x.divide(new BigDecimal(Math.PI),BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(180));
	}

	public static double RadtoDeg(double x){
		return x*180/Math.PI;
	}
	
	public static String convertNumber (int number, int system, int length) {
		
		String result = Integer.toString(number,system);
		
		int diffLength = length-result.length();
		
		for (int i = 0; i < diffLength;i++) {
			result = "0"+result;
		}
		
		return result;
		
	}


}
