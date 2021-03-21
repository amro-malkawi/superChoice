package com.superchoice.registration.files;

import com.superchoice.registration.files.message.ResponseMessage;
import com.superchoice.registration.files.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("http://localhost:8080")
@Controller
@RequestMapping("/api/register")
public class fileController {

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("csvfile") MultipartFile csvfile, @RequestParam("xmlfile") MultipartFile xmlfile) {
        String message = "";
            try {
                fileService.mergeAndSave(csvfile,xmlfile);
                message = "Merged and Saved the files successfully: " + csvfile.getOriginalFilename()+", "+xmlfile.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                message = "Could not Merge and Save the files: " + csvfile.getOriginalFilename()+", "+xmlfile.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
    }


}
