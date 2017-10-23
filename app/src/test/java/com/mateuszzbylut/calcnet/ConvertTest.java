package com.mateuszzbylut.calcnet;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertTest {

    private static ConvertLogic convertLogic;

    @BeforeClass
    public static void initConverter() {
        convertLogic = new ConvertLogic();
    }

    @Test
    public void whenDecThenConvertToBin() {
        assertEquals(convertLogic.decToBin(14), "1110");
    }

    @Test
    public void whenDecThenCovertToOct() {
        assertEquals(convertLogic.decToOct(23), "27");
    }

    @Test
    public void whenDecThenConvertHex() {
        assertEquals(convertLogic.decToHex(34), "22");
    }

    @Test
    public void whenBinThenConvertToDec() {
        assertEquals(convertLogic.binToDec("10010"), 18);
    }

    @Test
    public void whenBinThenConvertToHex() {
        assertEquals(convertLogic.binToHex("10110100"), "b4");
    }

    @Test
    public void whenBinThenConvertToOct() {
        assertEquals(convertLogic.binToOct("1001101"), "115");
    }

    @Test
    public void whenOctThenConvertToBin() {
        assertEquals(convertLogic.octToBin("14"), "1100");
    }

    @Test
    public void whenOctThenConvertToDec() {
        assertEquals(convertLogic.octToDec("17"), 15);
    }

    @Test
    public void whenOctThenConvertToHex() {
        assertEquals(convertLogic.octToHex("13"), "b");
    }

    @Test
    public void whenHexThenConvertToBin() {
        assertEquals(convertLogic.hexToBin("b"), "1011");
    }

    @Test
    public void whenHexThenConvertToDec() {
        assertEquals(convertLogic.hexToDec("e"), 14);
    }

    @Test
    public void whenHexToConvertToOct() {
        assertEquals(convertLogic.hexToOct("a"), "12");
    }

    @Test
    public void whenInvalidBinThenReturnFalse() {
        assertFalse(convertLogic.checkBin("12"));
    }

    @Test
    public void whenInvalidOctThenReturnFalse() {
        assertFalse(convertLogic.checkOct("18"));
    }

    @Test
    public void whenInvalidHexThenReturnFalse() {
        assertFalse(convertLogic.checkHex("1o1"));
    }
}
