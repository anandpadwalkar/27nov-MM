package com.iitms.rfcampuscommon;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadUtil {

    @Autowired
    UploadsDirectories uploadsDirectories;

    @Autowired
    RandomNumberGenerator randomNumberGenerator;

    public String uploadFile(HttpServletRequest request, MultipartFile newFile, String oldFileName, String moduleName) {
        String fileName = null;
        String realPath = request.getSession().getServletContext().getRealPath("");
        File directory = null;
        
        try {
            switch (moduleName) {
                case "college": {
                    directory = new File(realPath + uploadsDirectories.getUploadDirectory()
                    + uploadsDirectories.getAuthorizationDirectory() + uploadsDirectories.getCollege());

                if (!directory.exists())
                    directory.mkdirs();
                
                if (newFile.getOriginalFilename() != "") {
                    deleteFile(request, oldFileName, "college");
                    fileName = getFileName(newFile.getOriginalFilename());
                    newFile.transferTo(new File(realPath + uploadsDirectories.getUploadDirectory()
                        + uploadsDirectories.getAuthorizationDirectory() + uploadsDirectories.getCollege() + fileName));
                }
                }
                    break;
                case "society": {
                    directory = new File(realPath + uploadsDirectories.getUploadDirectory()
                    + uploadsDirectories.getAuthorizationDirectory() + uploadsDirectories.getSociety());

                if (!directory.exists())
                    directory.mkdirs();
                
                if (newFile.getOriginalFilename() != "") {
                    deleteFile(request, oldFileName, "society");
                    fileName = getFileName(newFile.getOriginalFilename());
                    newFile.transferTo(new File(realPath + uploadsDirectories.getUploadDirectory()
                        + uploadsDirectories.getAuthorizationDirectory() + uploadsDirectories.getSociety() + fileName));
                }
                }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return fileName;
    }

    private String getFileName(String originalFileName) {
        return "authorization_college_" + randomNumberGenerator.getRandomNumber() + "_" + originalFileName;
    }

    private void deleteFile(HttpServletRequest request, String oldFileName, String module) {

        switch (module) {
            case "college": {
                new File(request.getSession().getServletContext().getRealPath("")
                    + uploadsDirectories.getUploadDirectory() + uploadsDirectories.getAuthorizationDirectory()
                    + uploadsDirectories.getCollege() + oldFileName).delete();
            }
                break;
            case "society": {
                new File(request.getSession().getServletContext().getRealPath("")
                    + uploadsDirectories.getUploadDirectory() + uploadsDirectories.getAuthorizationDirectory()
                    + uploadsDirectories.getSociety() + oldFileName).delete();
            }
                break;
        }

    }
}
