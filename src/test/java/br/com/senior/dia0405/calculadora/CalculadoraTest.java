package br.com.senior.dia0405.calculadora;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraTest {

	@Test
	public void testcalculaQtdePessoasVisualizamAnuncioOriginalIgual30vezes() {
		int valorInformado = 1;
		int valorCalculo = valorInformado * 30;
		assertEquals(30, valorCalculo, 0);
	}
	
	@Test
	public void testcalculaQtdePessoasVisualizamAnuncioOriginalDiferenteDe30vezes() {
		int valorInformado = 1;
		int valorCalculo = valorInformado * 30;
		assertNotEquals(31, valorCalculo, 0);
	}
	
	@Test
	public void testCalculaQtdePessoasVisualizamEClicamNoAnuncioIgual12porcento() {
		double qtdePessoasVisualizamAnuncio = 30;
		double valorCalculo = qtdePessoasVisualizamAnuncio * 0.12;
		assertEquals(3.6, valorCalculo, 0.01);
	}
	
	@Test
	public void testCalculaQtdePessoasVisualizamEClicamNoAnuncDiferenteDe12porcento() {
		double qtdePessoasVisualizamAnuncio = 1;
		double valorCalculo = qtdePessoasVisualizamAnuncio * 0.12;
		assertNotEquals(3.61, valorCalculo, 0.01);
	}

	@Test
	public void testCalculaQtdePessoasCompartilhamAnuncioIgual15porcento() {
		double qtdePessoasVisualizamClicamAnuncio = 3.6;
		double valorCalculo = qtdePessoasVisualizamClicamAnuncio * 0.15;
		assertEquals(0.54, valorCalculo, 0.01);
	}
	
	@Test
	public void testCalculaQtdePessoasCompartilhamAnuncioDiferenteDe15porcento() {
		double qtdePessoasVisualizamClicamAnuncio = 3.6;
		double valorCalculo = qtdePessoasVisualizamClicamAnuncio * 0.15;
		assertNotEquals(0.55, valorCalculo, 0.01);
	}
	
	@Test
	public void testcalculaQtdeNovasVisualizacoesGeradasIgual40vezes() {
		double qtdePessoasCompartilhamAnuncio = 0.54;
		double valorCalculo = Math.round(qtdePessoasCompartilhamAnuncio * 40);
		assertEquals(22.0, valorCalculo, 0.01);
	}
	
	@Test
	public void testcalculaQtdeNovasVisualizacoesGeradasDiferenteDe40vezes() {
		double qtdePessoasCompartilhamAnuncio = 0.54;
		double valorCalculo = Math.round(qtdePessoasCompartilhamAnuncio * 40);
		assertNotEquals(21.9, valorCalculo, 0.01);
	}
}
