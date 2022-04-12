import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MyClass {


    public static void main(String[] args) {


        collectTargetThenDelete();
        System.out.println(set.size());
        for (String s : set) {
            System.out.println(s);
        }
    }

    static String pathTarget = "C:\\Users\\xxxx\\xxxxxxx";
    static String remTarget1 = "node_modules";
    static String remTarget2 = ".git";

    static Set<String> set = new HashSet<>();

    private static void collectTargetThenDelete() {

        File dirTarget = new File(pathTarget);

        if (dirTarget.isDirectory()) {
            collectTarget(dirTarget);
        }

        System.out.println("size=" + set.size());
        if (set.size() > 0) {
            for (String s : set) {
                File dir = new File(s);
                try {
                    FileUtils.deleteDirectory(dir);
                    System.out.println(dir.getAbsolutePath() + " ---> delete done!!!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private static void collectTarget(File dirTarget) {
        for (File file : dirTarget.listFiles()) {
            if (file.isDirectory()) {

                if (file.getName().equals(remTarget1)
                || file.getName().equals(remTarget2)
                ) {
                    set.add(file.getAbsolutePath());
                }else {
                    collectTarget(file);
                }
            }
        }
    }

}
