package Java2.lesson3.hw3;

public class MyArrayDataException extends RuntimeException{
    private static final String msg="Ошибка в поле по индексу arrS[%d][%d]. Неверное значение: %s";
    public MyArrayDataException(int i, int j,String str){
        super(String.format(msg,i,j,str));
    }
}
