

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste AirPlaneTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class AirPlaneTest
{
    /**
     * Construtor default para a classe de teste AirPlaneTest
     */
    public AirPlaneTest()
    {
    }

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testarPrecoSalvador()
    {
        AirPlane airPlane4 = new AirPlane("Salvador");
        assertEquals(3100, airPlane4.price(), 0.1);
    }

    @Test
    public void testarPrecoRJ()
    {
        AirPlane airPlane1 = new AirPlane("Rio de Janeiro");
        assertEquals(1999.99, airPlane1.price(), 0);
    }

}




