package fourthstar;

/**
 * Your local library needs your help! Given the expected and actual return dates for a library book, create a program
 * that calculates the fine (if any). The fee structure is as follows:
 * <p>
 * 1. If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine = 0).
 * 2. If the book is returned after the expected return day but still within the same calendar month and year as
 * the expected return date, fine = 15 x Delta days.
 * 3. If the book is returned after the expected return month but still within the same calendar year as the expected
 * return date, the fine = 500 x Delta months.
 * 4. If the book is returned after the calendar year in which it was expected, there is a fixed fine of 10000.
 * <p>
 * Charges are based only on the least precise measure of lateness. For example, whether a book is
 * due January 1,2017 or December 31, 2017, if it is returned January 1, 2018, that is a year late and the fine
 * would be 10000.
 * <p>
 * #Easy
 */
public class LibraryFine {

    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2) {
            return 10000;
        } else if (m1 > m2) {
            return 500 * (m1 - m2);
        } else if (d1 > d2) {
            return 15 * (d1 - d2);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int fine = libraryFine(9, 6, 2015, 6, 6, 2015);
        System.out.println(fine);

    }
}
