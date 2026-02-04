package com.gbs.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
    //estático para não precisar instanciar um obj url
    public static String decodeParam (String text){
        return URLDecoder.decode(text, StandardCharsets.UTF_8);
    }

    public static Date convertDate (String textData, Date defaultValue){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(textData);
        } catch (ParseException e){
            return defaultValue;
        }
    }
}
