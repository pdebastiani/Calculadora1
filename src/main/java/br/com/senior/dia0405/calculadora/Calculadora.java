package br.com.senior.dia0405.calculadora;

import javax.swing.JOptionPane;

/**
 * 
 * @author Paulo Sergio Debastiani - paulo.s.debastiani@gmail.com
 *
 * Calculadora de An�ncios Online
 * 
  		a cada 100 pessoas que visualizam o an�ncio 12 clicam nele.
 		a cada 20 pessoas que clicam no an�ncio 3 compartilham nas redes sociais.
 		cada compartilhamento nas redes sociais gera 40 novas visualiza��es.
 		30 pessoas visualizam o an�ncio original (n�o compartilhado) a cada R$ 1,00
 		investido.
 		o mesmo an�ncio � compartilhado no m�ximo 4 vezes em sequ�ncia
 		(1a pessoa - compartilha - 2a pessoa - compartilha - 3a pessoa - compartilha -
 		4a pessoa)
 		Crie um script em sua linguagem de programa��o preferida que receba o valor investido em
 		reais e retorne uma proje��o aproximada da quantidade m�xima de pessoas que
 		visualizar�o o mesmo an�ncio (considerando o an�ncio original + os compartilhamentos)
 * 
 */
public class Calculadora {

	public static void main(String[] args) {
				
		int valorInformado = entradaDados();
		System.out.println("Voc� digitou " + valorInformado + " Reais investidos");
		
		int qtdePessoasVisualizamAnuncioOriginal = 	calculaQtdePessoasVisualizamAnuncioOriginal(valorInformado);
		System.out.println("Qtde Pessoas q/visualizam o an�ncio original: " + 
				qtdePessoasVisualizamAnuncioOriginal);
		
		double totalNovasVisualiza�oesGeradas = 0;
		int qtdeCiclosCompartilhamento = 4;
		
		double qtdePessoasVisualizamAnuncioCompartilhado = qtdePessoasVisualizamAnuncioOriginal;
		
		/**
		 * Este FOR repete os ciclos de compartilhamento conforme a variavel qtdeCiclosCompartilhamento
		 * 
		 * Regra: "o mesmo an�ncio � compartilhado no m�ximo 4 vezes em sequ�ncia (1a pessoa -> compartilha -> 
		 * 		2a pessoa -> compartilha - > 3a pessoa -> compartilha -> 4a pessoa)"
		 */
		for (int i = 1; i<=qtdeCiclosCompartilhamento; i++) {
			double qtdePessoasVisualizamClicamAnuncio = 
					calculaQtdePessoasVisualizamClicamAnuncio(qtdePessoasVisualizamAnuncioCompartilhado);
			
			double qtdePessoasCompartilhamAnuncio = 
					calculaQtdePessoasCompartilhamAnuncio(qtdePessoasVisualizamClicamAnuncio);
			
			double qtdeNovasVisualizacoesGeradas = 
					calculaQtdeNovasVisualizacoesGeradas(qtdePessoasCompartilhamAnuncio);
			System.out.println("Qtde de Visualiza��es Geradas no " + i + "� compartilhamento: " + (int)
					qtdeNovasVisualizacoesGeradas);
			
			qtdePessoasVisualizamAnuncioCompartilhado = qtdeNovasVisualizacoesGeradas;
			totalNovasVisualiza�oesGeradas += qtdeNovasVisualizacoesGeradas;
		}
		
		System.out.println("Total Visualiza��es (Originais + compartilhadas) = " + (int)
				(qtdePessoasVisualizamAnuncioOriginal + totalNovasVisualiza�oesGeradas));
		
	}
	
	/**
	 * Recebe um valor inteiro para gerar c�lculos de an�ncios online.
	 * Regra: Aceita qualquer dado que o usu�rio digitar, tentado aproveitar os dados informado e reconhecendo 
	 * 		os caracteres numericos e transformando-os em um n�mero inteiro. 
	 * TRATANDO EXCESS�ES: Se n�o encontrar nenhum n�mero, � apresentado a MSG "N�mero n�o encontrado!" e o valor 
	 * 		retornar� como 0 (zero) para finalizar o c�lculo. Se o usu�rio clicar na tecla ESC, a MSG "Campo Nulo. 
	 * 		Assumir� 0 (zero)!" � apresentado e o valor retornar� 0 (zero).
	 * 
	 * @param int valor
	 * @return int * Retorna uma valor inteiro
	 * 
	 * Aceita qualquer informa��o, filtrando para localizar caracteres numericos
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
	 * No int�ito de se aproveitar o m�ximo do que o usu�rio digita, percorre toda a 
	 * String e concatena em outra String os caracteres num�ricos encontratos. 
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
	 * Valida se o valor n�o � Nulo.
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
	 * Calcula a Quantidade de pessoas que visualizam o An�ncio original
	 * Regra: O valor informado peo usu�rio � multiplicado por 30. "30 pessoas visualizam o 
	 * 			an�ncio original (n�o compartilhado) a cada R$ 1,00 investido."
	 * 
	 * @param pValorInformado
	 * @return int * Retorna a quantidade de pessoas que visualizam o an�ncio original
	 */
	static int calculaQtdePessoasVisualizamAnuncioOriginal(int pValorInformado) {
		int qtdePessoasVisualizamAnuncioOriginal = (pValorInformado * 30);
		return qtdePessoasVisualizamAnuncioOriginal;
	}

	/**
	 * Calcula a quantidade de pessoas que visualizam e Clicam no An�ncio.
	 * Regra: calcula a quantidade do parametro por 12%. "a cada 100 pessoas que visualizam o 
	 * 			an�ncio 12 clicam nele."
	 * O valor do par�metro pode vir de um valor original ou de um ciclo de compartilhamento.
	 * 
	 * @param pQtdePessoasVisualizamAnuncio
	 * @return double * Retorna valor arredondado para nenhuma casa decimal.
	 */
	static double calculaQtdePessoasVisualizamClicamAnuncio(double pQtdePessoasVisualizamAnuncio) {
		double valorCalculo = (pQtdePessoasVisualizamAnuncio * 0.12);
		return valorCalculo;
	}
	
	/**
	 * Calcula a quantidade de Pessoas que compartilham o an�ncio.
	 * Regra: calcula o valor do par�metro por 15%. "a cada 20 pessoas que clicam no an�ncio 3 compartilham nas redes sociais."
	 * 
	 * @param pQtdePessoasVisualizamClicamAnuncio
	 * @return double * Retorna valor arredondado para nenhuma casa decimal.
	 */
	static double calculaQtdePessoasCompartilhamAnuncio(double pQtdePessoasVisualizamClicamAnuncio) {
		double valorCalculo = (pQtdePessoasVisualizamClicamAnuncio * 0.15);
		return valorCalculo;
	}
	
	/**
	 * Calcula a quantidade de novas visualiza��es geradas pe compartilhamento.
	 * Regra: calcula o vaslor do par�metro por 40. "cada compartilhamento nas redes sociais gera 40 novas visualiza��es."
	 * @param pQtdePessoasCompartilhamAnuncio
	 * @return double * Retorna valor arredondado para nenhuma casa decimal.
	 */
	static double calculaQtdeNovasVisualizacoesGeradas(Double pQtdePessoasCompartilhamAnuncio) {
		double valorCalculo = Math.round(pQtdePessoasCompartilhamAnuncio * 40);
		return valorCalculo;
	}
}

