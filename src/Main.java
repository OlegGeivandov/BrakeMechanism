import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

public static BrakeMechanism bm;


    public static void main(String[] args) {
        String fileName = "1.txt";
        readFromFile(fileName);
        bm.calculateLegalBrakeLength();
        System.out.println(bm.minimumLegalBrakeLength);
    }


    static void readFromFile (String fileName) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            bm = new BrakeMechanism(getArrayListFromString(scanner.nextLine()), getArrayListFromString(scanner.nextLine()));
            scanner.close();
            System.out.println(bm.firstBrakePad);
            System.out.println(bm.secondBrakePad);
        }
        catch (FileNotFoundException e) {
            System.out.println("упс, файл "+fileName+" не найден");
        }
        catch (InputMismatchException e){
            System.out.println("в файле не совсем число записано");
        }
    }


    public static ArrayList<Integer> getArrayListFromString(String str) {
        ArrayList<Integer> list = new ArrayList<>();
        char[] charArray = str.toCharArray();
        for (Character ch : charArray) {
            list.add(Integer.parseInt(String.valueOf(ch)));
        }
        return list;
    }
}