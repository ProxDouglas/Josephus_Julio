 


/**
 * @author jarakaki
 * @version 0.2 20190523
 */
class Celula {
	private Object conteudo;  // dados do no
	private Celula proximo;       // proximo na lista
	private Celula anterior;      // anterior na lista
	
	/**
	 * constructor
	 * 
	 * @param conteudo dados do Celula
	 */
	public Celula(Object conteudo) {   // 
		setConteudo(conteudo);
		setProximo(null);
		setAnterior(null);
	}

	/**
	 * @return conteudo do Celula
	 */
	public Object getConteudo() {
		return conteudo;
	}

	/**
	 * @param conteudo dados do Celula
	 */
	public void setConteudo(Object conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * @return endereco do proximo Celula
	 */
	public Celula getProximo() {
		return proximo;
	}

	/**
	 * @param proximo endereco do proximo Celula
	 */
	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}

	/**
	 * @return endereco do Celula anterior
	 */
	public Celula getAnterior() {
		return anterior;
	}

	/**
	 * @param anterior endereco do Celula anterior
	 */
	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}

	/**
	 * Retorna o conteudo do Celula como String
	 */
	public String toString() { 
		return getConteudo().toString(); 
	}
} 
