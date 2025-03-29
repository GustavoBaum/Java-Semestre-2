/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import furb.funcionario.Funcionario;
import furb.funcionario.Funcionario.FaixaIrpf;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.text.DecimalFormat;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author gusta
 */
public class testFuncionario {
    
    private static Funcionario f;
    private static DecimalFormat df;
    
    @BeforeAll
    public void inicializarSistema() {
    f = new Funcionario(10);
    df = new DecimalFormat("0.00");
    }
    
    @Test
    public void testIdentificarFaixa1() {
    f.setSalario(850);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.PRIMEIRA);
    }
    
    @Test
    public void testIdentificarIRPF1() {
    f.setSalario(850);
    assertEquals(df.format(calcularIrpf()), "0.00");
    }
    
    @Test
    public void testIdentificarFaixa2() {
    f.setSalario(1903.98);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.PRIMEIRA);
    }
    
    @Test
    public void testIdentificarIRPF2() {
    f.setSalario(1903.98);
    assertEquals(df.format(calcularIrpf()), "0,00");
    }
    
    @Test
    public void testIdentificarFaixa3() {
    f.setSalario(1903.98);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.SEGUNDA);
    }
    
    @Test
    public void testIdentificarIRPF3() {
    f.setSalario(1903.98);
    assertEquals(df.format(calcularIrpf()), "0,00");
    }
    
    @Test
    public void testIdentificarFaixa4() {
    f.setSalario(2000);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.SEGUNDA);
    }
    
    @Test
    public void testIdentificarIRPF4() {
    f.setSalario(2000);
    assertEquals(df.format(calcularIrpf()), "7,20");
    }
    
    @Test
    public void testIdentificarFaixa5() {
    f.setSalario(2826.65);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.SEGUNDA);
    }
    
    @Test
    public void testIdentificarIRPF5() {
    f.setSalario(2826.65);
    assertEquals(df.format(calcularIrpf()), "69,20");
    }
    
    @Test
    public void testIdentificarFaixa6() {
    f.setSalario(2826.66);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.TERCEIRA);
    }
    
    @Test
    public void testIdentificarIRPF6() {
    f.setSalario(2826.66);
    assertEquals(df.format(calcularIrpf()), "69,20");
    }
    
    @Test
    public void testIdentificarFaixa7() {
    f.setSalario(3000);
    assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.TERCEIRA);
    }
    
    @Test
    public void testIdentificarIRPF7() {
    f.setSalario(3000);
    assertEquals(df.format(calcularIrpf()), "95,20");
    }
    
    @Test
    public void testIdentificarFaixa8() {
    f.setSalario(3751.05);
    assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.TERCEIRA);
    }
    
    @Test
    public void testIdentificarIRPF8() {
    f.setSalario(3751.05);
    assertEquals(df.format(calcularIrpf()), "207,86");
    }
    
    @Test
    public void testIdentificarFaixa9() {
    f.setSalario(3751.06);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.QUARTA);
    }
    
    @Test
    public void testIdentificarIRPF9() {
    f.setSalario(3751.06);
    assertEquals(df.format(calcularIrpf()), "207,86");
    }
    
    @Test
    public void testIdentificarFaixa10() {
    f.setSalario(4000);
    assertEquals(f.identificarFaixaIrpf(), FaixaIrpf.QUARTA);
    }
    
    @Test
    public void testIdentificarIRPF10() {
    f.setSalario(4000);
    assertEquals(df.format(calcularIrpf()), "263,87");
    }
    
    @Test
    public void testIdentificarFaixa11() {
    f.setSalario(4664.68);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.QUARTA);
    }
    
    @Test
    public void testIdentificarIRPF11() {
    f.setSalario(4664.68);
    assertEquals(df.format(calcularIrpf()), "413,42");
    }
    
    @Test
    public void testIdentificarFaixa12() {
    f.setSalario(4664.69);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.QUINTA);
    }
    
    @Test
    public void testIdentificarIRPF12() {
    f.setSalario(464.69);
    assertEquals(df.format(calcularIrpf()), "413,42");
    }
    
    @Test
    public void testIdentificarFaixa13() {
    f.setSalario(5000);
    assertEquals(f.identificarFaixaIrpf(),FaixaIrpf.QUINTA);
    }
    
    @Test
    public void testIdentificarIRPF13() {
    f.setSalario(5000);
    assertEquals(df.format(calcularIrpf()), "505,64");
    }
    
    @Test //expected=IllegalArgumentException.class
    public void testExcecao() throws Exception {
    f.setSalario(-100);
    }   

    private Object calcularIrpf() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
