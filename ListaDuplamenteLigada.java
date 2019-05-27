 

/**
 * classe: ListaDuplamenteLigada
 *  Implementa a TAD Lista Duplamente Ligada
 * 
 * @author Julio Arakaki
 * @version 20190520
 */
class ListaDuplamenteLigada implements IListaDuplamenteLigada {
    private int tamanho;
    private Celula inicio; // ref para primeiro elemento
    private Celula fim;    // ref para ultimo elemento
    
    
    /**
     * Construtor da Lista
     */
    public ListaDuplamenteLigada(){
        setTamanho(0);
        setInicio(null);
        setFim(null);
    }

    // Setters e Getters
    /**
     * @return endereco do primeiro elemento da lista
     */
    public int getTamanho() {
        return tamanho;
    }
    
    /**
     * @param inicio endereco do primeiro elemento da lista
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
    /**
     * @return endereco do primeiro elemento da lista
     */
    public Celula getInicio() {
        return inicio;
    }
    
    /**
     * @param inicio endereco do primeiro elemento da lista
     */
    public void setInicio(Celula inicio) {
        this.inicio = inicio;
    }
    
    /**
     * @return endereco do ultimo elemento da lista
     */
    public Celula getFim() {
        return fim;
    }
    
    /**
     * @param fim endereco do ultimo elemento da lista
     */
    public void setFim(Celula fim) {
        this.fim = fim;
    }
    
    /**
     * Verifica se a Lista esta vazia
     * 
     * @return true se estiver vazia e false caso contrario
     * 
     */
    public boolean estaVazia() {
        return (getInicio() == null && getFim() == null); 
    }

    /**
     * Insere um novo Celula no inicio da Lista
     *  
     */
    public void inserirInicio(Object elem) {

        // Cria novo no
        Celula novoCelula = new Celula(elem); 

        // Insere novo no na Lista (atualizando ponteiros)
        if( estaVazia() ) {   // se a lista estiver vazia
            setFim(novoCelula);
        } else {
            getInicio().setAnterior(novoCelula);
        }
        novoCelula.setProximo(getInicio());
        novoCelula.setAnterior(getFim());
        getFim().setProximo(novoCelula);
        setInicio(novoCelula);
        setTamanho(getTamanho()+1);
    }

    /**
     * Insere um novo Celula no finsl da Lista
     *  
     */
    public void inserirFim(Object elem) {
        // Cria novo no
        Celula novoCelula = new Celula(elem);  

        // Insere novo no na Lista (atualizando ponteiros)
        if( estaVazia() ) { // se a lista estiver vazia
            setInicio(novoCelula);
        } else {
            getFim().setProximo(novoCelula); 
            novoCelula.setAnterior(getFim());
            novoCelula.setProximo(getInicio());
            getInicio().setAnterior(novoCelula);
        }
        setFim(novoCelula);
        setTamanho(getTamanho()+1);
    }

    /**
     * Insere um novo Celula apos um Celula encontrado (pela chave)
     * 
     * @param chave codigo do elemento a ser encontrado
     * 
     * @param elem elemento a ser inserido
     * 
     * @return true se o o no foi inserido e false caso contrario
     * 
     */
    public boolean inserirApos(int chave, Object elem) {
        Celula noAtual = getInicio(); 

        // percorre a lista em busca do Celula
        while((Integer)noAtual.getConteudo() != chave) {
            noAtual = noAtual.getProximo(); 
            if(noAtual == null) { // nao encontrou posicao
                return false;  
            }
        }
        
        // Cria novo no
        Celula novoCelula = new Celula(elem);

        // Insere novo no na Lista (atualizando ponteiros)
        if(noAtual == getFim()) {
            novoCelula.setProximo(null); 
            setFim(novoCelula); 
        }
        else {
            novoCelula.setProximo(noAtual.getProximo());
            noAtual.getProximo().setAnterior(novoCelula);
        }
        novoCelula.setAnterior(noAtual);
        noAtual.setProximo(novoCelula);
        setTamanho(getTamanho()+1);
        
        return true; 
    }

