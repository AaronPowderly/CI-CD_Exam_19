package ie.atu.cicd1_exam_19.ErrorHandling;

public class DuplicateException  extends RuntimeException{
    private String message;
    private String Field;

    public DuplicateException(String message, String Field)
    {
        this.Field = Field;
    }
    public DuplicateException(String message)
    {
        super(message);
    }

}
