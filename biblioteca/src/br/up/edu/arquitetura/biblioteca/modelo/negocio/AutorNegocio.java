package br.up.edu.arquitetura.biblioteca.modelo.negocio;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.modelo.dominio.Autor;
import br.up.edu.arquitetura.biblioteca.modelo.persistencia.AutorPersistencia;

public class AutorNegocio {

	
private AutorPersistencia persist = new AutorPersistencia();
	
	
	public ArrayList<Autor> listarTodos(){
		return persist.list();
	}
	
	public Autor cadastra(Autor autor) {
		//Rng's
		return persist.insert(autor);
		
	}
	
	public Autor procurar(int id) {
		return persist.find(id);
	}
	
	public Autor atualizar(Autor autor) {
		return persist.update(autor);
	}
}
