package consalpa.dao;

public class NoSuchEntityException extends Throwable {
    String reason = "";
    public NoSuchEntityException(String s) {
        this.reason = s;
    }
}
