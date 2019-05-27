
/**
 * Escreva a descrição da classe Teste aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Teste
{
    public static void main(String args[]){
        int inter = 5;
        Josephus test = new Josephus(inter);
        test.inserir(10);
        String s = test.exibirLista();
        System.out.println(s);
        for(int i = 0; i<inter;i++){
            test.eliminarPorEtapa(inter);
            s = test.exibirLista();
            System.out.println(s);
        }
    }
}
