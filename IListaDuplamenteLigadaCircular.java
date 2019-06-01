 

/**
 * Contem assinaturas do metodos da TAD Lista Duplamente Ligada
 * 
 * @author Julio Arakaki
 * @version 20190520
 */
public interface IListaDuplamenteLigadaCircular{
    public boolean estaVazia();
    
    public Object getInicio();
    
    public void inserirInicio(Object elem);

    public void inserirFim(Object elem);
    
    public boolean inserirApos(int chave, Object novo);

    public Object removerInicio();
    
    public Object removerFim();
    
    public Object removerPelaChave(int chave);
    
    public Object removerPelaChaveEndereço(Object chave);
    
    public boolean temUmElemento();
    
    public String toString();
    
    public String toStrinDoFim();
}
