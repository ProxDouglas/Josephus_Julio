
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Implementa o ambiente grafico para Josephus
 */
public class JosephusInterface extends JFrame implements ActionListener{

	// Conteiners
	// Conteiner principal
	Container painelPrincipal  = getContentPane();

	// Container dos individuos
	Container painelIndividuos = new JPanel(); 

	// Container dos comandos (botoes)
	Container painelComandos = new JPanel();   // container dos botoes 

	// Container dos entrada de dados
	Container painelEntrada = new JPanel();   // container dos entrada 

	// Objeto de animacao (em thread separado)
	Animacao animar = null;

	// Componentes para gui
	// vetor de labels (representa os individuos
	JLabel []individuos = null;   

	// Componentes para entrada de dados
	// Qtde de individuos
	JLabel jlbNsoldados = null;
	JTextField jtfNsoldados = null;

	// Intervalo de execucao
	JLabel jlbIntervalo = null;
	JTextField jtfIntervalo = null;

	// tempo de espera
	JLabel jlbTempoEspera = null;
	JTextField jtfTempoEspera = null;

	// Individuo sobrevivente
	JLabel jlbIndividuosRestante = null;
	JLabel jlbIndividuoRestanteValor = null;

	// Botoes de comando
	JButton jbExecutar = null; 
	JButton jbReiniciar = null;
	JButton jbSair = null;
	JButton jbConfig = null;
	JButton jbSobre = null;

	// Cores de componentes
	Color corIndividuo = null;
	Color corFundo = null;
	Color corBorda = null;
	Color corIndividuoExecutado = null;

	// Parametros para o Josephus
	int qtdIndividuos; // numero de individuos
	int intervalo; // intervalo de execucao
	double tempoEspera; // velocidade da animacao

	public JosephusInterface (int qtdIndividuos, int intervalo, double tempoEspera) {

		// Caracteristicas da Janela
		super("Josephus LED v0.1");
		setSize(1200, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// Cores para os componentes
		setCorIndividuo(Color.BLUE);
		setCorIndividuoExecutado(Color.RED);
		setCorFundo(Color.LIGHT_GRAY);
		setCorBorda(Color.GRAY);

		// painel de individuos
		painelIndividuos.setLayout(new FlowLayout((FlowLayout.CENTER))); // define layout
		painelIndividuos.setBackground(getCorFundo());
		painelIndividuos.setPreferredSize(new Dimension(605, 130));

		// cria array de labels (individuos)
		individuos = new JLabel [qtdIndividuos]; 

		// Define layout dos botoes
		painelComandos.setLayout (new GridLayout(4,1));

		// Define qtde de individuos
		setQtdIndividuos(qtdIndividuos);
		// define intervalo de execucao
		setIntervalo(intervalo);
		// Velocidade de animacao
		setTempoEspera(tempoEspera);

	}

	/**
	 * @return corBorda
	 */
	protected Color getCorBorda() {
		return this.corBorda;
	}

	/**
	 * @param corBorda 
	 */
	protected void setCorBorda(Color corBorda) {
		this.corBorda = corBorda;
	}

	/**
	 * @return corIndividuo
	 */
	protected Color getCorIndividuo() {
		return this.corIndividuo;
	}

	/**
	 * @param corIndividuo 
	 */
	protected void setCorIndividuo(Color corIndividuo) {
		this.corIndividuo = corIndividuo;
	}

	/**
	 * @return Returns the corFundo.
	 */
	protected Color getCorFundo() {
		return this.corFundo;
	}

	/**
	 * @param fundo The corFundo to set.
	 */
	protected void setCorFundo(Color corFundo) {
		this.corFundo = corFundo;
	}

	public int getQtdIndividuos() {
		return this.qtdIndividuos;
	}

	public void setQtdIndividuos(int qtdIndividuos) {
		this.qtdIndividuos = qtdIndividuos;
	}

	public int getIntervalo() {
		return this.intervalo;
	}

	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}

	public double getTempoEspera() {
		return this.tempoEspera;
	}

