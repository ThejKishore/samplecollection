package com.tk.learn.springapachefop.test1;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.fop.configuration.ConfigurationException;
import org.apache.fop.configuration.DefaultConfigurationBuilder;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.xml.sax.SAXException;

import javax.xml.transform.TransformerFactory;
import java.io.File;
import java.io.IOException;


@Configuration
public class BeanConfiguration implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Bean
    public FopFactory getFopFactory() throws IOException, ConfigurationException, SAXException {

        Resource configResource = this.resourceLoader.getResource("classpath:fop/fop-config.xml");
        File fopConfigFile = configResource.getFile();
        File baseFolder = new File(fopConfigFile.getParent());

        DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
        org.apache.fop.configuration.Configuration cfg = cfgBuilder.buildFromFile(fopConfigFile);

        FopFactoryBuilder builder = new FopFactoryBuilder(baseFolder.toURI()).setConfiguration(cfg);
        return builder.build();
    }

    @Bean
    public XmlMapper xmlMapper() {
        return new XmlMapper();
    }

    @Bean
    public TransformerFactory getTransformerFactory() {
        return TransformerFactory.newInstance();
    }

    @Override
    public void setResourceLoader(ResourceLoader rl) {
        this.resourceLoader = rl;
    }
}