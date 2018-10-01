package br.up.edu.arquitetura.biblioteca.modelo.persistencia;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.modelo.dominio.Autor;
import br.up.edu.arquitetura.biblioteca.modelo.dominio.Livro;

public class LivroPersistencia {

	private static ArrayList<Livro> livros = new ArrayList<Livro>();
	
	
	public Livro insert (Livro livro) {
		
		livro.setId(livros.size());
		livros.add(livro);
		
		return livros.get(livro.getId());
	}
	
	public ArrayList<Livro> list (){
		return livros;
	}
	public Livro find(int id) {
		return livros.get(id);	
	}
	
	public Livro update(Livro livro) {
		//Livro aux = livros.get(livro.getId());
		//aux.setId(livro.getId());
		//aux.setAutor(livro.getAutor());
		//aux.setPaginas(livro.getPaginas());
		//aux.setResumo(livro.getResumo());
		//aux.setTitulo(livro.getTitulo());
		
		livros.remove(livro.getId());
		livros.add(livro.getId(), livro);
		return livros.get(livro.getId());	
		
	}
	
}
