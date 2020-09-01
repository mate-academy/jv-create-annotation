package exceptions;

public class NoDaoAnnotationFound extends Exception{
    public NoDaoAnnotationFound(String massage) {
        super(massage);
    }
}
