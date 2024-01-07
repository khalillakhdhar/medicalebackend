package com.medical.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AuditModel {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@EqualsAndHashCode.Include
private long id;
@Temporal(TemporalType.TIMESTAMP)
@Column(name = "created_at",nullable = false,updatable = true)
@CreatedDate
private Date createdAt;
@Temporal(TemporalType.TIMESTAMP)
@Column(name = "updated_at",nullable = false)
@LastModifiedDate
private Date updatedAt;
}
