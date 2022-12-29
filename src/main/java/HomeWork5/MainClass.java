package HomeWork5;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.load("file.txt");

        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));

        appData.save("newFile.txt");
    }
}
