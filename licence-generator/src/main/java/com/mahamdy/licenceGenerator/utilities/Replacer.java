package com.mahamdy.licenceGenerator.utilities;

public class Replacer {
    public final char[][] alphaNumeric = new char[85][2];

    public Replacer() {
        alphaNumeric[0][0] = 'a';
        alphaNumeric[1][0] = 'b';
        alphaNumeric[2][0] = 'c';
        alphaNumeric[3][0] = 'd';
        alphaNumeric[4][0] = 'e';
        alphaNumeric[5][0] = 'f';
        alphaNumeric[6][0] = 'g';
        alphaNumeric[7][0] = 'h';
        alphaNumeric[8][0] = 'i';
        alphaNumeric[9][0] = 'j';
        alphaNumeric[10][0] = 'k';
        alphaNumeric[11][0] = 'l';
        alphaNumeric[12][0] = 'm';
        alphaNumeric[13][0] = 'n';
        alphaNumeric[14][0] = 'o';
        alphaNumeric[15][0] = 'p';
        alphaNumeric[16][0] = 'q';
        alphaNumeric[17][0] = 'r';
        alphaNumeric[18][0] = 's';
        alphaNumeric[19][0] = 't';
        alphaNumeric[20][0] = 'u';
        alphaNumeric[21][0] = 'v';
        alphaNumeric[22][0] = 'w';
        alphaNumeric[23][0] = 'x';
        alphaNumeric[24][0] = 'y';
        alphaNumeric[25][0] = 'z';
        alphaNumeric[26][0] = '0';
        alphaNumeric[27][0] = '1';
        alphaNumeric[28][0] = '2';
        alphaNumeric[29][0] = '3';
        alphaNumeric[30][0] = '4';
        alphaNumeric[31][0] = '5';
        alphaNumeric[32][0] = '6';
        alphaNumeric[33][0] = '7';
        alphaNumeric[34][0] = '8';
        alphaNumeric[35][0] = '9';

        alphaNumeric[0][1] = '0';
        alphaNumeric[1][1] = '1';
        alphaNumeric[2][1] = '2';
        alphaNumeric[3][1] = '3';
        alphaNumeric[4][1] = '4';
        alphaNumeric[5][1] = '5';
        alphaNumeric[6][1] = '6';
        alphaNumeric[7][1] = '7';
        alphaNumeric[8][1] = '8';
        alphaNumeric[9][1] = '9';
        alphaNumeric[10][1] = 'a';
        alphaNumeric[11][1] = 'b';
        alphaNumeric[12][1] = 'c';
        alphaNumeric[13][1] = 'd';
        alphaNumeric[14][1] = 'e';
        alphaNumeric[15][1] = 'f';
        alphaNumeric[16][1] = 'g';
        alphaNumeric[17][1] = 'h';
        alphaNumeric[18][1] = 'i';
        alphaNumeric[19][1] = 'j';
        alphaNumeric[20][1] = 'k';
        alphaNumeric[21][1] = 'l';
        alphaNumeric[22][1] = 'm';
        alphaNumeric[23][1] = 'n';
        alphaNumeric[24][1] = 'o';
        alphaNumeric[25][1] = 'p';
        alphaNumeric[26][1] = 'q';
        alphaNumeric[27][1] = 'r';
        alphaNumeric[28][1] = 's';
        alphaNumeric[29][1] = 't';
        alphaNumeric[30][1] = 'u';
        alphaNumeric[31][1] = 'v';
        alphaNumeric[32][1] = 'w';
        alphaNumeric[33][1] = 'x';
        alphaNumeric[34][1] = 'y';
        alphaNumeric[35][1] = 'z';
    }

    public Character replaceLetter(Character letter, String Status) {
        if (Status == "Change") {
            for (int i = 0; i < 36; i++) {
                if (alphaNumeric[i][0] == letter) {
                    letter = alphaNumeric[i][1];
                    i = alphaNumeric.length;
                } else if (i == 35) {
                    letter = letter;
                }
            }
        }
        if (Status == "Re-Change") {
            for (int i = 0; i < 36; i++) {
                if (alphaNumeric[i][1] == letter) {
                    letter = alphaNumeric[i][0];
                    i = alphaNumeric.length;
                } else if (i == 35) {
                    letter = letter;
                }
            }
        }
        return letter;
    }
}
