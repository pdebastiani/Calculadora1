package br.com.senior.dia0405.calculadora;

import javax.swing.JOptionPane;

/**
 * 
 * @author Paulo Sergio Debastiani - paulo.s.debastiani@gmail.com
 *
 * Calculadora de Anúncios Online
 * 
  		a cada 100 pessoas que visualizam o anúncio 12 clicam nele.
 		a cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais.
 		cada compartilhamento nas redes sociais gera 40 novas visualizações.
 		30 pessoas visualizam o anúncio original (não compartilhado) a cada R$ 1,00
 		investido.
 		o mesmo anúncio é compartilhado no máximo 4 vezes em sequência
 		(1a pessoa - compartilha - 2a pessoa - compartilha - 3a pessoa - compartilha -
 		4a pessoa)
 		Crie um script em sua linguagem de programação preferida que receba o valor investido em
 		reais e retorne uma projeção aproximada da quantidade máxima de pessoas que
 		visualizarão o mesmo anúncio (considerando o anúncio original + os compartilhamentos)
 * 
 */
public class Calculadora {

	public static void main(String[] args) {
				
		int valorInformado = entradaDados();
		System.out.println("Você digitou " + valorInformado + " Reais investidos");
		
		int qtdePessoasVisualizamAnuncioOriginal = 	calculaQtdePessoasVisualizamAnuncioOriginal(valorInformado);
		System.out.println("Qtde Pessoas q/visualizam o anúncio original: " + 
				qtdePessoasVisualizamAnuncioOriginal);
		
		double totalNovasVisualizaçoesGeradas = 0;
		int qtdeCiclosCompartilhamento = 4;
		
		double qtdePessoasVisualizamAnuncioCompartilhado = qtdePessoasVisualizamAnuncioOriginal;
		
		/**
		 * Este FOR repete os ciclos de compartilhamento conforme a variavel qtdeCiclosCompartilhamento
		 * 
		 * Regra: "o mesmo anúncio é compartilhado no máximo 4 vezes em sequência (1a pessoa -> compartilha -> 
		 * 		2a pessoa -> compartilha - > 3a pessoa -> compartilha -> 4a pessoa)"
		 */
		for (int i = 1; i<=qtdeCiclosCompartilhamento; i++) {
			double qtdePessoasVisualizamClicamAnuncio = 
					calculaQtdePessoasVisualizamClicamAnuncio(qtdePessoasVisualizamAnuncioCompartilhado);
			
			double qtdePessoasCompartilhamAnuncio = 
					calculaQtdePessoasCompartilhamAnuncio(qtdePessoasVisualizamClicamAnuncio);
			
			double qtdeNovasVisualizacoesGeradas = 
					calculaQtdeNovasVisualizacoesGeradas(qtdePessoasCompartilhamAnuncio);
			System.out.println("Qtde de Visualizações Geradas no " + i + "º compartilhamento: " + (int)
					qtdeNovasVisualizacoesGeradas);
			
			qtdePessoasVisualizamAnuncioCompartilhado = qtdeNovasVisualizacoesGeradas;
			totalNovasVisualizaçoesGeradas += qtdeNovasVisualizacoesGeradas;
		}
		
		System.out.println("Total Visualizações (Originais + compartilhadas) = " + (int)
				(qtdePessoasVisualizamAnuncioOriginal + totalNovasVisualizaçoesGeradas));
		
	}
	
	/**
	 * Recebe um valor inteiro para gerar cálculos de anúncios online.
	 * Regra: Aceita qualquer dado que o usuário digitar, tentado aproveitar os dados informado e reconhecendo 
	 * 		os caracteres numericos e transformando-os em um número inteiro. 
	 * TRATANDO EXCESSÕES: Se não encontrar nenhum número, é apresentado a MSG "Número não encontrado!" e o valor 
	 * 		retornará como 0 (zero) para finalizar o cálculo. Se o usuário clicar na tecla ESC, a MSG "Campo Nulo. 
	 * 		Assumirá 0 (zero)!" é apresentado e o valor retornará 0 (zero).
	 * 
	 * @param int valor
	 * @return int * Retorna uma valor inteiro
	 * 
	 * Aceita qualquer informação, filtrando para localizar caracteres numericos
	 */
	static int entradaDados() {
		String valorDigitado = JOptionPane.showInputDialog("Digite um valor inteiro");
		validarValorInformado(valorDigitado);
		String valorFiltrado = filtrarValorDigitado(valorDigitado);
		int valor = 0;
		if (validarValorInformado(valorFiltrado)) {
			valor = Integer.parseInt(valorFiltrado);
		}
		return valor;
	}
	
