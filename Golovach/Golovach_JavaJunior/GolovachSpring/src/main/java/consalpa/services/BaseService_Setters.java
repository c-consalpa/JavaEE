package consalpa.services;

public class BaseService_Setters implements mService {
    private String payload;

    @Override
    public void serve() {
        System.out.println(this);
    }

    public void setPayload(String pld) {
        this.payload = pld;
    }
}
