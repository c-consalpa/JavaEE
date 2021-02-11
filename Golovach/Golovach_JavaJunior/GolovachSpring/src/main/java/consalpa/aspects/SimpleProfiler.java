package consalpa.aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleProfiler {

    public Object profile(ProceedingJoinPoint call, long id) throws Throwable {
        System.out.println("in profile:" + id);
        long t_start = System.currentTimeMillis();
        try {
            System.out.println(call.toShortString());
            return call.proceed();
        } finally {
            long t_end = System.currentTimeMillis();
            System.out.println("Aspect.PROFILER" + call.toShortString() + " called. " + "Delta t: " + (t_end - t_start));
        }

    }

    public Object profile_m(JoinPoint joinPoint) {
        System.out.println("profile_m");
        return "123";
    }
}
