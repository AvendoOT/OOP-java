package hr.fer.oop.lab3;

class CharLineParser implements LineParser {
    @Override
    public int[] parse(String arg) {
        try {
            if (arg == "") return new int[0];
            int[] get = new int[100];
            int i = 0;
            char[] chars = new char[100];
            chars = arg.toCharArray();
            for (char str : chars) {
                get[i++] = (int) str;
            }
            int[] result = new int[i];
            for (int j = 0; j < i; j++) {
                result[j] = get[j];
            }
            return result;
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
