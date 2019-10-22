package exceptions;

import java.util.GregorianCalendar;

public class Date {
    private int day;
    private String month;
    private int year;

    public Date(int day, String month,int year) throws IllegalArgumentException{
        if(year <0){
            throw new IllegalArgumentException();
        }
        if(new GregorianCalendar().isLeapYear(year) && month.equals("Feb") && day >29){
            throw new IllegalArgumentException("Maximal 29 Tage!");
        }
        if(!new GregorianCalendar().isLeapYear(year) && month.equals("Feb") && day >28){
            throw new IllegalArgumentException("Kein Schaltjahr!");
        }
        if((month.equals("Jan") ||month.equals("Mar") || month.equals("Mai") || month.equals("Jul") || month.equals("Aug") || month.equals("Okt")||month.equals("Dez")) && day>31){
            throw  new IllegalArgumentException("Monat kann nur 31 Tage haben!");
        }if((month.equals("Apr") || month.equals("Jun") || month.equals("Sep") || month.equals("Nov"))&& day > 30){
            throw new IllegalArgumentException("Monat kann nur 30 Tage haben!");
        }

        this.day = day;
        this.month = month;
        this.year = year;
    }
}
