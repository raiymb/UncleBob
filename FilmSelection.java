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
            System.out.println("Enter username: ");
            String username = scanner.nextLine();
            System.out.println("Enter password: ");
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

        // Add some sample films
        filmInformation.addFilm(new Horror("The Shining", 1980, "Stanley Kubrick", 1000, "Jack Nicholson"));
        filmInformation.addFilm(new Comedy("Airplane!", 1980, "Jim Abrahams, David Zucker, Jerry Zucker", 2000, "Robert Hays"));
        filmInformation.addFilm(new Romance("Titanic", 1997, "James Cameron", 1200, "Leonardo DiCaprio"));

        // Give the user the opportunity to select a film
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