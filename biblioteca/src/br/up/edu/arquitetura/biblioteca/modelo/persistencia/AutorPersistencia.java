package br.up.edu.arquitetura.biblioteca.modelo.persistencia;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.modelo.dominio.Autor;

public class AutorPersistencia {

	private static ArrayList<Autor> autores = new ArrayList<Autor>();
	
	
	public Autor insert (Autor autor) {

		autor.setId(autores.size());
		autores.add(autor);
		
		return autores.get(autor.getId());
	}
	
	public ArrayList<Autor> list (){
		return autores;
	}
	
	public Autor find(int id) {
		return autores.get(id);	
	}
	
	public Autor update(Autor autor) {
		
		//Autor aux = autores.get(autor.getId());
		//aux.setId(autor.getId());
		//aux.setNacionalidade(autor.getNacionalidade());
		//aux.setNome(autor.getNome());
		
		autores.remove(autor.getId());
		autores.add(autor.getId(), autor);
		return autores.get(autor.getId());	
	}
	
}
