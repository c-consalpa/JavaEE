package consalpa.services;

public class BaseService implements mService {
    @Override
    public String serve() {
        return new String( "hello");
    }
}
