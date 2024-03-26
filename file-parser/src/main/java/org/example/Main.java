package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("no filename specified");
            System.exit(-1);
        }

        if(!Files.exists(Path.of(args[0]))){
            System.out.println(String.format("file: %s does not exist", args[0]));
            System.exit(-1);
        }

        Pattern pattern = Pattern.compile("^(.*?)\\s+(.*?)\\s+(.*?)\\s+(.*?)\\s+(.*?)\\s+(.*?)\\s+(.*?)\\s+(.*)\\s+(?<filename>.*)$", Pattern.MULTILINE);
        var s = Files.readString(Path.of(args[0]));
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()) {
            System.out.println(matcher.group("filename"));
        }
    }
}