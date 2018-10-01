package br.up.edu.arquitetura.biblioteca.modelo.negocio;

import java.util.ArrayList;


import br.up.edu.arquitetura.biblioteca.modelo.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.modelo.persistencia.LivroPersistencia;

public class LivroNegocio {

	private LivroPersistencia persist = new LivroPersistencia();
	
	
	public ArrayList<Livro> listarTodos(){
		return persist.list();
	}
	
	public Livro cadastra(Livro livro) {
		//Rng's
		return persist.insert(livro);
		
	}
	public Livro atualizar(Livro livro) {
		return persist.update(livro);
	}
}