	/**
	 * Filtra o valor digitado.
	 *  
	 * No intúito de se aproveitar o máximo do que o usuário digita, percorre toda a 
	 * String e concatena em outra String os caracteres numéricos encontratos. 
	 * 
	 * @param pValorDigitado
	 * @return String
	 */
	static String filtrarValorDigitado(String pValorDigitado) {
		String valorFiltrado = "";
		for (int i=0; i<pValorDigitado.length(); i++) {
			char meuChar = pValorDigitado.charAt(i);
			if (Character.isDigit(meuChar)) {
				valorFiltrado += meuChar;
			}
		}
		return valorFiltrado;
	}
	
	/**
	 * Valida o valor informado.
	 * 
	 * Valida se o valor não é Nulo.
	 * Se o valor for nulo, apresenta a MSG que o ESC (escape) foi acionado e encerra a Calculadora.
	 * 
	 * @param pValorDigitado
	 * @return boolean
	 */
	static boolean validarValorInformado(String pValorDigitado) {
		if (pValorDigitado != null) {
			String valorFiltrado = filtrarValorDigitado(pValorDigitado);
			if (valorFiltrado != "") {
				return true;
			}
		} else {
			System.out.println("ESC acionado! Calculadora encerrada!");
			System.exit(0);
		}
		return false;
	}
	
	/** 
	 * Calcula a Quantidade de pessoas que visualizam o Anúncio original
	 * Regra: O valor informado peo usuário é multiplicado por 30. "30 pessoas visualizam o 
	 * 			anúncio original (não compartilhado) a cada R$ 1,00 investido."
	 * 
	 * @param pValorInformado
	 * @return int * Retorna a quantidade de pessoas que visualizam o anúncio original
	 */
	static int calculaQtdePessoasVisualizamAnuncioOriginal(int pValorInformado) {
		int qtdePessoasVisualizamAnuncioOriginal = (pValorInformado * 30);
		return qtdePessoasVisualizamAnuncioOriginal;
	}

	/**
	 * Calcula a quantidade de pessoas que visualizam e Clicam no Anúncio.
	 * Regra: calcula a quantidade do parametro por 12%. "a cada 100 pessoas que visualizam o 
	 * 			anúncio 12 clicam nele."
	 * O valor do parâmetro pode vir de um valor original ou de um ciclo de compartilhamento.
	 * 
	 * @param pQtdePessoasVisualizamAnuncio
	 * @return double * Retorna valor arredondado para nenhuma casa decimal.
	 */
	static double calculaQtdePessoasVisualizamClicamAnuncio(double pQtdePessoasVisualizamAnuncio) {
		double valorCalculo = (pQtdePessoasVisualizamAnuncio * 0.12);
		return valorCalculo;
	}
	
	/**
	 * Calcula a quantidade de Pessoas que compartilham o anúncio.
	 * Regra: calcula o valor do parâmetro por 15%. "a cada 20 pessoas que clicam no anúncio 3 compartilham nas redes sociais."
	 * 
	 * @param pQtdePessoasVisualizamClicamAnuncio
	 * @return double * Retorna valor arredondado para nenhuma casa decimal.
	 */
	static double calculaQtdePessoasCompartilhamAnuncio(double pQtdePessoasVisualizamClicamAnuncio) {
		double valorCalculo = (pQtdePessoasVisualizamClicamAnuncio * 0.15);
		return valorCalculo;
	}
	
	/**
	 * Calcula a quantidade de novas visualizações geradas pe compartilhamento.
	 * Regra: calcula o vaslor do parâmetro por 40. "cada compartilhamento nas redes sociais gera 40 novas visualizações."
	 * @param pQtdePessoasCompartilhamAnuncio
	 * @return double * Retorna valor arredondado para nenhuma casa decimal.
	 */
	static double calculaQtdeNovasVisualizacoesGeradas(Double pQtdePessoasCompartilhamAnuncio) {
		double valorCalculo = Math.round(pQtdePessoasCompartilhamAnuncio * 40);
		return valorCalculo;
	}
}

