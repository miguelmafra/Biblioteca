package br.up.edu.arquitetura.biblioteca.modelo.negocio;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.modelo.dominio.Mutuario;
import br.up.edu.arquitetura.biblioteca.modelo.persistencia.MutuarioPersistencia;

public class MutuarioNegocio {

	
private MutuarioPersistencia persist = new MutuarioPersistencia();
	
	
	public ArrayList<Mutuario> listarTodos(){
		return persist.list();
	}
	
	public Mutuario cadastra(Mutuario mutuario) {
		//Rng's
		return persist.insert(mutuario);
		
	}
	
	public Mutuario procurar(int id) {
		return persist.find(id);
	}
	
	public Mutuario atualizar(Mutuario mutuario) {
		return persist.update(mutuario);
	}
}
