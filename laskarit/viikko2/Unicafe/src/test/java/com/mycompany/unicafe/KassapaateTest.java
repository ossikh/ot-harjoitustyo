package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassapaate;
    Maksukortti maksukortti;

    @Before
    public void setUp() {
        kassapaate = new Kassapaate();
    }

    @Test
    public void KassassaOikeaRahamaara() {
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void SyoEdullisestiKateisellaAntaaOikeanVaihtorahan() {
        assertEquals(260, kassapaate.syoEdullisesti(500));
    }

    @Test
    public void SyoEdullisestiKateisellaKasvattaaKassaa() {
        kassapaate.syoEdullisesti(500);
        assertEquals(100240, kassapaate.kassassaRahaa());
    }

    @Test
    public void SyoEdullisestiKateisellaKasvattaaMyytyjenMaaraa() {
        kassapaate.syoEdullisesti(500);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void EiRiittavastiKateistaEdulliseenEiKasvataKassaa() {
        kassapaate.syoEdullisesti(69);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void EiRiittavastiKateistaEdulliseenAntaaRahatTakaisin() {
        assertEquals(69, kassapaate.syoEdullisesti(69));
    }

    @Test
    public void EiRiittavastiKateistaEdulliseenEiKasvataMyytyaMaaraaa() {
        kassapaate.syoEdullisesti(69);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }

    @Test
    public void SyoMaukkaastiKateisellaAntaaOikeanVaihtorahan() {
        assertEquals(100, kassapaate.syoMaukkaasti(500));
    }

    @Test
    public void SyoMaukkaastiKateisellaKasvattaaKassaa() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(100400, kassapaate.kassassaRahaa());
    }

    @Test
    public void SyoMaukkaastiKateisellaKasvattaaMyytyjenMaaraa() {
        kassapaate.syoMaukkaasti(500);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void EiRiittavastiKateistaMaukkaaseenEiKasvataKassaa() {
        kassapaate.syoMaukkaasti(69);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void EiRiittavastiKateistaMaukkaaseenAntaaRahatTakaisin() {
        assertEquals(69, kassapaate.syoMaukkaasti(69));
    }

    @Test
    public void EiRiittavastiKateistaMaukkaaseenEiKasvataMyytyaMaaraaa() {
        kassapaate.syoMaukkaasti(69);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }

    @Test
    public void SyoEdullisestiVeloittaaOikeinKortilta() {
        maksukortti = new Maksukortti(500);
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(260, maksukortti.saldo());
    }

    @Test
    public void SyoEdullisestiKortillaPalauttaaTrue() {
        maksukortti = new Maksukortti(500);
        assertTrue(kassapaate.syoEdullisesti(maksukortti));
    }

    @Test
    public void SyoEdullisestiKortillaPalauttaaFalse() {
        maksukortti = new Maksukortti(69);        
        assertFalse(kassapaate.syoEdullisesti(maksukortti));
    }

    @Test
    public void SyoEdullisestiEiVeloitaKortiltaJosEiTarpeeksiSaldoa() {
        maksukortti = new Maksukortti(69);
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(69, maksukortti.saldo());
    }
    
    @Test
    public void SyoEdullisestiKortillaKasvattaaMyytyjenmaaraa(){
        maksukortti = new Maksukortti(500);
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());                
    }
    
    @Test
    public void SyoEdullisestiEiKasvataMaaraaJosEiSaldoa(){
        maksukortti = new Maksukortti(69);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void SyoEdullisestiKortillaEiKasvataKassaa(){
        maksukortti = new Maksukortti(500);
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void SyoMaukkaastiVeloittaaOikeinKortilta() {
        maksukortti = new Maksukortti(500);
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(100, maksukortti.saldo());
    }

    @Test
    public void SyoMaukkaastiKortillaPalauttaaTrue() {
        maksukortti = new Maksukortti(500);
        assertTrue(kassapaate.syoMaukkaasti(maksukortti));
    }

    @Test
    public void SyoMaukkaastiKortillaPalauttaaFalse() {
        maksukortti = new Maksukortti(69);        
        assertFalse(kassapaate.syoMaukkaasti(maksukortti));
    }

    @Test
    public void SyoMaukkaastiEiVeloitaKortiltaJosEiTarpeeksiSaldoa() {
        maksukortti = new Maksukortti(69);
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(69, maksukortti.saldo());
    }
    
    @Test
    public void SyoMaukkaastiKortillaKasvattaaMyytyjenmaaraa(){
        maksukortti = new Maksukortti(500);
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty()); 
    }
    
    @Test
    public void SyoMaukkaastiEiKasvataMaaraaJosEiSaldoa(){
        maksukortti = new Maksukortti(69);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void SyoMaukkaastiKortillaEiKasvataKassaa(){
        maksukortti = new Maksukortti(500);
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }

    @Test
    public void KortinLatausKasvattaaSaldoa(){
        maksukortti = new Maksukortti(0);
        kassapaate.lataaRahaaKortille(maksukortti, 666);
        assertEquals(666, maksukortti.saldo());
    }
    
    @Test
    public void KortinLatausKasvattaaKassaa(){
        maksukortti = new Maksukortti(0);
        kassapaate.lataaRahaaKortille(maksukortti, 666);
        assertEquals(100666, kassapaate.kassassaRahaa());
    }
    
    @Test
    public void KortilleEiVoiLadataMiinusta(){
        maksukortti = new Maksukortti(0);
        kassapaate.lataaRahaaKortille(maksukortti, -5);
        assertEquals(0, maksukortti.saldo());
    }
    
}
