package PACKAGES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExeConnection {

    //String output = this.executeCommand("scp " + logFullPath + " " + NARFDirs.motherUser + "@" + NARFDirs.motherIP + ":" + NARFDirs.motherLogs);

    public static boolean sendFiles(String strategy) {

        return true;
    }

    public static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command, null, null);
            p.waitFor();
            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (IOException | InterruptedException e) {
        }
        return output.toString();
    }

    public static void main(String[] args) {
        executeCommand("scp Contructor.class.violet.html jota@192.168.1.107:~");
    }
}
