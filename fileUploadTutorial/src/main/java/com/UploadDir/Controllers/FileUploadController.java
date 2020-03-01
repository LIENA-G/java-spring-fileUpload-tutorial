package com.UploadDir.Controllers;

import com.UploadDir.Repositories.FileObject;
import com.UploadDir.Repositories.FileObjectList;
import com.UploadDir.Servicese.ProcessFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FileUploadController {
    @Autowired
    ProcessFileService processFileService;

    @GetMapping(value = "/fileUpload")
    public String fileUploadForm(ModelMap model) {
        FileObject multipartFile = new FileObject();
        model.addAttribute("multipartFile", multipartFile);
        return "fileUploadView";
    }

    @GetMapping(value = "/singleFileUpload")
    public String singleFileUploadForm(ModelMap model) {
        FileObject multipartFile = new FileObject();
        model.addAttribute("multipartFile", multipartFile);
        return "singleUploadFileView";
    }


    @PostMapping(value = "/singleFileUpload")
    public String singleFileUpload(@Validated @ModelAttribute("multipartFile") FileObject multipartFile, BindingResult result, ModelMap model) throws IOException {
        if (result.hasErrors()) {
            return "error";
        }
        MultipartFile uploadedFile = multipartFile.getFile();
        processFileService. saveMultipartToFile(uploadedFile, uploadedFile.getOriginalFilename());

        model.addAttribute("fileName", uploadedFile.getOriginalFilename());
        model.addAttribute("contentType", uploadedFile.getContentType());
        return "singleUploadFileDetailsView";
    }

    @GetMapping(value = "/multipleFileUpload")
    public String MultipleFileUploadForm(ModelMap model) {
        FileObjectList fileObjectList = new FileObjectList();
        model.addAttribute("fileObjectList", fileObjectList);
        return "multipleFileUploadView";
    }

    @PostMapping(value = "/multipleFileUpload")
    public String multipleFileUpload(@Validated @ModelAttribute("fileObjectList") FileObjectList fileObjectList, BindingResult result, ModelMap model) throws IOException {
        if (result.hasErrors()) {
            return "error";
        }
        List<MultipartFile> uploadedFileObjectList = fileObjectList.getFileObjectList();
        List<String> fileNames = new ArrayList<>();

        for (MultipartFile file : uploadedFileObjectList) {
            processFileService.saveMultipartToFile(file, file.getOriginalFilename());
            fileNames.add(file.getOriginalFilename());
        }

        model.addAttribute("fileObjectList", fileObjectList);
        model.addAttribute("fileObjectNames", fileNames);
        return "multipleFileUploadDetailsView";
    }


}
