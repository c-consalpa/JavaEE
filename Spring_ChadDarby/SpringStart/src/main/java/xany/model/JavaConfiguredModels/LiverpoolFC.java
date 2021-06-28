package xany.model.JavaConfiguredModels;

import org.springframework.beans.factory.annotation.Value;

public class LiverpoolFC implements Team {
    @Override
    public String getName() {
        return "Liverpool FC " + champsCount;
    }

    @Value("${foo.champsCnt}")
    private int champsCount;

    @Override
    public String toString() {
        return "LiverpoolFC{" +
                "champsCount=" + champsCount +
                '}';
    }
}
