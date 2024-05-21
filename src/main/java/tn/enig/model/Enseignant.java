package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Enseignant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nom;
	String prenom;
	String spec;
	String grade;
	public Enseignant() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Enseignant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", spec=" + spec + ", grade=" + grade
				+ "]";
	}
	public Enseignant(String nom, String prenom, String spec, String grade) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.spec = spec;
		this.grade = grade;
	}
	public Enseignant(int id, String nom, String prenom, String spec, String grade) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.spec = spec;
		this.grade = grade;
	}
	

}
