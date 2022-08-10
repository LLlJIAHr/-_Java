public class MathActCount {
    private String inputStr;
    private int actIndex = 0;
    private int count = 0;

    public MathActCount(String inputStr){
        this.inputStr = inputStr;

    }

    public int getCount(String findStr) { //находим индекс самого первного например плюса "+", и в следующий раз
        if(inputStr.indexOf(findStr) != -1) {     // начинаем поиск уже c символа, идущего после этого +, если будут другие плюсы
            while (actIndex != -1) {// берет индекс второго плюса и следующий поиск начинает уже игнорируя второй плюс
                // и так пока плюсы не закончатся
                actIndex = this.inputStr.indexOf(findStr, actIndex); // "+---+ld+"  0   1
                if (actIndex != -1) {
                    count++; // 1   2
                    actIndex++;
                    //actIndex += findStr.length();// чтоб цикл не был бесконечным, к найденому индексу прибавляем длину искомой строки
                }
            }
        } else return 0;
        return count;
    }

    int findIndex(String myElement, String[] someArray){
        int index = 0;
        for(String n: someArray){
            if(myElement == n) return index;
            else index++;
        }
        return index;
    }

    public int getSum(){
        return getCount("+") + getCount("-") + getCount("*") + getCount("/");
    }

}
