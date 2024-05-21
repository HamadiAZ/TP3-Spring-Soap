package tn.enig.JaxWs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import tn.enig.dao.Dao;

import tn.enig.model.Enseignant;

@WebService(name = "tp3")
public class Service {

	Dao d = new Dao();

	@WebMethod(operationName = "getAll")
	public List<Enseignant> getAllEnseignants() {
		return d.getAllEnseignants();
	}

	@WebMethod(operationName = "addEnseignant")
	public String addEnseignant(@WebParam(name = "nom") String nom, @WebParam(name = "prenom") String prenom,
			@WebParam(name = "matiere") String matiere, @WebParam(name = "niveau") String niveau) {
		Enseignant enseignant = new Enseignant(nom, prenom, matiere, niveau);
		
		try {
			d.addEnseignat(enseignant);
		} catch (Exception e) {
			return "error cant add this enseignant";
		}
		return "enseignant "+enseignant.getNom()+" has been added";
	}

	@WebMethod(operationName = "removeEnseignant")
	public String removeEnseignant(@WebParam(name = "id") int id) {
		try {
			d.remvoeEnseignat(id);
		} catch (Exception e) {
			return "error cant remove enseignant with id "+id;
		}
		return "enseignant with id "+id+" has been removed";
		
	}
}
