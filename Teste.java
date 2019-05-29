
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
        double tempo = 0.8;
        Josephus test = new Josephus(inter, tempo);
        test.inserir(7);
        String s = test.exibirLista();
        System.out.println(s);
        //for(int i = 0; i<17;i+=inter){
            test.eliminarSemEtapas();
            //s = test.exibirLista();
            //System.out.println(s);
        //}
    }
}
