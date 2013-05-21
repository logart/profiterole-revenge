package com.exigen.common.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


import java.io.File;
import java.io.IOException;


public class ImageServiceImpl implements ImageService {

     private static final int NO_MGK=5;

    public String postImage(byte[] userFileByteArray,String userFileName) throws IOException {
        String response;

        HttpClient httpclient = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://www.imageshack.us/upload_api.php");


        MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, null, null);

        FormBodyPart fbp = new FormBodyPart("fileupload", new ByteArrayBody(userFileByteArray, userFileName));
        entity.addPart(fbp);
        FormBodyPart fbp2 = new FormBodyPart("key", new StringBody("TZJ9IHE4548f34cc786cc77643a4051817bdb749"));
        entity.addPart(fbp2);
        post.setEntity(entity);
        post.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.2.6) Gecko/20100625 Firefox/3.6.6");
        post.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        post.addHeader("Accept-Language", "en-us,en;q=0.5");
        post.addHeader("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
        post.addHeader("Keep-Alive", "115");
        post.addHeader("Connection", "keep-alive");


        HttpResponse httpresponse = httpclient.execute(post);
        response = EntityUtils.toString(httpresponse.getEntity(), "UTF-8");

        return response.substring(response.indexOf("[IMG]")+NO_MGK, response.indexOf("[/IMG]"));
    }
}
