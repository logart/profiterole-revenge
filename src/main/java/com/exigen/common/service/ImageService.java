package com.exigen.common.service;


import java.io.IOException;


public interface ImageService {

    String postImage(byte[] userFileByteArray,String userFileName) throws IOException;
}