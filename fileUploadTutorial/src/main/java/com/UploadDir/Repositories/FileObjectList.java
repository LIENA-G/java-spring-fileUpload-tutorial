package com.UploadDir.Repositories;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FileObjectList {
    private List<MultipartFile> fileObjectList;

    public List<MultipartFile> getFileObjectList() {
        return fileObjectList;
    }

    public void setFileObjectList(List<MultipartFile> fileObjectList) {
        this.fileObjectList = fileObjectList;
    }
}

