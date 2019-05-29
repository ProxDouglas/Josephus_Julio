
/**
 * Escreva a descrição da classe Josephus aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Josephus
{
    IListaDuplamenteLigadaCircular ldl;
    private int intervalo;
    private Celula ponteiro;
    
    public Josephus(int intervalo){
        ldl = new ListaDuplamenteLigadaCircular();
        setIntervalo(intervalo);
        setPonteiro(null);
    }
    
    public int getIntervalo(){
        return this.intervalo;
    }
     
    public void setIntervalo(int intervalo){
        this.intervalo = intervalo;
    }
    
    public Celula getPonteiro(){
        return this.ponteiro;
    }
    
    public void setPonteiro(Celula ponteiro){
        this.ponteiro = ponteiro;
    }
    
    public void inserir(int quantidade){
        int i;
        Object novo;
        for(i=0; i<quantidade; i++){
            novo = quantidade - i;
            ldl.inserirFim(novo);
        }
        //setPonteiro(ldl.getInicio());
    }
    
    public void eliminarPorEtapa(int intervalo){
        ponteiro = (Celula)ldl.removerEmIntervalos(getPonteiro(), intervalo);
    }
    
    
    public void eliminarSemEtapas(){
        String s = exibirLista();
        do{
            eliminarPorEtapa(getIntervalo());
            s = exibirLista();
            System.out.println(s);
        }while(!ldl.temUmElemento());
    }
    
    public String exibirLista(){
        return ldl.toString();
    }
    
}
