package com.tk.learn.springapachefop.test;
import org.apache.fop.apps.FOPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/pdf")
public class PdfGenerationController {
    @Autowired
    PdfGenerationService pdfGenerationService;

    @PostMapping("/create")
    public ResponseEntity<String> createPdf() throws FOPException, IOException {
        pdfGenerationService.createPdf();
        return ResponseEntity.ok("PDF generated successfully!");
    }
}