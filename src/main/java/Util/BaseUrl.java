package Util;

public class BaseUrl {
    String baseURL;
public String BaseUrl(String url) {
    if (url.contains("http://")) {
        baseURL = url.replaceAll("http://","");
    }
    else if (url.contains("https://")) {
        baseURL = url.replaceAll("https://","");
    }
    else if (url.contains("www")) {
        baseURL = url.replaceAll("www","");
    }
    else {
        baseURL = url;
    }
    return baseURL;
}
}
