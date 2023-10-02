package com.cryptoinvestment.services;

import com.cryptoinvestment.models.FileType;

import java.io.File;

/**
 * File Handler interface.
 *
 * @author maksim aleksandrov
 */
public interface FileHandler {

     /**
      * start processing file
      * @param file file
      */
     void processFile(File file);

     /**
      * get file type
      * @return type of file
      */
     FileType getFileType();
}
