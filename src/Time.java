/*
 * AP CS MOOC
 * Term 2 - Assignment 4: Time Comparable
 * You can use this solution to Assignment 1 in order to create a comparable time object.
 * You will need to change the class so that it implements the comparable interface.
 */

public class Time implements Comparable {
    private int hour;
    private int minute;

    /*
     * Sets the default time to 12:00.
     */
    public Time() {
        this(12, 0);
    }

    /*
     * Sets hour to h and minute to m.
     */
    public Time(int h, int m) {
        hour = 0;
        minute = 0;
        if (h >= 1 && h <= 23)
            hour = h;
        if (m >= 1 && m <= 59)
            minute = m;

    }

    /*
     * Returns the time as a String of length 4 in the format: 0819.
     */
    public String toString() {

        String h = "";
        String m = "";
        if (hour < 10)
            h += "0";
        if (minute < 10)
            m += "0";
        h += hour;
        m += minute;

        return "" + h + "" + m;
    }

    public int compareTo(Object o) {
        final int less=-1, equal=0, greater=1;

        Time obj = (Time)o;

        if (hour < obj.getHour()) {
            return less;
        }
        else if (hour == obj.getHour()) {
            if (minute < obj.getMinute()) {
                return less;
            }
            else if (minute == obj.getMinute()) {
                return equal;
            }
            else {
                return greater;
            }
        }
        else {
            return greater;
        }
    }

    public String difference(Time time) {
        return String.format("%s:%s", timeDifference(time.getHour(), hour), timeDifference(time.getMinute(), minute));
    }

    private String timeDifference(int first, int second) {
        int value = Math.abs(first - second);

        if (value == 0) {
            return "00";
        }
        else {
            return Integer.toString(value);
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}