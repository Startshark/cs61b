package objectMethods;

public class Date {
    private final int month;
    private final int day;
    private final int year;

    public Date(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Date uddaDate = (Date) o;
        if (month != uddaDate.month || day != uddaDate.day || year != uddaDate.year) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String date;
        date = "Now it is " + year + "-" 
            + month + "-" + day + ".";
        return date;
    }
}