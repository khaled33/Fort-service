package com.sid.Fort.UploadImage.controller;


import com.sid.Fort.UploadImage.Dao.UploadImageRipository;
import com.sid.Fort.UploadImage.payload.UploadFileResponse;
import com.sid.Fort.UploadImage.service.FileStorageService;
import com.sid.Fort.UserDetails.Dao.AppUsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private UploadImageRipository uploadImageRipository;
    @Autowired
    private AppUsersRepository appUsersRepository;

    @PostMapping("/uploadFile/{iduser}/{Description}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long iduser,@PathVariable String Description) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        UploadFileResponse uploadFileResponse= new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize(),appUsersRepository.getOne(iduser));

        if (uploadImageRipository.getUploadFileResponseByAppUser(appUsersRepository.getOne(iduser))!=null){

           uploadFileResponse.setId(uploadImageRipository.getUploadFileResponseByAppUser(appUsersRepository.getOne(iduser)).getId());
           uploadFileResponse.setDescription(Description);
           return uploadImageRipository.save(uploadFileResponse);

       }
        return uploadImageRipository.save(uploadFileResponse);




    }

//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.asList(files)
//                .stream()
//                .map(file -> uploadFile(file))
//                .collect(Collectors.toList());
//    }

//    @GetMapping("/downloadFile/{idUser}")
//    public ResponseEntity<Resource> downloadFile(@PathVariable Long idUser, HttpServletRequest request) {
//        // Load file as Resource
//       String  fileName =uploadImageRipository.getUploadFileResponseByAppUser(appUsersRepository.getOne(idUser)).getFileName();
//        Resource resource = fileStorageService.loadFileAsResource(fileName);
//
//        // Try to determine file's content type
//        String contentType = null;
//        try {
//            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
//        } catch (IOException ex) {
//            logger.info("Could not determine file type.");
//        }
//
//        // Fallback to the default content type if type could not be determined
//        if (contentType == null) {
//            contentType = "application/octet-stream";
//        }
//
//        return ResponseEntity.ok()
//                .contentType(MediaType.parseMediaType(contentType))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
    @GetMapping("/downloadFile/{idUser}")
    public UploadFileResponse downloadFile(@PathVariable Long idUser) {
        // Load file as Resource
//       String  fileName =uploadImageRipository.getUploadFileResponseByAppUser(appUsersRepository.getOne(idUser)).getFileName();
        UploadFileResponse  uploadFileResponse =uploadImageRipository.getUploadFileResponseByAppUser(appUsersRepository.getOne(idUser)) ;
        uploadFileResponse.setFileDownloadUri("https://fis.expert/en/LogoUserFort/"+uploadFileResponse.getFileName());
     return uploadFileResponse;
    }

}
