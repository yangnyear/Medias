package com.swpuiot.medias.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 羊荣毅_L on 2017/3/23.
 * 建立网络连接专用类
 */
public class FlickrFetchr {
    public byte[] getURLBytes(String urlspac) throws IOException {
        URL url=new URL(urlspac);
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
        try{
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            InputStream in=connection.getInputStream();
            if (connection.getResponseCode()!=HttpURLConnection.HTTP_OK){
                throw new IOException(connection.getResponseMessage()+":with"+urlspac);
            }
            int bytesRead=0;
            byte[] buffer=new byte[1024];
            while ((bytesRead=in.read(buffer))>0){
                out.write(buffer,0,bytesRead);
            }
            out.close();
            return out.toByteArray();
        }finally {
            connection.disconnect();
        }
    
    }
    // TODO: 2017/3/23  
}
