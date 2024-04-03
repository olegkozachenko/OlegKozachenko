import java.util.*;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    public void setHours(int hours) {
        if (hours < 0 || hours >= 24) {
            throw new IllegalArgumentException("Недопустимое значение Часов");
        }
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes >= 60) {
            throw new IllegalArgumentException("Недопустимое значение Минут");
        }
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds >= 60) {
            throw new IllegalArgumentException("Недопустимое значение Секунд");
        }
        this.seconds = seconds;
    }

    public void addHours(int hours) {
        int newHours = this.hours + hours;
        setHours(newHours % 24);
    }

    public void addMinutes(int minutes) {
        int newMinutes = this.minutes + minutes;
        int additionalHours = newMinutes / 60;
        setMinutes(newMinutes % 60);
        addHours(additionalHours);
    }

    public void addSeconds(int seconds) {
        int newSeconds = this.seconds + seconds;
        int additionalMinutes = newSeconds / 60;
        setSeconds(newSeconds % 60);
        addMinutes(additionalMinutes);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите часы, минуты, секунды:");
        Time time = new Time(in.nextInt(), in.nextInt(), in.nextInt());



        try {
            System.out.println("Введите часы, минуты, секунды, которые хотите добавить:");
            time.addHours(in.nextInt());
            time.addMinutes(in.nextInt());
            time.addSeconds(in.nextInt());
            System.out.println("Новое время: " + time.hours + ":" + time.minutes + ":" + time.seconds);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}