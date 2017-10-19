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
}
