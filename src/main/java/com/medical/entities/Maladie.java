package com.medical.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
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
public class Maladie extends AuditModel implements Serializable{
@NotBlank(message = "titre obligatoire")
@Column(nullable = false)
private String titre;
@NotBlank(message = "titre obligatoire")

private String description;
@NotBlank(message = "titre obligatoire")

private String gravite;
@NotBlank(message = "type obligatoire")
@Column(nullable = false)
private String type;
@PastOrPresent
private Date debut;


private Date fin;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")
@JsonIgnoreProperties("maldies")
@JsonIgnore
private User user;
@OneToMany(mappedBy = "maladie",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JsonIgnoreProperties("maladie")
private List<Medicament> medicaments;
}
