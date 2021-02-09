package consalpa.services;

public class BaseServiceWithConstructor implements mService {
    private String value;
    private mService service;
    public BaseServiceWithConstructor(String str, BaseService b_srvc) {
        this.value = str;
        this.service = b_srvc;
    }



    @Override
    public void serve() {
        System.out.println(this);
    }


    @Override
    public String toString() {
        return "BaseServiceWithConstructor{" +
                "value='" + value + '\'' +
                ", service=" + service +
                '}';
    }
}
