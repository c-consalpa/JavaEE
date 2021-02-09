package consalpa.aspects;
import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleProfiler {
    public Object profile(ProceedingJoinPoint call, int id) throws Throwable {
        long t_start = System.currentTimeMillis();
        try {
            return call.proceed();
        } finally {
            long t_end = System.currentTimeMillis();
            System.out.println("Aspect.PROFILER" + call.toShortString() + " called. " + "Delta t: " + (t_end - t_start));
        }
    }
}
