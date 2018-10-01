package br.up.edu.arquitetura.biblioteca.modelo.dominio;

import java.util.Date;

public class Emprestimo {

	private int dataEmprestimo;
	private int id;
	private Livro livro;
	private Mutuario mutuario;
	private double multa;
	private boolean emprestado = true;
	private Date dataDeEmprestimo;
	private Date dataPrevistaDevolucao;
	
	public Date getDataDeEmprestimo() {
		return dataDeEmprestimo;
	}
	public void setDataDeEmprestimo(Date dataDeEmprestimo) {
		this.dataDeEmprestimo = dataDeEmprestimo;
	}
	public Date getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}
	public void setDataPrevistaDevolucao(Date dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
	public double getMulta() {
		return multa;
	}
	public void setMulta(double multa) {
		this.multa = multa;
	}
	public boolean isEmprestado() {
		return emprestado;
	}
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	public int getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(int dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Mutuario getMutuario() {
		return mutuario;
	}
	public void setMutuario(Mutuario mutuario) {
		this.mutuario = mutuario;
	}
	
	
	
	
	
}
