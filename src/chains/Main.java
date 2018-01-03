package chains;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String> lines = new ArrayList<>();
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) {

        try {
            String fileName = "text.txt";
            FileReader fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            String nextLine;

            while ((nextLine = bufferedReader.readLine()) != null ) {
                lines.add(nextLine);

            }

            if (lines.size() %2 == 0) {

                for (int i = 0; i < lines.size() - 1; i++) {
                    String s1 = lines.get(i);
                    String s2 = lines.get(i + 1);
                    System.out.println("For " + s1 + " and " + s2 + " change possible: " + changePossible(s1, s2));
                    i++;
                }
            } else {
                System.out.println("Number of lines is not even, comparison is not possible.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    private static boolean changePossible(String s1, String s2) {
        boolean result = true;
        for (int i = 0; i < lines.size() - 1; i++) {

            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);

            if (s1.length() == s2.length() && Arrays.equals(chars1, chars2)) {
                result = true;
            } else {
                result = false;
            }

        }

        return result;

    }
}
