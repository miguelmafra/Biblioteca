package br.up.edu.arquitetura.biblioteca.modelo.negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.up.edu.arquitetura.biblioteca.modelo.dominio.Emprestimo;
import br.up.edu.arquitetura.biblioteca.modelo.dominio.Livro;
import br.up.edu.arquitetura.biblioteca.modelo.persistencia.EmprestimoPersistencia;

public class EmprestimoNegocio {

	private EmprestimoPersistencia persist = new EmprestimoPersistencia();
	
	public ArrayList<Emprestimo> listarTodos(){
		return persist.list();
	}
	
	public Emprestimo cadastra(Emprestimo emprestimo) throws Exception {
		if(emprestimo.getLivro().isEmprestado()) throw new Exception("O livro já está emprestado.");
		else if(emprestimo.getMutuario().isEmprestado()) throw new Exception("O mutuário já possui livro emprestado");
		emprestimo.setDataDeEmprestimo(new Date());
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, emprestimo.getDataEmprestimo());
		dt = c.getTime();
		emprestimo.setDataPrevistaDevolucao(dt);
		emprestimo.getLivro().setEmprestado(true);
		emprestimo.getMutuario().setEmprestado(true);
		return persist.insert(emprestimo);
	}
	public Emprestimo atualizar(Emprestimo emprestimo) {
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, emprestimo.getDataEmprestimo());
		dt = c.getTime();
		emprestimo.setDataPrevistaDevolucao(dt);
		return persist.update(emprestimo);
	}
	public Emprestimo delete(Emprestimo emprestimo) {
		
		emprestimo.getLivro().setEmprestado(false);
		emprestimo.getMutuario().setEmprestado(false);
		return persist.delete(emprestimo);
	}
	
	
	
}
