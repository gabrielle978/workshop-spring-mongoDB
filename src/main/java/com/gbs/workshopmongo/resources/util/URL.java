package com.gbs.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    //estático para não precisar instanciar um obj url
    public static String decodeParam (String text){
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "[empty]";
        }
    }
}
