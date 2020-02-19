package hr.fer.oop.lab3;


public class Demo {
    public static void main(String ... args) {
        CsvLineParser csvParser = new CsvLineParser();
        print(csvParser.parse("15,11"));
        CharLineParser charParser = new CharLineParser();
        print(charParser.parse("OOP"));
        SpaceLineParser spaceParser = new SpaceLineParser();
        print(spaceParser.parse("465 79 324"));

    }

    private static void print(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i+1 != array.length)
                System.out.print(",");
        }
        System.out.println("]");
    }


}
