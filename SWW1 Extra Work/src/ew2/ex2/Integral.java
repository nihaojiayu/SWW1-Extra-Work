package ew2.ex2;

import java.util.function.Function;

public class Integral {
	
	public static double integral(Function<Double, Double> f, double a, double b, int n) {
		
		if(a <= b) {
			double sum = 0;
			double alpha = (b - a) / n;
			
			for(int i = 0; i < n; i++) {
				sum += f.apply(a + i * alpha);
			}
			
			return alpha * sum;
			
		} else {
			throw new IllegalArgumentException("a is bigger than b endpoint! Cannot calculate!");
		}
	}
				
	
	
	public static void main(String[] args){
        Function<Double, Double> square = x -> {return x * x;};
        Function<Double, Double> sin = x    -> {return Math.sin(x);};
        Function<Double, Double> exp = x    -> {return Math.exp(x);};
        Function<Double, Double> poly = x   -> {return x*x*x + x*x + x +1;};

        double a = 0;
        double b = 1;
        int    n = 1000;
        
        System.out.println("area square: " + integral(square, a, b, n));
        System.out.println("area sin:    " + integral(sin,    a, b, n));
        System.out.println("area exp:    " + integral(exp,    a, b, n));
        System.out.println("area poly:   " + integral(poly,   a, b, n));
        System.out.println("area poly:   " + integral(poly,   b, a, n));
    }
	
}
