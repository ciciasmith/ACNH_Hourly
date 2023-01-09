package acnh_hourly;

import java.time.LocalTime;
import javafx.util.Duration;
import java.util.Timer;
import java.util.TimerTask;

import java.sql.Time;


public class Player { 

    Weather currentWeather;

    static final int HOURS = 24;

    public Player() {
        currentWeather = Weather.SUNNY;
        setTimer();
    }


    public void play(Weather weather) {
        int hour = hour();

        if (currentWeather != weather) {
            Duration playbackTime;

            playbackTime = currentWeather.tracks.get(hour).getCurrentTime();
            currentWeather.tracks.stop(hour);
            currentWeather = weather;
            weather.tracks.get(hour).setStartTime(playbackTime);;
            //System.out.println("now playing " + currentWeather + " " + hour + " at " + playbackTime.toSeconds() + "seconds");
        }
        weather.tracks.play(hour);
        weather.tracks.get(hour).setStartTime(new Duration(0));
        //clock();
    }

    public void pause() {
        currentWeather.tracks.pause(hour());
    }

    private int hour() {
        return LocalTime.now().getHour();
    }

    
    private Time nextHour() {

        int nextHourInt = LocalTime.now().getHour() + 1;
        LocalTime nextHourTime = LocalTime.of((nextHourInt > 23 ? 0 : nextHourInt), 0, 0);
        //System.out.println(nextHourTime.toString());
        //System.out.println(Time.valueOf(nextHourTime).toString());

        return Time.valueOf(nextHourTime);
    }
    

    /*
    private void clock() {
        Thread clock = new Thread() {
            int hour = hour();
            public void run() {
                try {
                    while(true) {
                        if (hour != hour()) {
                            currentWeather.tracks.stop(hour);
                            hour = hour();
                            currentWeather.tracks.play(hour);
                        }
                        sleep(60000);
                    }
                }
                catch (Exception e) {};
            }
        };
        clock.start();
    }
    */

    private void setTimer() {
        final long hour = 3600000;
        Timer timer = new Timer(true);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                currentWeather.tracks.stop();
                play(currentWeather);
                //this.cancel();
            }
        };

        timer.schedule(task, nextHour(), hour);
    }

}