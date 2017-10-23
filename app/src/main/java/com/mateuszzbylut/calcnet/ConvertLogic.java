package com.mateuszzbylut.calcnet;


public class ConvertLogic {

    public String decToBin(int dec) {
        return Integer.toBinaryString(dec);
    }

    public String decToOct(int dec) {
        return Integer.toOctalString(dec);
    }

    public String decToHex(int dec) {
        return Integer.toHexString(dec);
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

    public String octToBin(String oct) {
        return Integer.toBinaryString(octToDec(oct));
    }

    public int octToDec(String oct) {
        return Integer.parseInt(oct, 8);
    }

    public String octToHex(String oct) {
        return Integer.toHexString(octToDec(oct));
    }

    public String hexToBin(String hex) {
        return Integer.toBinaryString(hexToDec(hex));
    }

    public int hexToDec(String hex) {
        return Integer.parseInt(hex, 16);
    }

    public String hexToOct(String hex) {
        return Integer.toOctalString(hexToDec(hex));
    }

    public boolean checkBin(String bin) {

        if (bin.matches("-?[0-1]+")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkOct(String oct) {

        if (oct.matches("-?[0-7]+")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkHex(String hex) {
        if (hex.matches("-?[0-9a-fA-F]+")) {
            return true;
        } else {
            return false;
        }
    }
}
