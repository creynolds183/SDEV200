import java.util.GregorianCalendar;

public class MyDateClass {
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        System.out.println(date1.getDay());
        System.out.println(date1.getMonth());
        System.out.println(date1.getYear());

        MyDate date2 = new MyDate(561555550000L); /* this is the largest posible Long possible with EpochDay */
        System.out.println(date2.getDay());
        System.out.println(date2.getMonth());
        System.out.println(date2.getYear());
    }
}

class MyDate{
    private int day;
    private int month;
    private int year;

    public MyDate(){
        GregorianCalendar today = new GregorianCalendar();
        this.day = today.get(GregorianCalendar.DAY_OF_MONTH);
        this.month = today.get(GregorianCalendar.MONTH);
        this.year = today.get(GregorianCalendar.YEAR);
    }

    public MyDate(long elapsedTime) {
		GregorianCalendar date = new GregorianCalendar();
        date.setTimeInMillis(elapsedTime + 1);

        this.day = date.get(GregorianCalendar.DAY_OF_MONTH);
        this.month = date.get(GregorianCalendar.MONTH);
        this.year = date.get(GregorianCalendar.YEAR);
    }

    public MyDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDate(long elapsedTime){
        GregorianCalendar date = new GregorianCalendar(this.day, (this.month + 1), this.year);
        Long time = date.getTimeInMillis();
        date.setTimeInMillis(elapsedTime + time);

        this.day = date.get(GregorianCalendar.DAY_OF_MONTH);
        this.month = date.get(GregorianCalendar.MONTH);
        this.year = date.get(GregorianCalendar.YEAR);

    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }
}