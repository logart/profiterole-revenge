package com.exigen.common.service;


import java.io.File;
import java.io.IOException;


public interface ImageService {

    String postImage(File userFile) throws IOException;
}