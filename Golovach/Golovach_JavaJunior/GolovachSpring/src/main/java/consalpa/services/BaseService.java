package consalpa.services;

import org.springframework.stereotype.Component;

@Component
public class BaseService implements mService {

    @Override
    public void serve() {
        System.out.println("BaseService: serve()");
    }
}
