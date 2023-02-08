package com.ijuste.estaciones_bizi_grupo3.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class UtilidadesJson {

    public static String descargarTexto(String url) throws IOException {
        URL url1 = new URL(url);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url1.openConnection();
        try{
        InputStream is = new BufferedInputStream(urlConnection.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }finally{
        urlConnection.disconnect();
    }
    }

}
