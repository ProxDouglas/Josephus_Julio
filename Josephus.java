
/**
 * Escreva a descrição da classe Josephus aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Josephus
{
    private IListaDuplamenteLigadaCircular ldl;
    private int intervalo;
    private Celula ponteiro;
    private long tempo; 
    
    public Josephus(int intervalo, double tempo){
        ldl = new ListaDuplamenteLigadaCircular();
        setIntervalo(intervalo);
        setPonteiro(null);
        setTempo(tempo);
    }
    
    public long getTempo(){
        return this.tempo;
    }
    
    public void setTempo(double tempo){
        this.tempo = (long)(tempo * 1000);
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
            try {
            // thread to sleep for 1000 milliseconds
            Thread.sleep(getTempo());
         } catch (Exception e) {
            System.out.println(e);
         }
            eliminarPorEtapa(getIntervalo());
            s = exibirLista();
            System.out.println(s);
        }while(!ldl.temUmElemento());
    }
    
    public String exibirLista(){
        return ldl.toString();
    }
    
}
