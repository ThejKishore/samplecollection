//package com.tk.learn.demo.conf
//
//import org.eclipse.store.integrations.spring.boot.types.configuration.EclipseStoreProperties
//import org.eclipse.store.integrations.spring.boot.types.factories.EmbeddedStorageFoundationFactory
//import org.eclipse.store.storage.embedded.types.EmbeddedStorage
//import org.eclipse.store.storage.embedded.types.EmbeddedStorageFoundation
//import org.eclipse.store.storage.types.Storage
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.context.annotation.Configuration
//import software.xdev.spring.data.eclipse.store.repository.config.EclipseStoreClientConfiguration
//import software.xdev.spring.data.eclipse.store.repository.config.EnableEclipseStoreRepositories
//import java.nio.file.Path
//
//
///**
// * To set this configuration for the package we use the [EnableEclipseStoreRepositories.clientConfiguration]
// * ()}. Another example:
// * [software.xdev.spring.data.eclipse.store.demo.dual.storage.person.PersistencePersonConfiguration]
// */
//@Configuration
//@EnableEclipseStoreRepositories
//class PersistenceInvoiceConfiguration @Autowired protected constructor(
//    defaultEclipseStoreProperties: EclipseStoreProperties?,
//    defaultEclipseStoreProvider: EmbeddedStorageFoundationFactory?
//) :
//    EclipseStoreClientConfiguration(defaultEclipseStoreProperties, defaultEclipseStoreProvider) {
//    /**
//     * This is one option how to configure the [EmbeddedStorageFoundation].
//     *
//     *
//     * We create a completely new foundation. That means that all configuration (e.g. properties) are not used here.
//     * With this method you have complete control over the configuration.
//     *
//     * Another example: [PersistencePersonConfiguration.createEmbeddedStorageFoundation]
//     */
//    override fun createEmbeddedStorageFoundation(): EmbeddedStorageFoundation<*> {
//        return EmbeddedStorage.Foundation(
//            Storage.Configuration(
//                Storage.FileProvider(
//                    Path.of(
//                        STORAGE_PATH
//                    )
//                )
//            )
//        )
//    }
//
//    companion object {
//        const val STORAGE_PATH: String = "storage-eclipsestore"
//    }
//}