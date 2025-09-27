package Vanilla.claude;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task110 {
    public static boolean isValidURL(String url) {
        String regex = "^(https?://)?([\\\\w-]+\\\\.)+[\\\\w-]+(/[\\\\w- ./?%&=]*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
    
    public static void main(String[] args) {
        String[] urls = {
            "https://www.example.com",
            "http://subdomain.example.co.uk/path",
            "invalid url",
            "ftp://invalid.com",
            "https://valid-url.com/path?param=value"
        };
        
        for(String url : urls) {
            System.out.println("URL: " + url + " is " + (isValidURL(url) ? "valid" : "invalid"));
        }
    }
}
