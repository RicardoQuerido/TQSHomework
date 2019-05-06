package ua.pt.restapi.scheduling;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import ua.pt.restapi.dao.WeatherDAO;
import ua.pt.restapi.models.WeatherForecast;

/**
 *
 * @author Ricardo Querido
 */

@Singleton
public class Scheduling {
     
    @Inject
    WeatherDAO weatherDAO;
    
    private AtomicBoolean busy = new AtomicBoolean(false);
 
    @Lock(LockType.WRITE)
    public void doTimerWork() {
        if (!busy.compareAndSet(false, true)) {
            return;
        }
        try {
            List<WeatherForecast> wf = weatherDAO.getAllWeatherForecast();
            Date data = new Date();
            for (WeatherForecast w : wf) {
                if (data.getTime() - w.getLastRefresh().getTime() >= 60*1000*60) {
                    weatherDAO.deleteWeatherForecast(w);
                }
            }
        } finally {
            busy.set(false);
        }
    }
}
