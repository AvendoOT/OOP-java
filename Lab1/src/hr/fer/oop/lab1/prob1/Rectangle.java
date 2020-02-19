package hr.fer.oop.lab1.prob1;

public class Rectangle {
	
	public static void main(String[] args) {
		int argsLength = (int)args.length;
		double width;
		double height;
		
		
		if (argsLength != 0 && argsLength == 2) {
				width = args[0];
				height = args[1];
				calculation(width, height);
			} 
		else if (argsLength > 0 && argsLength != 2) {
				System.out.println
				("Invalid number of arguments was provided.%n");
				System.exit(0);
			}				
		
	}
	
	private void printResult(double width, double height) {
		System.out.println("You have specified a rectangle of width %.1f and height %.1f. It's area is %.1f and it's perimeter %.1f",
								width, height, areaCalculation(width, height), perimeterCalculation(width, calculation) );
	}
	
	private double areaCalculation(double width, double height) {
		return width*height;
	}
	
	private double perimeterCalculation(double width, double height) {
		return (2*width + 2*height);
	}
	
	

}