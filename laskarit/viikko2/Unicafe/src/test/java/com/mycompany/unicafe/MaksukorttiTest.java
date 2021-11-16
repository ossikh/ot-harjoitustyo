package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(11);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void metodiPalauttaaTrueJosRahaa() {
        assertTrue(kortti.otaRahaa(10));
    }

    @Test
    public void metodiPalauttaaFalseJosEiRahaa() {
        assertFalse(kortti.otaRahaa(11));
    }

    @Test
    public void lataaRahaaToimii() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 10.10", kortti.toString());
    }

    @Test
    public void metodiPalauttaaSaldon() {      
        assertEquals(10, kortti.saldo());
    }
}
