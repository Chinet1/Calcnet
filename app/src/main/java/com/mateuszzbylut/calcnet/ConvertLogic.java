package com.mateuszzbylut.calcnet;


public class ConvertLogic {

    public String decToBin(int dec) {
        int a;
        String bin = "";

        while (dec > 0) {
            a = dec % 2;
            bin = a + "" + bin;
            dec = dec/2;
        }
        return bin;
    }


    public int binToDec(String bin) {
        return Integer.parseInt(bin, 2);
    }

    public String binToHex(String bin) {
        return Integer.toHexString(binToDec(bin));
    }

    public String binToOct(String bin) {
        return Integer.toOctalString(binToDec(bin));
    }
}
