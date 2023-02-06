package com.arrays;

import javax.sound.midi.Soundbank;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateDomainUrl_domain {
    public static void main(String[] args) {
        //String urlDomain = "8.8.8";
        // String urlDomain = "8.1.2";
        //String urlDomain = "10.16/24";
        //String urlDomain = "25.2";
        //String urlDomain = "1.0";
        //String urlDomain = "1.";
        // String urlDomain = ".5";
        String urlDomain = ".abc123";

        urlDomain = urlDomain.replaceAll(Pattern.quote("."), "");
        urlDomain = urlDomain.replaceAll(Pattern.quote("/"), "");

        // Regex to check string
        // contains only digits
        String regex = "[0-9]+";

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(urlDomain);

        System.out.println(m.matches());
    }
}
