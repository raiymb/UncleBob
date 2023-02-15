package com.ab;

import java.util.Scanner;

public class FilmSelection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Film Store! Please, authorize to your account:");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("Enter a number: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
            {
               System.out.print("Enter username: ");
               String username = scanner.nextLine();
               System.out.print("Enter password: ");
               String password = scanner.nextLine();

               Login login = new Login(username, password);
               if (!login.login()) {
                   System.out.println("Invalid username or password.");
                   return;  }
               else {
                   System.out.println("Login successful\n");
               }
               break;
            }
           case 2:
           {
               System.out.print("Enter username: ");
               String username = scanner.nextLine();
               System.out.print("Enter password: ");
               String password = scanner.nextLine();

               Register register = new Register(username, password);
                   if (!register.register()) {
                       System.out.println("Username already taken. Please try again.");
                       return;
                   }
                   else {
                       System.out.println("Registration successful.\n");
                   }
               break;
           }
            default:
                System.out.println("Invalid option, please try again.");
                return;
        }


        FilmList comedy = new FilmList();
        comedy.addFilm(new Comedy("My name is Kozha",1963, "Abdulla Karsakbayev", 2000, "Nurlan Sanjar"));

        FilmList romance = new FilmList();
        romance.addFilm(new Romance("Titanic", 1997, "James Cameron", 1200, "Leonardo DiCaprio"));

        FilmList action = new FilmList();
        action.addFilm(new Action("Nobody", 2021, "Ilya Naishuller", 1350, "Bob Odenkirk"));

        FilmList drama = new FilmList();
        drama.addFilm(new Drama("King Richard", 2021 , "Reinaldo Marcus Green", 1700, "Will Smith"));
        drama.addFilm(new Drama("Make it in 18 seconds", 2023, "Industrial Development Fund", 1450, "Maksat"));

        FilmList fantasy = new FilmList();
        fantasy.addFilm(new Fantasy("The Hobbit: An Unexpected Journey",2012, "Peter Jackson", 1500, "Martin Freeman"));

        FilmList horror = new FilmList();
        horror.addFilm(new Horror("The Shining", 1980, "Stanley Kubrick", 1000, "Jack Nicholson"));

        GenreList genres = new GenreList();
        genres.addGenre(comedy);
        genres.addGenre(romance);
        genres.addGenre(action);
        genres.addGenre(drama);
        genres.addGenre(fantasy);
        genres.addGenre(horror);

        Cart cart = new Cart();

        System.out.println();
        boolean a = true;
        while (a) {
            System.out.println("Select an option");
            System.out.println("1.Check the cart");
            System.out.println("2.Check your balance");
            System.out.println("3.Add money to balance");
            System.out.println("4.Add movie to the cart");
            System.out.println("5.Remove movie from the cart");
            System.out.println("6.Buy the movie/movies");
            System.out.println("7.Exit");
            System.out.print("Select a number: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (choice) {
                case 1: {
                    int i=0;
                    System.out.println("Films in your cart:");
                    if (cart.getCart().size()==0) {
                        System.out.println("Your cart is empty.\n");
                        break;}
                    for(Film film : cart.getCart()) {
                        System.out.println((i+1)+"."+film.getTitle() );
                        i++;
                    }
                    System.out.println("\nSelect on option:");
                    System.out.println("1.Go back");
                    System.out.print("Enter a number:");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    if (choice==1){
                        break;}
                    else {
                        System.out.println("Invalid option, please try again\n");
                        break;}
                }
                case 4: {
                    System.out.println("Select a genre:");
                    System.out.println("1.Comedy");
                    System.out.println("2.Romance");
                    System.out.println("3.Action");
                    System.out.println("4.Drama");
                    System.out.println("5.Fantasy");
                    System.out.println("6.Horror");
                    System.out.print("Write genre number: ");
                    int i = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    if(i>6 || i<1) {
                        System.out.println("Invalid option, please try again\n");
                        break;
                    }

                    System.out.println("Select a film:");
                    int j = 1;
                    for (Film film : genres.getGenres().get(i-1).getFilms()) {
                        System.out.println(j + ". " + film.getTitle());
                        j++;
                    }

                    System.out.print("Enter film number: ");
                    int filmNumber = scanner.nextInt();
                    if(filmNumber>genres.getGenres().get(i-1).getFilms().size()) {
                        System.out.println("\nInvalid option, please try again.\n");
                        break;}
                    Film selectedFilm = genres.getGenres().get(i-1).getFilms().get(filmNumber - 1);
                    System.out.println();
                    System.out.println(selectedFilm.getInformation());
                    System.out.println();
                    System.out.println("1.Add to the cart");
                    System.out.println("2.Go back");
                    System.out.print("Select an option:");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    switch (choice) {
                        case 1 -> {
                            int k = 0;
                            for (Film film : cart.getCart()) {
                                if (selectedFilm.getTitle() == film.getTitle()) {
                                    k++;
                                    System.out.println("This film is already in your cart");
                                    System.out.println();
                                    break;
                                }
                            }
                            if (k == 0) {
                                cart.addToCart(selectedFilm);
                                System.out.println(selectedFilm.getTitle() + " is added to your cart!");
                                System.out.println();
                                continue;
                            }
                            continue;
                        }
                        case 2 -> {
                            continue;
                        }
                    }
                }
                case 5:
                {
                    int i=0;
                    System.out.println("Films in your cart:");
                    if (cart.getCart().size()==0) {
                        System.out.println("Your cart is empty.\n");
                        break;}
                    for(Film film : cart.getCart()) {
                        System.out.println((i+1)+"."+film.getTitle() );
                        i++;
                    }
                    System.out.print("\nSelect the film you want to remove:");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();
                    if (choice > cart.getCart().size()) {
                        System.out.println("\nInvalid option, please try again.\n");
                        break;
                    }
                    Film selectedFilm = cart.getCart().get(choice - 1);
                    cart.removeFromCart(selectedFilm);
                    System.out.println(selectedFilm.getTitle() + " is removed from your cart!");
                    System.out.println();
                    break;

                }
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again.\n");
            }
        }
    }
}
