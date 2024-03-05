package testePolinom;
import org.junit.jupiter.api.Test;
import org.model.Operatii;
import org.model.Polinom;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class OperationsTest {
    @Test
    public void sumaTest(){
        String p1 = "2x^2+4x^4-5x^6";
        String p2 = "3x^2+6x^4";
        Polinom polinom1 = Operatii.parsare(p1);
        Polinom polinom2 = Operatii.parsare(p2);
        assertEquals(Operatii.suma(polinom1,polinom2).printPolinom(), "+5.0X^2+10.0X^4-5.0X^6");
    }

    @Test
    public void diferentaTest(){
        String p1 = "7x^2+4x^3-5x^4+2x^5";
        String p2 = "4x^2+6x^5";
        Polinom polinom1 = Operatii.parsare(p1);
        Polinom polinom2 = Operatii.parsare(p2);
        assertEquals(Operatii.diferenta(polinom1,polinom2).printPolinom(), "+3.0X^2+4.0X^3-5.0X^4-4.0X^5");
    }

    @Test
    public void produsTest(){
        String p1 = "2x^2+3x^3";
        String p2 = "4x^2+6x^5";
        Polinom polinom1 = Operatii.parsare(p1);
        Polinom polinom2 = Operatii.parsare(p2);
        assertEquals(Operatii.produs(polinom1,polinom2).printPolinom(), "+8.0X^4+12.0X^5+12.0X^7+18.0X^8");
    }

    @Test
    public void derivatTest(){
        String p = "-4x^3+6x^4";
        Polinom polinom = Operatii.parsare(p);
        assertEquals(Operatii.derivat(polinom).printPolinom(), "-12.0X^2+24.0X^3");
    }

    @Test
    public void integratTest(){
        String p = "3x^2-5x^4+7x^6";
        Polinom polinom = Operatii.parsare(p);
        assertEquals(Operatii.integrala(polinom).printPolinom(), "+X^3-X^5+X^7");
    }
}
