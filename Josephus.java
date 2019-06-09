
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
    private int quantidade;

    public Josephus(int intervalo, double tempo){
        ldl = new ListaDuplamenteLigadaCircular();
        setIntervalo(intervalo);
        setPonteiro(ponteiro);
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
    
    private void setQtd(int quantidade){
     this.quantidade = quantidade;   
    }
    
    public int getQtd(){
        return this.quantidade;
    }

    /**
     * Método inserir: inseri quantidade definida de elementos
     *
     * @param quantidade Um parâmetro que da quantos elementos vão ter
     */
    public void inserir(int quantidade){
        int i;
        Object novo;

        for(i=0; i<quantidade; i++){
            novo = quantidade - i;
            ldl.inserirFim(novo);
        }
        setPonteiro((Celula)ldl.getInicio());
        setQtd(quantidade);
    }

    /**
     * Método eliminarPorEtapa: elimina um elemento em um intervalo definido e atualiza o ponteiro
     *
     * @param intervalo Um parâmetro que define o intervalo para eliminar
     */
    public int eliminarPorEtapa(int intervalo){
        Celula assassino;
        Celula morto;
        int i, mortoN;

        assassino = getPonteiro();
        
        for(i=1; i<intervalo; i++){
            assassino = assassino.getProximo();
        }
        setPonteiro(assassino.getProximo());
        mortoN = (int)assassino.getConteudo();
        morto = (Celula)ldl.removerPelaChaveEndereço(assassino);
        setQtd(getQtd()-1);
        return mortoN;
    }

    /**
     * Método eliminarSemEtapas: Controla o tempo de execução do programa 
     *  e repeti o metodo eliminarPorEtapa até sobrar um elemento na lista
     *
     */
    public int[] eliminarSemEtapas(){
        //String s = exibirLista();
        int i = 0;
        int[] permutacao = new int[getQtd()];
        while(!ldl.estaVazia()){
            //try {
                // thread to sleep for 1000 milliseconds
            //    Thread.sleep(getTempo());
            //} catch (Exception e) {
            //    System.out.println(e);
            //}
            //if(!ldl.estaVazia()){
                permutacao[i] = eliminarPorEtapa(getIntervalo());
                i++;
                //}
            //if(!ldl.estaVazia()){
                //s = exibirLista();
                //System.out.println(s);
            //}
        }
        return permutacao;
    }

    /**
     * Método exibirLista: Chama transfoma lista ligada em string
     *
     * @return retorna a String
     */
    public String exibirLista(){
        return ldl.toString();
    }

}
