package com.medical.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonIgnoreProperties({"hibernateLazyInitialiser","handler"})
public class Medicament extends AuditModel {
@NotBlank(message = "le titre ne peut pas être vide")
private String titre;
@Column(length = 255)
private String description;
@Temporal(TemporalType.DATE)

private Date debut;
@Temporal(TemporalType.DATE)

private Date fin;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "maladie_id")
@JsonIgnoreProperties("maldies")
private Maladie maladie;
@OneToMany(fetch = FetchType.LAZY,mappedBy = "medicament",cascade = CascadeType.ALL)
@JsonIgnoreProperties("medicament")
private List<Rappel> rappels;

}
