package it.comparison;

import java.io.IOException;

import static java.nio.file.FileSystems.getDefault;
import static java.nio.file.Files.readAllBytes;

public class RealParserTest {

    public static void main(String[] args) throws IOException {

        RealParser parser = new RealParser();

        String amazonHtml = new String(readAllBytes(getDefault().getPath("res.html")));

        System.out.println("price = " + parser.parse(amazonHtml));
    }

}