	public void setTempoEspera(double tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	/**
	 * @return the corIndividuoExecutado
	 */
	public Color getCorIndividuoExecutado() {
		return corIndividuoExecutado;
	}

	/**
	 * @param corIndividuoExecutado the corIndividuoExecutado to set
	 */
	public void setCorIndividuoExecutado(Color corIndividuoExecutado) {
		this.corIndividuoExecutado = corIndividuoExecutado;
	}

	/**
	 * reiniciarEd
	 * 
	 * 		Reinicia Estrutura de dados do Josephus
	 * 
	 */
	private void reiniciarEd() {
		// Adiciona individuos (j=labels) no painel de individuos
		individuos = new JLabel [getQtdIndividuos()]; // cria array de jpanels
	}


	/**
	 * reconfigurar
	 * 		Reinicia/reconfigura parametros para o Josephus
	 * 
	 * @param qtdeIndividuos quantidade de individuos
	 * @param intervalo intervalo de execucao
	 * @param tempoEspera tempo de espera para visualizacao
	 */
	void reconfigurar(int qtdeIndividuos, int intervalo, double tempoEspera) {

		setQtdIndividuos(qtdeIndividuos);
		setIntervalo(intervalo);
		// Velocidade de animacao
		setTempoEspera(tempoEspera);

		reiniciarEd();

		// Insere painel de individuos
		inserirPainelIndividuos(getQtdIndividuos());

		//Mostra a janela.
		pack();
		setVisible(true);
	}

	/**
	 * Mostra a interface com os componentes
	 */
	public void mostrarGui() {
		//adiciona paineis.
		adicionarPaineis();

		//Mostra a janela.
		pack();
		setVisible(true);
	}

	/**
	 * adicionarPaineis
	 * 		Adicionar paineis (entrada, individuos, comandos) no painel principal
	 */
	public void adicionarPaineis() {
		// Insere painel de entrada e os componentes
		inserirPainelEntrada();

		// Insere painel de individuos
		inserirPainelIndividuos(getQtdIndividuos());

		// Insere painel de botoes e os botoes 
		inserirPainelComandos();
	}

	/**
	 * inserirPainelEntrada
	 * 		Cria componentes, insere no painel de entrada e insere (North) o 
	 * 		painel de entradano painel principal
	 * 
	 */
	private void inserirPainelEntrada(){
		// Cria e configura atributos dos componentes
		jlbNsoldados = new JLabel ("Numero de individuos");    
		jtfNsoldados = new JTextField(""+getQtdIndividuos());
		jtfNsoldados.setColumns(2);
		jtfNsoldados.setEnabled(false);
		jtfNsoldados.setToolTipText("numero de individuos na lista");

		jlbIntervalo = new JLabel ("Intervalo");    
		jtfIntervalo = new JTextField(""+getIntervalo());
		jtfIntervalo.setColumns(2);
		jtfIntervalo.setEnabled(false);
		jtfIntervalo.setToolTipText("Intervalo de execucao");

		jlbTempoEspera = new JLabel ("Tempo de espera");
		jtfTempoEspera = new JTextField(""+getTempoEspera());
		jtfTempoEspera.setColumns(4);
		jtfTempoEspera.setEnabled(false);
		jtfTempoEspera.setToolTipText("Tempo de espera");

		jbSobre = new JButton ("Sobre");
		jbSobre.setToolTipText("Sobre Josephus GUI");
		jbSobre.addActionListener(this);

		// Adiciona componentes no painel de entrada de dados
		painelEntrada.add (jlbNsoldados);
		painelEntrada.add (jtfNsoldados);
		painelEntrada.add (jlbIntervalo);
		painelEntrada.add (jtfIntervalo);
		painelEntrada.add (jlbTempoEspera);
		painelEntrada.add (jtfTempoEspera);
		painelEntrada.add (jbSobre);

		// Adiciona o painel de entrada no painel principal 
		painelPrincipal.add ("South", painelEntrada);
	}

	/**
	 * inserirPainelIndividuos
	 * 		Cria labels (individuos) e insere no painel de individuos.
	 * 		Insere painel de individuos no painel principal (no centro)
	 * 
	 * @param qtde quantidade de individuos
	 */
	private void inserirPainelIndividuos(int qtde){
		// Cria e define os jlabels para o ambiente
		adicionarLabelsNoPainelIndividuos(qtde);

		// Adiciona o painel de jlabels na posicao norte da janela principal 
		painelPrincipal.add ("East", painelIndividuos);
	}

	/**
	 * adicionarLabelsNoPainelIndividuos
	 * 		adiciona os labels representando individuos no painel de individuos
	 * 
	 * @param qtd quantidade de individuos
	 */
	public void adicionarLabelsNoPainelIndividuos(int qtd) {

		// remove todos os individuos anteriores
		painelIndividuos.removeAll();
		// redesenha o painel
		painelIndividuos.repaint();

		// cria cada label com os seus atributos
		for (int i =  (qtd - 1); i >= 0; i--) {
			// Cria o jlabel de define os atributos
			individuos[i] =  new JLabel (""+ (i+1) );
			individuos[i].setPreferredSize(new Dimension (25, 20));
			individuos[i].setToolTipText("(" +  (i+1) + ")");
			individuos[i].setOpaque(true);
			individuos[i].setForeground(getCorFundo());
			individuos[i].setBackground(getCorIndividuo());
			individuos[i].setHorizontalAlignment(SwingConstants.CENTER);

			// Adiciona o label para o painel de individuos
			painelIndividuos.add(individuos[i], 0);
		}
	}

	/**
	 * inserirPainelComandos
	 * 		Cria componentes, insere no painel de comandos e insere (South) o 
	 * 		painel de entradano painel principal
	 * 
	 */
	private void inserirPainelComandos(){
		//Cria os componentes
		jlbIndividuosRestante = new JLabel("Individuo executado: ");
		jlbIndividuosRestante.setVisible(false);

		jlbIndividuoRestanteValor = new JLabel("  ");
		jlbIndividuoRestanteValor.setBackground(Color.GRAY);
		jlbIndividuoRestanteValor.setVisible(false);

		jbExecutar = new JButton ("Executar");
		jbExecutar.setToolTipText("Executar regras do Josephus");
		jbExecutar.addActionListener(this);

		jbReiniciar  = new JButton ("Reiniciar");
		jbReiniciar.setToolTipText("Reiniciar Josephus com os mesmos valores");
		jbReiniciar.addActionListener(this);
		jbReiniciar.setEnabled(false);

		jbSair = new JButton ("Sair");
		jbSair.setToolTipText("Termina programa");
		jbSair.addActionListener(this);

		jbConfig = new JButton ("Config");
		jbConfig.setToolTipText("Ativa configuracoes");
		jbConfig.addActionListener(this);
		jbConfig.setEnabled(true);

		// adiciona os botoes
		painelComandos.add (jlbIndividuosRestante);
		painelComandos.add (jlbIndividuoRestanteValor);
		painelComandos.add (jbExecutar);
		painelComandos.add (jbReiniciar);        	
		painelComandos.add (jbConfig);
		painelComandos.add (jbSair);

		//adiciona o painel de botoes na posiï¿½ï¿½o sul da janela principal
		painelPrincipal.add ("West", painelComandos);
	}

	public void actionPerformed(ActionEvent evt) {

		// captura evento
		String comando = evt.getActionCommand();

		// executa acao de acordo com o evento
		if (comando.equals("Sair")){ // botao Sair
			System.exit(0);
		} else if (comando.equals("Executar")){ // botao Executar			
			// verifica parametros
			if ((getIntervalo() > 1 && getIntervalo() < getQtdIndividuos()  && getTempoEspera() > 0)) {
				iniciarAnimacao(500);

				// Desabilita botoes
				jbConfig.setEnabled(true);
				jbExecutar.setEnabled(false);
				jbReiniciar.setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(null, "Valores Invalidos", "Erro!!", JOptionPane.ERROR_MESSAGE);
			}
		} else if (comando.equals("Reiniciar")){ // botao reiniciar
			// pega parametros
			animar.stop();
			int qtdSold = Integer.parseInt(jtfNsoldados.getText()); 
			int interv = Integer.parseInt(jtfIntervalo.getText());
			double tempo = Double.parseDouble(jtfTempoEspera.getText());
			// verifica parametros
			if (interv > 1 && interv < qtdSold && tempo > 0) {

				// Reinicia / reconfigura com novos dados
				reconfigurar(qtdSold, interv, tempo);


				// habilita botao executar
				jbExecutar.setEnabled(true);

				// desabilita outros componentes
				jbReiniciar.setEnabled(false);
				jlbIndividuosRestante.setVisible(false);
				jlbIndividuoRestanteValor.setVisible(false);
				jtfNsoldados.setEnabled(false);
				jtfIntervalo.setEnabled(false);
				jtfTempoEspera.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(null, "Valores Invalidos", "Erro!!", JOptionPane.ERROR_MESSAGE);
			}
		}else if (comando.equals("Config")){ // botao Config

			// Habilita componentes d entrada
			jtfNsoldados.setEnabled(true);
			jtfIntervalo.setEnabled(true);
			jtfTempoEspera.setEnabled(true);

			// Habilita botao Reiniciar
			jbReiniciar.setEnabled(true);

			// Habilita botao Executar
			jbExecutar.setEnabled(false);
		} else if (comando.equals("Sobre")){
			sobre();
		} 
	}

	
	private class Animacao extends Thread {
		public double tempoEspera;
		
		
		public Animacao(double tempoEspera){
			this.tempoEspera = tempoEspera;
		}

		// Metodo contendo o algoritmo do Josephus
		public void run() {

			// TESTE
			int qtd = getQtdIndividuos();
			for (int i = 0; i < qtd; i += 2) {
				individuos[i].setBackground(getCorIndividuoExecutado());	
				try {
					Thread.sleep((long)this.tempoEspera);
				}catch(Exception e) {

				}
			}
		}
	}
	
	
	
	/**
	 * iniciarAnimacao
	 * 
	 * Metodo responsavel pela criacao e "disparo" da Thread 
	 * com o algoritmo do Josephus
	 * 
	 */
	public void iniciarAnimacao(int tempoEspera) {
		// instancia uma nova thread (objeto da classe interna Anmacao)
		animar = new Animacao(tempoEspera);
		// inicia a thread (metodo run na classe Animacao) 
		animar.start();
	}

	
	/**
	 * sobre
	 * 
	 * Mostra informacoes sobre a aplicacao
	 * 
	 */	
	private void sobre(){
		String texto = "Josephus GUI 1.1\n\nEsta aplicacao implementa o algoritmo do Josephus \ncom Lista Duplamente Ligada Circular"
				+ "\n\n(c) Copyright 2019. Todos os direitos reservados.\n\n"
				+ "LED - Laboratorio de Estruturas Dinamicas\n"
				+ "Gabriel Ferreira Lima Silva - Douglas Cavalcanti - Raul Costa";

		JOptionPane.showMessageDialog(null, texto, "Sobre Josephus GUI", JOptionPane.INFORMATION_MESSAGE);
	}
}

