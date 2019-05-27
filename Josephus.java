
/**
 * Escreva a descrição da classe Josephus aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Josephus
{
    IListaDuplamenteLigada ldl;
    private int intervalo;
    private Celula ponteiro;
    
    public Josephus(int intervalo){
        ldl = new ListaDuplamenteLigada();
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
        for(i=0; i<quantidade; i++){
            Object novo;
            novo = i+1;
            ldl.inserirInicio(i);
        }
        //setPonteiro(ldl.getInicio);
    }
    
    public void eliminarPorEtapa(int intervalo){
        ponteiro = (Celula)ldl.removerEmIntervalos(getPonteiro(), intervalo);
    }
    
    
    public void eliminarSemEtapas(int intervalo){
        while(getPonteiro() != null){
            eliminarPorEtapa(intervalo);
        }
    }
    
}
