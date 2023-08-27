import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.


        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.getDefault());
        Date date;
        Date date2;
        try {
            date = formatter.parse("22-01-2023 13:00:00");
            date2 = formatter.parse("23-01-2023 13:00:00");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String formattedDateString = formatter.format(date);
        String formattedDateString2 = formatter.format(date2);

        System.out.printf(formattedDateString);

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Ctrl+D to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);
//        }
    }
}