    /**
     * Remove o primeiro Celula da Lista
     * 
     * @return Celula removido ou null se a Lista estiver vazia
     * 
     */
    public Celula removerInicio() {
        Celula temp = null;
        if(getInicio() != null) {
            temp = getInicio();
            if(getInicio().getProximo() == null){
                setFim(null); 
            } else {
                getInicio().getProximo().setAnterior(null); 
            }
            setInicio(getInicio().getProximo());
            setTamanho(getTamanho()-1);

            // isola o no removido (remove as referencias para proximo e anterior)
            temp.setProximo(null);
            temp.setAnterior(null);
        }

        // retorna o no removido
        return temp;
    }

    /**
     * Remove o ultimo Celula da Lista
     * 
     * @return Celula removido ou null se a Lista estiver vazia
     * 
     */
    public Celula removerFim() {
        Celula temp = null;
        
        if(getFim() != null) {

            // Guarda o no
            temp = getFim();

            // Acerta todas as referencias (ponteiros)
            if(getInicio().getProximo() == null) {
                setInicio(null); 
            }
            else {
                getFim().getAnterior().setProximo(null);
            }
            setFim(getFim().getAnterior());
            setTamanho(getTamanho()-1);
            
            // isola o no removido (remove as referencias para proximo e anterior)
            temp.setProximo(null);
            temp.setAnterior(null);
        }
        
        // retorna o no removido
        return temp;
    }


    /**
     * Remove um Celula de acordo com uma chave (inteiro)
     * 
     * 0param chave numero inteiro para buscar o no a ser removido
     * 
     * @return Celula removido ou null caso nao encontre
     * 
     */
    public Celula removerPelaChave(int chave) {
        Celula temp = null; // Ponteiro para percorrer a lista
        
        if(getInicio() != null) {
            
            temp = getInicio(); // comeca do nicio

            // Percorre ate encontrar o Celula, ou retorn null caso nao encontre
            while((Integer)temp.getConteudo() != chave) {
                temp = temp.getProximo(); 
                if(temp == null) {
                    return null;                
                }
            }

            // Acerta todas as referencias (ponteiros)
            if(temp == getInicio()) { // se for inicio
                setInicio(temp.getProximo());
            } else {
                temp.getAnterior().setProximo(temp.getProximo());
            }

            if(temp == getFim()) { // se for fim
                setFim(temp.getAnterior());
            } else {
                temp.getProximo().setAnterior(temp.getAnterior());
            }
            setTamanho(getTamanho()-1);
            // isola o no removido (remove as referencias para proximo e anterior)
            temp.setProximo(null);
            temp.setAnterior(null);
        }
                
        // retorna o no removido        
        return temp;
    }
    
    public Celula removerEmIntervalos(Object endereco, int intervalo){
        Celula eliminada;
        Celula assassino;
        int i;
        if(endereco == null){
            endereco = getInicio();
        }
        eliminada = (Celula)endereco;    
        for(i=0; i<intervalo; i++){
            eliminada = eliminada.getProximo();
        }
        //assassino = eliminada.getProximo();
        assassino = eliminada.getProximo();
        (eliminada.getAnterior()).setProximo(assassino);
        assassino.setAnterior(eliminada.getAnterior());
        eliminada.setAnterior(null);
        eliminada.setProximo(null);
        
        return assassino;
    }

    /**
     * Retorna o conteudo da Lista como String (do inicio ate o fim)
     */
    public String toString() {
        String s = "[ ";
        Celula noAtual = getInicio();  // inicia do inicio
        while(noAtual != null) {    // enquanto nao for fim da lista,
            s = s + noAtual.toString() + " ";  // monta os dados como string
            noAtual = noAtual.getProximo();   // vai para o proximo
        }
        s = s + "]";

        return s;
    }

    /**
     * Retorna o conteudo da Lista como String (do fim ate o inicio)
     */
    public String toStrinDoFim() {
        String s = "[ ";
        Celula noAtual = getFim();  // inicia no fim

        while(noAtual != null) { // enquanto nao for inicio da lista,
            s = s + noAtual.toString() + " "; // monta os dados como string
            noAtual = noAtual.getAnterior(); // vai para o anterior
        }
        
        s = s + "]";
        
        return s;
    }
}  
