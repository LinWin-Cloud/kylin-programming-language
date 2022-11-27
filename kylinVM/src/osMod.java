import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class osMod {
    public static void outLineLn(String out) throws IOException {
        PrintStream printStream = new PrintStream(System.out);
        printStream.println(out);
        printStream.flush();
    }
}
