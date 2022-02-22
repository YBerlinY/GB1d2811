package Java2.lesson3.hw3;

public class MyArraySizeException extends RuntimeException{
    private static final String msg="Ошибка! Размер массива: %d на %d";
    public MyArraySizeException(int iL,int jL){
        super(String.format(msg,iL,jL));
    }

}
