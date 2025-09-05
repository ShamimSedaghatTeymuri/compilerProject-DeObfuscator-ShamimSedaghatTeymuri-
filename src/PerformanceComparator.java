import java.io.File;
import java.io.IOException;

public class PerformanceComparator {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    public static void compare(String originalFile, String obfuscatedFile) {
        try {
            long originalSize = new File(originalFile).length();
            long obfuscatedSize = new File(obfuscatedFile).length();
            System.out.println(ANSI_PURPLE + "Size of files :" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "Original Size : " + originalSize + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "Obfuscated Size : " + obfuscatedSize + ANSI_RESET);

            long originalTime = compileRun(originalFile, "original.exe", true);
            long obfuscatedTime = compileRun(obfuscatedFile, "obfuscated.exe", false);

            System.out.println(ANSI_YELLOW + "Runtime" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Original Time : " + originalTime + "ms" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Obfuscated Time : " + obfuscatedTime + "ms" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println("Error in comparing :" + e.getMessage());
        }
    }

    private static long compileRun(String source, String exeName, Boolean isOriginal) throws IOException, InterruptedException {
        Process compile = new ProcessBuilder("gcc", "-mconsole", source, "-o", exeName).inheritIO().start();
        compile.waitFor();
        long start = System.nanoTime();
        System.out.print(ANSI_BLUE + "output of " + (isOriginal ? "Original : " : "Obfuscated : ") + ANSI_RESET);
        Process run = new ProcessBuilder("./" + exeName).inheritIO().start();
        run.waitFor();
        long end = System.nanoTime();
        return (end - start) / 1_000_000;
    }
}
