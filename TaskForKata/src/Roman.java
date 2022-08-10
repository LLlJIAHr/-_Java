public class Roman {
    int[] index = new int[2];
    boolean[] index2 = {false, false};

    private String[] roman = {
                "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

    public boolean isRomanNumber(String[] tempAr) throws CalcException {
        for (int i = 0; i < tempAr.length; i++) {
            tempAr[i] = tempAr[i].trim();
            for (int j = 0; j < roman.length; j++) {

                if (tempAr[i].equals(roman[j])) {  //если число римская то true
                    index2[i] = true;               //если арабска то остается false
                }
            }
        }
        // если разные системы счисления у чисел
        if( ((index2[0] == true) && (index2[1] == false)) || ((index2[0] == false)&&(index2[1] == true))){
            throw new CalcException("throws Exception //т.к. используются одновременно разные системы счисления");
        }
        return index2[0];
    }

    public String AnswerToRom(int answer){

        String arabBecomeRoman = roman[answer];
        return arabBecomeRoman;
    }

    public String[] NumToRoman(String[] tempAr) throws CalcException {

        for (int i = 0; i < tempAr.length; i++) {
            tempAr[i] = tempAr[i].trim();


            if (tempAr[i].equals("I")) {
                tempAr[i] = "1";
            } else if (tempAr[i].equals("II")) {
                tempAr[i] = "2";
            } else if (tempAr[i].equals("III")) {
                tempAr[i] = "3";
            } else if (tempAr[i].equals("IV")) {
                tempAr[i] = "4";
            } else if (tempAr[i].equals("V")) {
                tempAr[i] = "5";
            } else if (tempAr[i].equals("VI")) {
                tempAr[i] = "6";
            } else if (tempAr[i].equals("VII")) {
                tempAr[i] = "7";
            } else if (tempAr[i].equals("VIII")) {
                tempAr[i] = "8";
            } else if (tempAr[i].equals("IX")) {
                tempAr[i] = "9";
            } else if (tempAr[i].equals("X")) {
                tempAr[i] = "10";
            } else {
                throw new CalcException("throws Exception //т.к. формат математической операции не удовлетворяет заданию -  допустимые значения операндов [I; X]");
            }

        }
        return tempAr;
    }
}

