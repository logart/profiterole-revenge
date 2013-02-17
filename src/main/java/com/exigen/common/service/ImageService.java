package com.exigen.common.service;


import java.io.File;
import java.io.UnsupportedEncodingException;

public interface ImageService {

    String postImage(File userFile) throws UnsupportedEncodingException;
}