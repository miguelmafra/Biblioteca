package br.up.edu.arquitetura.biblioteca.modelo.dominio;

public class Mutuario {
    private static final long serialVersionUID = 1L;

    
    private int id;

 
    private String nome;

   
    private String nacionalidade;
    
    private boolean emprestado;

    public Mutuario() {
    }

    public Mutuario(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }
    
    

    public boolean isEmprestado() {
		return emprestado;
	}

	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

       @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Mutuario other = (Mutuario) obj;
        if (id == 0) {
            if (other.id != 0)
                return false;
        } else if (id != other.id)
            return false;
        return true;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }


}
