
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
        //boolean verif = false;
        JosephusInterface jogo = new JosephusInterface(individuos, inter, tempo); 
        Josephus test = new Josephus(jogo.getIntervalo(), 0.0);
        jogo.setQtdIndividuos(individuos);
        //jogo.setVerif(verif);
        test.inserir(jogo.getQtdIndividuos());
        //jogo.setPermut(test.eliminarSemEtapas());
        jogo.mostrarGui();
        //verif = jogo.getVerif();
        //test.inserir(10);
        //String s = test.exibirLista();
        //System.out.println(s);
        //test.eliminarSemEtapas();
}
}
