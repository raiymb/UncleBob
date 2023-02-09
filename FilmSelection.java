import java.util.Scanner;

public class FilmSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            Login login = new Login(username, password);
            if (!login.login()) {
                System.out.println("Invalid username or password.");
                return;
            }
        } else if (choice == 2) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            Register register = new Register(username, password);
            if (!register.register()) {
                System.out.println("Username already taken. Please try again.");
                return;
            } else {
                System.out.println("Registration successful.");
            }
        }

        Information filmInformation = new Information();

        filmInformation.addFilm(new Horror("The Shining", 1980, "Stanley Kubrick", 1000, "Jack Nicholson"));
        filmInformation.addFilm(new Comedy("My name is Kozha",1963, "Abdulla Karsakbayev", 2000, "Nurlan Sanjar"));
        filmInformation.addFilm(new Romance("Titanic", 1997, "James Cameron", 1200, "Leonardo DiCaprio"));
        filmInformation.addFilm(new Action("Nobody", 2021, "Ilya Naishuller", 1350, "Bob Odenkirk"));
        filmInformation.addFilm(new Drama("King Richard", 2021 ,
                "Reinaldo Marcus Green", 1700, "Will Smith"));
        filmInformation.addFilm(new Drama("Make it in 18 seconds", 2023, "Industrial Development Fund", 1450, "Maksat"));
        filmInformation.addFilm(new Fantasy("The Hobbit: An Unexpected Journey",2012,
                "Peter Jackson", 1500, "Martin Freeman"));

        System.out.println("Select a film:");
        int i = 1;
        for (Film film : filmInformation.getFilms()) {
            System.out.println(i + ". " + film.getTitle());
            i++;
        }

        System.out.print("Enter film number: ");
        int filmNumber = scanner.nextInt();
        Film selectedFilm = filmInformation.getFilms().get(filmNumber - 1);
        System.out.println(selectedFilm.getInformation());
    }
}