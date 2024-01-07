package com.medical.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class User extends AuditModel {
@Size(min = 2, max = 30)
@Column(nullable = false)
@NotBlank(message = "le nom ne peut pas être vide")
private String nom;
@Size(min = 2, max = 30)
@Column(nullable = false)
@NotBlank(message = "le prénom ne peut pas être vide")
private String prenom;

@Column(nullable = false)
@NotBlank(message = "le nom ne peut pas être vide")
@Email(message = "donnez un email valide")
private String email;
@Size(min = 6, max = 50)
@Column(nullable = false)
private String password;
@Min(value = 16)
private int age;
@OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JsonIgnoreProperties("user")
private  Profile profile;
@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JsonIgnoreProperties("user")
private List<Maladie> maladies;
@Enumerated(EnumType.STRING)
private Genre genre;

}
