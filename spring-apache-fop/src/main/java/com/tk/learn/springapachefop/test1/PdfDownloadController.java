package com.tk.learn.springapachefop.test1;

import java.io.*;

import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;
import org.apache.fop.apps.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PdfDownloadController implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    private final static Logger LOG = LoggerFactory.getLogger(PdfDownloadController.class);

    @Autowired
    FopFactory fopFactory;

    @Autowired
    XmlMapper xmlMapper;

    @Autowired
    TransformerFactory transformerFactory;

    @RequestMapping(value = "/example.pdf" ,method = RequestMethod.GET)
    public void getPdf(@RequestParam(defaultValue = "12345678", name = "code") String code,
                       final HttpServletResponse response) throws FOPException, IOException, TransformerException {
        LOG.debug("Barcode value to use: " + code);

        FOUserAgent userAgent = fopFactory.newFOUserAgent();// FOUserAgent can be used to set user configurable options
//        Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, response.getOutputStream());
//
//        // Start FOP processing
//        Transformer transformer = transformerFactory.newTransformer(new StreamSource(getTestXsl()));
//        transformer.transform(getSource(code),
//                new SAXResult(fop.getDefaultHandler()));
        File pdfFile = new File("src/main/resources/output.pdf");
        try (OutputStream out = new FileOutputStream(pdfFile)) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(getTestXsl()));

            Source src = getSource(code);
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src, res);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    private InputStream getTestXsl() throws IOException {
        Resource testFoFileResource = this.resourceLoader.getResource("classpath:fop/testfile.xsl");
        return testFoFileResource.getInputStream();
    }

    private StreamSource getSource(final String codeValue) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmlMapper.writeValue(byteArrayOutputStream,new CustomModelObject(codeValue));
        val xmlString = byteArrayOutputStream.toString();
        LOG.info("xmlString " + xmlString);
        return new StreamSource(xmlString);
    }

    @Override
    public void setResourceLoader(ResourceLoader rl) {
        this.resourceLoader = rl;
    }
}