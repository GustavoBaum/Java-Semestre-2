package Lista09B;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author gusta
 */
public class Movimento {
    private double valor;
    private TipoMovimento tipoMovimento;
    private LocalTime localTime;
    private LocalDate localDate;
    
    public Movimento(double valor, TipoMovimento tipo) {
        this.valor = valor;
        this.tipoMovimento = tipoMovimento;
    }

    private double getValor() {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero");
        }
        return valor;
    }
    
    private TipoMovimento getTipoMovimento(TipoMovimento tipoMovimento) {
        return tipoMovimento;
    }
    
    private LocalTime getLocalTime(LocalTime localTime) {
        return localTime.now();
    }
    
    private LocalDate getLocalDate(LocalDate localDate) {
        return localDate.now();
    }
}
