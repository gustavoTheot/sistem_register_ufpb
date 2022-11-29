package org;

import org.junit.Test;
import org.sistem.SistemProduct;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    @Test
    public void testRegister() throws ProductAlreadyExistsException {
        SistemProduct s = new SistemProduct();
        assertEquals(true, s.register("1214", "arroz", (float) 4.20, "parbolizado", "12/04/2024"));
        assertEquals(false, s.register("1214", "feijão", (float) 9.20, "preto", "12/09/2023"));
    }

    @Test
    public void testRemove() throws ProductAlreadyExistsException {
        SistemProduct s = new SistemProduct();
        s.register("1214", "arroz", (float) 4.20, "parbolizado", "12/04/2024");
        assertEquals(true, s.removeProduct("1214"));
    }
}
