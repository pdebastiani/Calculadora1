package br.com.senior.dia0405.calculadora;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraTest {
/** 
  	@Test
	public void testSetSobrenomeSemNumero() {
		Aluno aluno = new Aluno();
		try {
			aluno.setSobrenome("Gonçalves");	
		}catch(Exception e) {			
			fail(e.getMessage());
		}
		
		assertNotNull(aluno.getSobrenome());
	}
	
	@Test(expected = Exception.class)
	public void testSetIdadeNegativa() throws Exception{
		Aluno aluno = new Aluno();
		aluno.setIdade(-10);
	}
	
	@Test (expected = Exception.class)
	public void testSetIdadeMaiorQue130() throws Exception{
		Aluno aluno = new Aluno();
		aluno.setIdade(131);
	}
	@Test 
	public void testSetIdadeValida() throws Exception {
		Aluno aluno = new Aluno();
		aluno.setIdade(20);
		assertEquals(20, (int) aluno.getIdade());
	}
	
  	@Test
	public void testOnlyChars() {
		assertTrue(Validators.onlyValidChars("dbsjirfeguwirtbewuigfbreio"));
	}
	
	@Test
	public void testOnlyCharsRecebendoNumeros() {
		assertFalse(Validators.onlyValidChars("dsadsa12233"));
	}

	@Test
	public void testOnlyCharsRecebendoCaracteresEspeciais() {
		assertFalse(Validators.onlyValidChars("fndui..;/.;/"));
	}
	
	@Test
	public void testValidaSeValorEhNull() {
		String valorInformado = null;
		assertNotNull(Calculadora.validarValorInformado(valorInformado));
	}
	*/
	@Test
	public void testTestandoClasseMain() {
		Calculadora calculadora = new Calculadora();
		
	}
	
	@Test
	public void testValidaSeValorEhDiferenteDeNull() {
		String valorInformado = "123abc";
		boolean resultado = Calculadora.validarValorInformado(valorInformado);
		assertNotNull("58dfg", resultado);
	}

	@Test
	public void testCalculaQtdePessoasVisualizamAnuncioOriginalIgual30vezes() {
		int valorInformado = 1;
		int valorCalculo =  Calculadora.calculaQtdePessoasVisualizamAnuncioOriginal(valorInformado);
		assertEquals(30, valorCalculo);
	}
	
	@Test
	public void testCalculaQtdePessoasVisualizamAnuncioOriginalDiferenteDe30vezes() {
		int valorInformado = 1;
		int valorCalculo = Calculadora.calculaQtdePessoasVisualizamAnuncioOriginal(valorInformado);
		assertNotEquals(31, valorCalculo, 0);
	}
	
	@Test
	public void testCalculaQtdePessoasVisualizamEClicamNoAnuncioIgual12porcento() {
		double qtdePessoasVisualizamAnuncio = 30;
		double valorCalculo = Calculadora.calculaQtdePessoasVisualizamClicamAnuncio(qtdePessoasVisualizamAnuncio);
		assertEquals(3.6, valorCalculo, 0.01);
	}
	
	@Test
	public void testCalculaQtdePessoasVisualizamEClicamNoAnuncDiferenteDe12porcento() {
		double qtdePessoasVisualizamAnuncio = 1;
		double valorCalculo = Calculadora.calculaQtdePessoasVisualizamClicamAnuncio(qtdePessoasVisualizamAnuncio);
		assertNotEquals(3.61, valorCalculo, 0.01);
	}

	@Test
	public void testCalculaQtdePessoasCompartilhamAnuncioIgual15porcento() {
		double qtdePessoasVisualizamClicamAnuncio = 3.6;
		double valorCalculo = Calculadora.calculaQtdePessoasCompartilhamAnuncio(qtdePessoasVisualizamClicamAnuncio);
		assertEquals(0.54, valorCalculo, 0.01);
	}
	
	@Test
	public void testCalculaQtdePessoasCompartilhamAnuncioDiferenteDe15porcento() {
		double qtdePessoasVisualizamClicamAnuncio = 3.6;
		double valorCalculo = Calculadora.calculaQtdePessoasCompartilhamAnuncio(qtdePessoasVisualizamClicamAnuncio);
		assertNotEquals(0.55, valorCalculo, 0.01);
	}
	
	@Test
	public void testCalculaQtdeNovasVisualizacoesGeradasIgual40vezes() {
		double qtdePessoasCompartilhamAnuncio = 0.54;
		double valorCalculo = Calculadora.calculaQtdeNovasVisualizacoesGeradas(qtdePessoasCompartilhamAnuncio);
		assertEquals(22.0, valorCalculo, 0.01);
	}
	
	@Test
	public void testCalculaQtdeNovasVisualizacoesGeradasDiferenteDe40vezes() {
		double qtdePessoasCompartilhamAnuncio = 0.54;
		double valorCalculo = Calculadora.calculaQtdeNovasVisualizacoesGeradas(qtdePessoasCompartilhamAnuncio);
		assertNotEquals(21.9, valorCalculo, 0.01);
	}
}
