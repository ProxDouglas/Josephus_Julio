
/**
 * Implementação da classe pilha.
 * 
 * @author Julio Arakaki 
 * @version 0.1 20190426
 */
public class Pilha{
    // Atributos
    int tam;  // tamanho da pilha
    int qtde; // quantidade de elementos 
    VetDin armazen;

    
    /**
     * Pilha Constructor
     *
     * @param tam tamanho da pilha
     */
    public Pilha(int tam){
        armazen = new VetDin();
        setTam(tam);
        setQtde(0);
    }

    /**
     * Method setQtde
     *
     * @param qtde A parameter
     */
    public void setQtde(int qtde){
        this.qtde = qtde;
    }

    /**
     * Method getQtde
     *
     * @return The return value
     */
    public int getQtde(){
        return this.qtde;
    }

    /**
     * Method setTam
     *
     * @param tam A parameter
     */
    public void setTam(int tam){
        this.tam = tam;
    }

    /**
     * Method getTam
     *
     * @return The return value
     */
    public int getTam(){
        return this.tam;
    }

    /**
     * Method inserir
     *
     * @param elem elemento a ser inserido
     * @return true - inserido com sucesso, false - pilha cheia (nao inserido)
     */
    public boolean inserir(Object elem){
        boolean ret = false;
        if (! estaCheia()){
            armazen.inserir(elem);
            setQtde(getQtde() + 1);
            ret = true;
        }
        return ret;
    }

    /**
     * Method remover
     *
     * @return elemento removido ou null caso pilha vazia
     */
    public Object remover(){

        Object elem = null;

        if (! estaVazia()){
            elem = armazen.buscar(getQtde() - 1);
            armazen.remover(getQtde() - 1);
            setQtde(getQtde() - 1);
        }
        return elem;
    }

    /**
     * Method estaVazia
     *
     * @return true - pilha vazia ou false - nao vazia
     */
    boolean estaVazia(){
        return (getQtde() == 0);
    }

    /**
     * Method estaCheia
     *
     * @return true - pilha cheia ou false - nao cheia
     */
    boolean estaCheia(){
        return (getQtde() == getTam());
    }

    /**
     * Method topo
     *
     * @return elemento do topo, ou null se pilha vazia
     */
    public Object topo(){
        Object elem = null;

        if (! estaVazia()){
            elem = armazen.buscar(getQtde() - 1);        
        }        
        return elem;
    }
}
