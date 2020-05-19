
package ew1.ex3;


/**
 *  The class contains a static method that produces a year overview
 *  for any given year, assumed it is given with which day of the week
 *  the year starts and furthermore it is given whether the year is a
 *  leap year, that is, February has 29 days rather than the usual 28
 *  days. [These two pieces of information could be computed as well,
 *  but that is not done in this exercise.]
 *  
 *  @author Jiayu Zhang
 *  @version 2020-05-19

 */
public class Calender{

    /*
     *  LENGTHS_OF_MONTHS is an array containing the standard lengths of the 12 months of the year.
     */
    private static final int[] LENGTHS_OF_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /*
     *  monthString is a two-dimensional array with 12 rows (one for
     *  each month) and in each column we have 6 entries, one for each
     *  of the potentially 6 (partial) weeks of a month.  
     *
     * E.g. for 2018 it will contain for September row 8 a
     * one-dimensional array with the following 6 strings:
     * <pre>
     * {"                   1",
     *  " 2  3  4  5  6  7  8",
     *  " 9 10 11 12 13 14 15",
     *  "16 17 18 19 20 21 22",
     *  "23 24 25 26 27 28 29",
     *  "30                  "}
     * </pre>
     * If the month needs only 4 or 5 strings, the corresponding remaining strings will contain just
     * empty spaces.
     * The array is initialized in the method cal.
     */
    private static String[][] monthString = new String[12][6];

    /*
     *  The string array m contains the headers for the 4 blocks in
     *  the calendary overview.
     */
    private static final String[] m = {
               "      January               February               March      " + "\n",
        "\n" + "       April                  May                   June      " + "\n",
        "\n" + "        July                 August              September    " + "\n",
        "\n" + "      October               November              December    " + "\n"
    };

    /*
     *  The string weekDays contains the days of the week used in each
     *  of the 4 blocks in the calendary overview.
     */
    private static final String weekDays = "Su Mo Tu We Th Fr Sa  Su Mo Tu We Th Fr Sa  " +
        "Su Mo Tu We Th Fr Sa\n";

    /**
     * The method creates an array with 6 strings representing the days in a month.
     * E.g. for 2018 it will contain for September the
     * one-dimensional array with the following 6 strings:
     * <pre>
     * {"                   1",
     *  " 2  3  4  5  6  7  8",
     *  " 9 10 11 12 13 14 15",
     *  "16 17 18 19 20 21 22",
     *  "23 24 25 26 27 28 29",
     *  "30                  "}
     * </pre>
     * @param year The year for which the monthly overview is to be produced.
     * @param month The month for which the monthly overview is to be produced.
     * @param firstDay The first day of the month (with 0 for Su, 1 for Mo, 2 for Tu and so on).
     * @param leapYear If true the year is a leap year and February has 29 days, else it has 28 days.
     * @return A one-dimensional array containing the days per (partial week) for up to 6 partial weeks.
     */
    public static String[] month(int year, int month, int firstDay, boolean leapYear) {
        /* length contains the length of the month. For February of a
         * leap year it is 29, else it is looked up in the
         * LENGTHS_OF_MONTHS array.
         */
        int length;
        if (leapYear && month == 1) {
            length = 29;
        } else {
            length = LENGTHS_OF_MONTHS[month];
        }

        /*
         *  We create a String array for holding the up to 6 (partial)
         *  weeks of the month.
         */
        String[] result = new String[6];

        // The String line will contain the entry for a particular week.
        String line = "";

        // This is the counter for the line number in the result array.
        int lineCounter = 0;

        /* 
         *  For each month there will be 7*6 entries. Starting with
         *  counter 0, ending with 41.
         */
        int counter = 0;
        /*  Before we add an entry for the first of the month, we have
         *  to (potentially) fill the initial entries with empty
         *  spaces. This is done with the first while loop.
         */
        while (counter < firstDay) {
            counter++;
            line += "   ";
        }
        // the first day to be added is: 1.
        int day = 1;

        /*
         *  For each remaining entry in the table we add one day to
         *  the string per entry. Whenever the counter is divisible by
         *  7, a particular line is full and we add it as the next
         *  entry to the result array. Then we start a new line by
         *  re-initializing the line to the empty string.  Note, in
         *  the loop the day and the counter are increased by 1 each
         *  time. 
         */
        while (counter < 42) {
            counter++;
            /* We do not add the day directly, but it is normalized by
             * the dayString method. Furthermore, for days greater
             * than the number of days in a month, the corresponding
             * number is NOT added, but only empty spaces.
             */
            line += dayString(day, length);
            day++;
            if (counter % 7 == 0) {
                result[lineCounter] = line + " ";
                line = "";
                lineCounter++;
            }
        }
        return result;
    }

