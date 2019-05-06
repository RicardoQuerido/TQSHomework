package ua.pt.restapi.scheduling;

import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Ricardo Querido
 */
@Startup
@Singleton
public class FixedTimerBean {
    
    @EJB
    private Scheduling scheduling;
    
    @Lock(LockType.READ)
    @Schedule(minute = "*/5", hour = "*", persistent = false)
    public void atSchedule() throws InterruptedException {
        scheduling.doTimerWork();
    }
    
}
