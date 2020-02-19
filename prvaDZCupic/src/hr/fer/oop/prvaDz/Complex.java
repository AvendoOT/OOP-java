package hr.fer.oop.prvaDz;
import java.lang.Math;

public class Complex { 
	public final double realNum;
	public final double imaginaryNum;
	public static final Complex ZERO = new Complex(0,0);
	public static final Complex ONE = new Complex(1,0);
	public static final Complex I = new Complex(0,1);
	
	public Complex() {
		realNum = 0;
		imaginaryNum = 0;
	}
	public Complex(double realNum, double imaginaryNum) {
			this.realNum = realNum;
			this.imaginaryNum = imaginaryNum;
	}
	
	//@Override
	public String toString() {
		if (imaginaryNum < 0) {
			return String.format(realNum + " - i" + Math.abs(imaginaryNum));
		}
		else return String.format(realNum + " + i" + imaginaryNum);
	}
	
	public Complex add (Complex secondOperand) {
		return new Complex(this.realNum + secondOperand.realNum, 
						this.imaginaryNum + secondOperand.imaginaryNum);
	}
	
	public Complex subtract (Complex secondOperand) {
		return new Complex(this.realNum - secondOperand.realNum, 
						this.imaginaryNum - secondOperand.imaginaryNum);
	}
	
	public Complex multiplyComplex (Complex secondOperand) {
		double realNumMultiply = this.realNum * secondOperand.realNum -
					this.imaginaryNum * secondOperand.imaginaryNum;
		double imaginaryNumMultiply = this.realNum * secondOperand.imaginaryNum +
					this.imaginaryNum * secondOperand.realNum;
		return new Complex(realNumMultiply, imaginaryNumMultiply);
	}
	
	public Complex divideComplex (Complex secondOperand) {
		Complex numerator = multiplyComplex(new Complex(secondOperand.realNum, secondOperand.imaginaryNum*-1));
		double denominator = Math.pow(secondOperand.realNum, 2) + 
							Math.pow(secondOperand.imaginaryNum, 2);
		return new Complex(numerator.realNum/denominator, numerator.imaginaryNum/denominator);
	}
	
	public static double calculateComplexModule (Complex complexNum) {
			return Math.sqrt(Math.pow(complexNum.realNum,2) + Math.pow(complexNum.imaginaryNum,2));
	}
	
	public static Complex smallest (Complex cp, Complex ... complexNums) {
			try {
				double smallestModule = calculateComplexModule(complexNums[0]);
				Complex proxyComplex = complexNums[0];
				for (int i = 1; i < complexNums.length; i++) {
						if (calculateComplexModule(complexNums[i]) < smallestModule) {
						smallestModule = calculateComplexModule(complexNums[i]);
						proxyComplex = complexNums[i];
						}
				}
				return proxyComplex;

			}
			catch (Exception e) {
				throw new IllegalArgumentException("Array can't be null or empty");
			}	
	}
	
	public static Complex average (Complex cp, Complex ... complexNums) {
		Complex suma = cp;
		for (Complex c : complexNums) {
			suma = suma.add(c);
		}
		return new Complex(suma.realNum/(complexNums.length+1), suma.imaginaryNum/(complexNums.length+1));
		
	
	}
	
	
  }