import java.util.Scanner;


public class Main {

    public static Roman roman = new Roman();


    public static void main(String[] args) throws CalcException {
        System.out.println("Введите математическую операцию +, -, /, * с двумя числами в диапазне [1, 10]");
        System.out.println("Пример:\n10 - 5\nX + X");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();// введем то что хотим посчитать

        System.out.println(calc(input)); // выпускаем Кракена
    }




    public static String calc(String input) throws CalcException {
        String output = null;
        String[] tempStringArray = new String[2];

        MathActCount cnt = new MathActCount(input);
        //принимаем строку, делим на подстроки, ищем знак + - * /
        if(cnt.getSum() == 1){

            if(cnt.getCount("+") == 1 ){
                // удалив лишние пробелы, разделили строку на 2 числа, над которыми проводится вычисление
                tempStringArray = (input.trim()).split("\\+");
                
                //проверим в какой системе счисления будем считать 
                if(roman.isRomanNumber(tempStringArray) == true){// true римская. false арабская
                    //roman
                    tempStringArray = roman.NumToRoman(tempStringArray); // меняем римские на арабские чтоб посчитать
                    int addition = Integer.parseInt(tempStringArray[0].trim()) + Integer.parseInt(tempStringArray[1].trim()); //считаем арабские
                    output = roman.AnswerToRom(addition); // меняем арабский ответ на римский
                    
                }else {
                    //arab
                    // удалив лишние пробелы, преобразовав String в int, выполнили вычисление
                    int addition = Integer.parseInt(tempStringArray[0].trim()) + Integer.parseInt(tempStringArray[1].trim());
                    output = Integer.toString(addition); // обратно преобразовали int в String и засунули в output - переменную,
                    // которую метод calc будет возвращать в main
                    
                } 
                
                //тоже самое делаем и с другими мат.действиями
            } else if(cnt.getCount("-") == 1){

                tempStringArray = (input.trim()).split("-");
                //проверяем сс
                if(roman.isRomanNumber(tempStringArray) == true){
                    //roman
                    tempStringArray = roman.NumToRoman(tempStringArray);
                    if(Integer.parseInt(tempStringArray[0].trim()) < Integer.parseInt(tempStringArray[1].trim())){
                        throw new CalcException("throws Exception //т.к. в римской системе нет отрицательных чисел");
                    }
                    int subtraction =Integer.parseInt(tempStringArray[0].trim()) - Integer.parseInt(tempStringArray[1].trim());
                    if(subtraction < 1){
                        throw new CalcException("throws Exception //т.к. в римской системе счисления нет нуля");
                    }
                    output = roman.AnswerToRom(subtraction);
                    
                } else {
                    //arab
                    int subtraction =Integer.parseInt(tempStringArray[0].trim()) - Integer.parseInt(tempStringArray[1].trim());
                    output = Integer.toString(subtraction); 
                }
                

            } else if(cnt.getCount("*") == 1){

                tempStringArray = (input.trim()).split("\\*");
                //проверяем сс
                if(roman.isRomanNumber(tempStringArray) == true){
                    //roman
                    tempStringArray = roman.NumToRoman(tempStringArray);
                    int multiplication = Integer.parseInt(tempStringArray[0].trim()) * Integer.parseInt(tempStringArray[1].trim());
                    output = roman.AnswerToRom(multiplication);

                }else{
                    //arab
                    int multiplication = Integer.parseInt(tempStringArray[0].trim()) * Integer.parseInt(tempStringArray[1].trim());
                    output = Integer.toString(multiplication);
                }
                
                

            } else if(cnt.getCount("/") == 1){
                
                tempStringArray = (input.trim()).split("/");
                //проверяем сс
                if(roman.isRomanNumber(tempStringArray) == true){
                    //roman
                    tempStringArray = roman.NumToRoman(tempStringArray);
                    int devision = Integer.parseInt(tempStringArray[0].trim()) / Integer.parseInt(tempStringArray[1].trim());
                    if(devision < 1){
                        throw new CalcException("throws Exception //т.к. в римской системе счисления нет нуля");
                    }
                    output = roman.AnswerToRom(devision);

                }else {
                    //arab
                    int devision = Integer.parseInt(tempStringArray[0].trim()) / Integer.parseInt(tempStringArray[1].trim());
                    output = Integer.toString(devision);
                }
                
                
                
            } else {
                System.out.println("если вы читаете это, то в программе полный пиздец, по моему, потому что сюда невозможно попасть");

            }
        } else if (cnt.getSum() > 1) {
            throw new CalcException("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if(cnt.getSum() == 0){
            throw new CalcException("throws Exception //т.к. строка не является математической операцией");
        }

        int a = Integer.parseInt(tempStringArray[0].trim());
        int b = Integer.parseInt(tempStringArray[1].trim());
        if((a > 10) || (a < 1) || (b > 10) || (b < 1) == true){
            throw new CalcException("throws Exception //т.к. формат математической операции не удовлетворяет заданию -  допустимые значения операндов [1; 10]");
        }


        return output;
    }

}
