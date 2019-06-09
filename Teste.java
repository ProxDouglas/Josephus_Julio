
/**
 * Escreva a descrição da classe Teste aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Teste
{
    public static void main(String args[]){
        int inter = 2;
        double tempo = 1000;
        int individuos = 10; 
        JosephusInterface jogo = new JosephusInterface(individuos, inter, tempo); 
        Josephus test = new Josephus(jogo.getIntervalo(), jogo.getTempoEspera());
        test.inserir(jogo.getQtdIndividuos());
        jogo.mostrarGui();
        //test.inserir(10);
        //String s = test.exibirLista();
        //System.out.println(s);
        //test.eliminarSemEtapas();
    }
}
