//package com.tk.learn.eclipseStroreDemo.conf;
//
//import org.eclipse.store.integrations.spring.boot.types.configuration.EclipseStoreProperties;
//import org.eclipse.store.integrations.spring.boot.types.factories.EmbeddedStorageFoundationFactory;
//import org.eclipse.store.integrations.spring.boot.types.factories.EmbeddedStorageManagerFactory;
//import org.eclipse.store.storage.embedded.types.EmbeddedStorageFoundation;
//import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class EclipseStoreConf {
//
////    @Bean
////    EmbeddedStorageManager injectStorageTest(
////            @Autowired EclipseStoreProperties myConfiguration,
////            @Autowired EmbeddedStorageManagerFactory managerFactory,
////            @Autowired EmbeddedStorageFoundationFactory foundationFactory
////    ) {
////
////        // Modify the configuration
////        myConfiguration.setStorageDirectory(temp.getDir().getAbsolutePath());
////        // Create a new StorageFoundation
////        EmbeddedStorageFoundation<?> storageFoundation = foundationFactory.createStorageFoundation(myConfiguration);
////
////        // Modify the storageFoundation
////        //storageFoundation.onConnectionFoundation(f -> f.someOperation);
////
////        // Create a new StorageManager
////        return managerFactory.createEmbeddedStorageManager(storageFoundation, true);
////    }
//
//    @Autowired
//    private EmbeddedStorageFoundationFactory foundationFactory;
//
//    @Autowired
//    private EmbeddedStorageManagerFactory managerFactory;
//
//    @Bean("first_config")
//    @ConfigurationProperties("org.eclipse.store.first")
//    EclipseStoreProperties firstStoreProperties()
//    {
//        return new EclipseStoreProperties();
//    }
//
//    @Bean("second_config")
//    @ConfigurationProperties("org.eclipse.store.second")
//    EclipseStoreProperties secondStoreProperties()
//    {
//        return new EclipseStoreProperties();
//    }
//
//    @Bean
//    @Qualifier("first_storage")
//    EmbeddedStorageManager createFirstStorage(@Qualifier("first_config") final EclipseStoreProperties firstStoreProperties) {
//        return managerFactory.createStorage(
//                foundationFactory.createStorageFoundation(firstStoreProperties),
//                firstStoreProperties.isAutoStart()
//        );
//    }
//
//    @Bean
//    @Qualifier("second_storage")
//    EmbeddedStorageManager createSecondStorage(@Qualifier("second_config") final EclipseStoreProperties secondStoreProperties) {
//        return managerFactory.createStorage(
//                foundationFactory.createStorageFoundation(secondStoreProperties),
//                secondStoreProperties.isAutoStart()
//        );
//    }
//}
