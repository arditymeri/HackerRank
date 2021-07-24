package fifthstar;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HalloweenSaleTest {

    @Test
    void howManyGames() {
        int g1 = HalloweenSale.howManyGames(20, 3, 6, 70);
        assertEquals(5, g1);

        int g2 = HalloweenSale.howManyGames(20, 3, 6, 80);
        assertEquals(6, g2);

    }
}