    /**
     *   The method converts the days (from 1 up to maxDay) in a
     *   standardized form to strings. For numbers greater than the
     *   maxDay only empty spaces are returned.
     *   @param day The day (as day of the months) given as an int to
     *   be displayed in the calander.
     *   @param maxDay The maximal day which is to be displayed. This
     *   is depending on the month 28, 29, 30, or 31.
     *   @return The day as a string followed by an empty space and
     *   for one-digit days also preceeded by an empty space. If the
     *   number in day is bigger than maxDay a string with 4 empty
     *   spaces will be returned.
     */
    public static String dayString(int day, int maxDay) {
        if (day < 10) {
            return " " + day + " ";
        } else if (day <= maxDay) {
            return "" + day + " ";
        } else {
            return "   ";
        }
    }
            
    /**
     *  The method produces a year overview for any given year,
     *  assumed it is given with which day of the week the year starts
     *  and furthermore it is given whether the year is a leap year,
     *  that is, February has 29 days rather than the usual 28
     *  days.
     *  @param year The year for which the overview is to be produced.
     *  @param firstDay The first day of the year given as 0 for Su, 1
     *  for Mo, 2 for Tu, 3 for We, 4 for Th, 5 for Fr, and 6 for Sa.
     *  @param leapYear true if the year is a leap year (that is,
     *  February has 29 days) and false else.
     *  @return On overview of the year, similar to the Linux cal
     *  command.
     */
    public static String cal(int year, int firstDay, boolean leapYear) {
        // We add the year to the top of the string.
        String result = "                            " + year + "\n";

        /*
         *  We represent the months and their weeks in the
         *  two-dimensional array monthString.  For each of the 12
         *  months we represent each of the 6 partial weeks.
         */
        for (int month = 0; month < 12; month++) {
            /* We use an auxilliary variable to avoid recomputing the
             * array for the month.
             */
            String[] aux = month(year, month,
                                 firstDay(year, firstDay, month, leapYear),
                                 leapYear);
            for (int week = 0; week < 6; week++) {
                monthString[month][week] = aux[week];
            }
        }
        /* For each of the 4 blocks we add the information (3 months
         * each block).
         */
        for (int i = 0; i < 4; i++) {
            result += addThreeMonths(i);
        }
        return result;
    }

    /**
     *   The method produces the overview for three months which are
     *   displayed next to each other.
     *   @param beginning This is 0 for the first block (consisting of
     *   January, February, and March); 1 for the second block, and so
     *   on.
     *   @return A string giving an overview of the corresponding
     *   three months.
     */
    public static String addThreeMonths(int beginning) {
        /*
         *  The result starts with the names of the months and the
         *  header of all week days repeated three times.
         */
        String result = m[beginning] + weekDays;
        /*
         *  Week by week we add the information of the three
         *  months. That is, in the double loop, we iterate first by
         *  the weeks and then by the three months under consideration
         *  and add the corresponding information from the monthString
         *  array to the result.
         */
        for (int week = 0; week < 6; week++) {
            for (int month = beginning * 3; month < beginning * 3 + 3; month++) {
                result += monthString[month][week];
            }
            // At the end of a week, a newline is added.
            result += "\n";
        }
        return result;
    }

    /**
     *  The method computes the first day of a month. 0 for Su, 1 for
     *  Mo, 2 for Tu, 3 for We, 4 for Th, 5 for Fr, and 6 for Sa.
     *  @param year The year for which the first day of the month is
     *  to be computed.
     *  @param firstDay The first day of the corresponding year.
     *  @param month The month whose first day is to be computed.
     *  @param leapYear true if the year is a leap year (that is,
     *  February has 29 days), false else.
     *  @return The first day of the month as 0 for Su, 1 for Mo, 2
     *  for Tu, 3 for We, 4 for Th, 5 for Fr, and 6 for Sa.
     */
    public static int firstDay(int year, int firstDay,
                               int month, boolean leapYear) {
        /* 
         *  The method first adds up the first day of the year and the
         *  number of days in all months preceeding the month under
         *  consideration.
         */
        int day = firstDay;
        for (int i = 0; i < month; i++) {
            if (leapYear && i == 1) {
                day += 29;
            } else {
                day += LENGTHS_OF_MONTHS[i];
            }
        }
        /* The day of the week with which the month start is the value
         * modulo 7 (the number of days in a week).
         */
        return day % 7;
    }

    /*
     *  A main method to test the cal method for 2018 with 2018
     *  starting with a Monday, represented by 1, and not being a leap
     *  year.
     */
    public static void main(String[] args) {
        System.out.println(cal(2019, 2, false));
        System.out.println(firstDay(2019, 2, 2, false));
        System.out.println("*************************************************************************");
        System.out.println(cal(2020, 3, true));
    }
}
