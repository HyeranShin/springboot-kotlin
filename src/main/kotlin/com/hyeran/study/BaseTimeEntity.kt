package com.hyeran.study

import java.time.LocalDateTime
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class) // Auditing 기능 포함
abstract class BaseTimeEntity(@CreatedDate var createdDate: LocalDateTime? = null,
                              @LastModifiedDate var modifiedDate: LocalDateTime? = null)