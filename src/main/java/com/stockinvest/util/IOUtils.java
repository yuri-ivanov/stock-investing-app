package com.stockinvest.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

    public static List<String> getUrlData(URL url) throws IOException {
        List<String> data = new ArrayList<>(1000);
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()) )){
            String line;
            while( (line = reader.readLine())!=null ){
                data.add(line);
            }
        }
        return data;
    }
}
