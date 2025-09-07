import java.io.File;
import java.io.IOException;

public class PerformanceComparator {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void compare(String originalFile, String obfuscatedFile) {
        try {
            // Check if files exist
            File origFile = new File(originalFile);
            File obfFile = new File(obfuscatedFile);

            if (!origFile.exists()) {
                System.out.println(ANSI_RED + "Original file does not exist: " + originalFile + ANSI_RESET);
                return;
            }

            if (!obfFile.exists()) {
                System.out.println(ANSI_RED + "Changed file does not exist: " + obfuscatedFile + ANSI_RESET);
                return;
            }

            long originalSize = origFile.length();
            long obfuscatedSize = obfFile.length();

            System.out.println(ANSI_PURPLE + "File sizes:" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "Original size: " + originalSize + " bytes" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "Changed size: " + obfuscatedSize + " bytes" + ANSI_RESET);

            // Compile and run original file
            System.out.println(ANSI_BLUE + "\nOriginal program output:" + ANSI_RESET);
            long originalTime = compileRun(originalFile, "original");

            // Compile and run obfuscated file
            System.out.println(ANSI_BLUE + "\nChanged program output:" + ANSI_RESET);
            long obfuscatedTime = compileRun(obfuscatedFile, "obfuscated");

            System.out.println(ANSI_YELLOW + "\nExecution time:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Original time: " + originalTime + " milliseconds" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "Changed time: " + obfuscatedTime + " milliseconds" + ANSI_RESET);

            // Calculate performance difference
            long timeDifference = Math.abs(originalTime - obfuscatedTime);
            double percentageDifference = (double) timeDifference / Math.max(originalTime, obfuscatedTime) * 100;

            System.out.println(ANSI_YELLOW + "Time difference: " + timeDifference + " milliseconds (" +
                    String.format("%.2f", percentageDifference) + "%)" + ANSI_RESET);

        } catch (Exception e) {
            System.out.println(ANSI_RED + "Error during comparison: " + e.getMessage() + ANSI_RESET);
            e.printStackTrace();
        }
    }

    private static long compileRun(String sourceFile, String outputName) throws IOException, InterruptedException {
        // Detect operating system
        boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
        String executableName = isWindows ? outputName + ".exe" : outputName;

        // Compile with gcc
        ProcessBuilder compileBuilder = new ProcessBuilder("gcc", "-o", executableName, sourceFile);
        compileBuilder.redirectErrorStream(true);
        Process compileProcess = compileBuilder.start();
        int compileExitCode = compileProcess.waitFor();

        if (compileExitCode != 0) {
            throw new IOException("Error compiling file " + sourceFile);
        }

        // Run compiled file
        long startTime = System.currentTimeMillis();

        ProcessBuilder runBuilder;
        if (isWindows) {
            runBuilder = new ProcessBuilder(executableName);
        } else {
            runBuilder = new ProcessBuilder("./" + executableName);
        }

        runBuilder.redirectErrorStream(true);
        Process runProcess = runBuilder.start();

        // Read program output
        java.util.Scanner scanner = new java.util.Scanner(runProcess.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();

        int runExitCode = runProcess.waitFor();
        long endTime = System.currentTimeMillis();

        if (runExitCode != 0) {
            throw new IOException("Error running program " + executableName);
        }

        // Delete executable file
        new File(executableName).delete();

        return endTime - startTime;
    }
}