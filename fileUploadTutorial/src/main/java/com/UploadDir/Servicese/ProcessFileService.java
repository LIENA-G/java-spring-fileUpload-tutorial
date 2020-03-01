package com.UploadDir.Servicese;

import com.UploadDir.Configurations.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class ProcessFileService {

    public  void saveMultipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        String path ="D:/New folder";
        File destinationFile = new File(path + "/" + fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(destinationFile);
        fileOutputStream.write(multipart.getBytes());
        fileOutputStream.close();

    }

}
