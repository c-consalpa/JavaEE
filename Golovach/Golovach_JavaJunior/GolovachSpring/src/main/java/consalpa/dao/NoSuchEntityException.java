package consalpa.dao;

public class NoSuchEntityException extends Exception {
    String reason = "";
    public NoSuchEntityException(String s) {
        this.reason = s;
    }
}
