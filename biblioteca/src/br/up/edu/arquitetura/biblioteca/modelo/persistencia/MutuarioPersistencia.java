package br.up.edu.arquitetura.biblioteca.modelo.persistencia;

import java.util.ArrayList;

import br.up.edu.arquitetura.biblioteca.modelo.dominio.Mutuario;

public class MutuarioPersistencia {

	private static ArrayList<Mutuario> mutuarioes = new ArrayList<Mutuario>();
	
	
	public Mutuario insert (Mutuario mutuario) {

		mutuario.setId(mutuarioes.size());
		mutuarioes.add(mutuario);
		
		return mutuarioes.get(mutuario.getId());
	}
	
	public ArrayList<Mutuario> list (){
		return mutuarioes;
	}
	
	public Mutuario find(int id) {
		return mutuarioes.get(id);	
	}
	
	public Mutuario update(Mutuario mutuario) {
		
		//Mutuario aux = mutuarioes.get(mutuario.getId());
		//aux.setId(mutuario.getId());
		//aux.setNacionalidade(mutuario.getNacionalidade());
		//aux.setNome(mutuario.getNome());
		
		mutuarioes.remove(mutuario.getId());
		mutuarioes.add(mutuario.getId(), mutuario);
		return mutuarioes.get(mutuario.getId());	
	}
	
}
