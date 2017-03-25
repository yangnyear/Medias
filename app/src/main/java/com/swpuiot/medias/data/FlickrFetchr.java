package com.swpuiot.medias.data;

import android.net.Uri;
import android.util.Log;

import com.swpuiot.medias.entities.GalleryItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 羊荣毅_L on 2017/3/23.
 * 建立网络连接专用类
 */
public class FlickrFetchr {
    private static final String API_KEY = "yourApiKeyHere";
    private static final String TAG = "FlickrFetchr";

    public byte[] getURLBytes(String urlspac) throws IOException {
        URL url = new URL(urlspac);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() + ":with" + urlspac);
            }
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }

    }

    public String getURLString(String urlSpace) throws IOException {
        return new String(getURLBytes(urlSpace));
    }

    public List<GalleryItem> fetchItem() {
        List<GalleryItem> items = new ArrayList<GalleryItem>();
        try {
            String url = Uri.parse("http://api.flicker.com/service/rest")
                    .buildUpon()
                    .appendQueryParameter("method", "flicker.photos.getResent")
                    .appendQueryParameter("api_key", API_KEY)
                    .appendQueryParameter("format", "json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .appendQueryParameter("extras", "uri_s")
                    .build().toString();
            String jsonString = getURLString(url);
            Log.i(TAG, "receive的json:" + jsonString);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItem(items, jsonBody);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return items;
    }

    private void parseItem(List<GalleryItem> items, JSONObject jsonBody) throws JSONException,IOException {
        JSONObject photosJsonObject = jsonBody.getJSONObject("photos");
        JSONArray photoJsonArray = photosJsonObject.getJSONArray("photos");
        for (int i = 0; i < photoJsonArray.length(); i++) {
            JSONObject photoJsonObject = photoJsonArray.getJSONObject(i);
            GalleryItem item = new GalleryItem();
            item.setId(photoJsonObject.getString("id"));
            item.setCaption(photoJsonObject.getString("title"));
            if (!photoJsonObject.has("uri_s")) {
                continue;
            }
            item.setUrll(photoJsonObject.getString("uri_s"));
            items.add(item);
        }
    }
}
