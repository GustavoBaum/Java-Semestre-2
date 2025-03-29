/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import Lista09A.ContaEspecial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gusta
 */
public class TesteContaEspecial {
    
    private static ContaEspecial e;
    
    @BeforeAll
    public void IniciarTeste() {
        e = new ContaEspecial();
    }
    
    @Test
    public void teste1() {
    e.setLimiteCredito(100);
    e.depositar(20);
    e.sacar(50);
    assertEquals(e.getSaldo(), -30,00);
    }
    
    @Test
    public void teste2() {
    e.setLimiteCredito(100);
    e.depositar(20);
    e.sacar(120);
    assertEquals(e.getSaldo(), -100,00);
    }
    
    /*@Test
    public void teste3() {
    e.setLimiteCredito(100);
    e.depositar(20);    
    e.sacar(120.01);
    assertEquals(e.getSaldo(), IllegalArgumentException(""));
    }
    */
}
