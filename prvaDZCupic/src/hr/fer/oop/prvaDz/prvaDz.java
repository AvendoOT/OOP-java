package hr.fer.oop.prvaDz;

public class prvaDz {
	public static void main (String[] args) {
		Complex c1 = new Complex(2,1.5);
Complex c2 = new Complex(0,-1.5);
Complex c3 = c1.subtract(c2);
Complex c5 = c1;
System.out.println(c1); // ispisuje 2.0+1.5i
System.out.println(c2); // ispisuje 0.0-1.5i
System.out.println(c3); // ispisuje 2.0+0i
System.out.println(c5); // ispisuje 2.0+1.5i
Complex c4 = c1.add(Complex.I);
System.out.println(c4); // ispisuje 2.0+2.5i
Complex najmanji = Complex.smallest(c5,c2,c4);
System.out.println(najmanji); // ispisuje 0.0-1.5i
System.out.println(c2==najmanji); // ispisuje true
Complex prosjek = Complex.average(c1,c2);
System.out.println(prosjek); // ispisuje 1.0+0.0i
Complex[] brojevi = new Complex[] {c2,c4};
Complex najmanjiOpet = Complex.smallest(c5,brojevi);
System.out.println(najmanjiOpet); // ispisuje 0.0-1.5i
		
	}

}