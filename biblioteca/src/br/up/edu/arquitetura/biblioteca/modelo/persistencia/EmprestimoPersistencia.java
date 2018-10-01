package br.up.edu.arquitetura.biblioteca.modelo.persistencia;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.modelo.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.modelo.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.modelo.dominio.Mutuario;

public class EmprestimoPersistencia {

	
	private static ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
	private static LivroPersistencia livros = new LivroPersistencia();
	private static MutuarioPersistencia mutuarios = new MutuarioPersistencia();
	
	
	public Emprestimo insert (Emprestimo emprestimo) {
		emprestimo.setId(emprestimos.size());
		emprestimos.add(emprestimo);
		return emprestimos.get(emprestimo.getId());
	}
	
	public ArrayList<Emprestimo> list (){
		return emprestimos;
	}
	public Emprestimo find(int id) {
		return emprestimos.get(id);	
	}
	
	public Emprestimo update(Emprestimo emprestimo) {
		int id = emprestimo.getId();
		int l = emprestimo.getLivro().getId();
		int m = emprestimo.getMutuario().getId();
		for(Emprestimo em : emprestimos) {
			if(em.getId() == emprestimo.getId()) {
				emprestimos.remove(em);
				emprestimos.add(id, emprestimo);
				break;
			}
		}
		emprestimo.setLivro(livros.list().get(l));
		emprestimo.setMutuario(mutuarios.list().get(m));
		return emprestimos.get(emprestimo.getId());	
	}
	public Emprestimo delete(Emprestimo emprestimo) {
		emprestimo.getLivro().setEmprestado(false);
		emprestimo.getMutuario().setEmprestado(false);
		for(Emprestimo m : emprestimos) {
    		if(m.getId() == emprestimo.getId()) {
    			emprestimos.remove(m);
    			break;
    		}
    	}
		return null;
	}
}
