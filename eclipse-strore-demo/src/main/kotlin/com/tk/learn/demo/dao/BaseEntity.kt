package com.tk.learn.demo.dao

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Version
import java.io.Serializable


open class BaseEntity : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @Version
    var version: Long? = null
}