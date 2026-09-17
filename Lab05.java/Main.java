import java.io.*;
import java.util.Scanner;

public class Main {

    //PascalCase bolgoh punkts
    public static String toPascalCase(String line) {
        String[] words = line.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                result.append(word.substring(0, 1).toUpperCase());
                if(word.length() > 1) {
                    result.append(word.substring(1).toLowerCase());
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File ner oruulna uu: ");
        String fileName = scanner.nextLine();

        //hooson ner shalgah
        if (fileName.trim().isEmpty()) {
            System.out.println("Aldaa: File ner hooson baij bolohgvi. Programms garch baina.");
            return;
        }

        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileName));
            writer = new BufferedWriter(new FileWriter("output.txt"));

        System.out.println("Files unshij baina: " + fileName);

        String line;
         
        while ((line = reader.readLine()) != null) {
            String pascal = toPascalCase(line);
            writer.write(pascal);
            writer.newLine();
        }

        System.out.println("output.txt-d bichij duuslaa.");

    } catch (FileNotFoundException e) {
        System.out.println("Aldaa: File \"" + fileName + "\" oldsongvi."); 
    } catch (IOException e) {
        System.out.println("Aldaa: File unshih/bichih vyd asuudal garlaa.");
    } finally {
        try {
            if (reader != null) reader.close();
            if (writer != null) writer.close(); 
        } catch (IOException e) {
            System.out.println("Aldaa: file haah vyd asuudal garlaa.");
        }
    }

    scanner.close();
   }
}