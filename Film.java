public abstract class Film implements FilmInformation {
    private String title;
    private int releaseYear;
    private String genre;
    private String director;
    private double price;

    public Film(String title, int releaseYear, String genre, String director, double price) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.director = director;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String getInformation() {
        return "Title: " + getTitle() + "\n" +
                "Release Year: " + getReleaseYear() + "\n" +
                "Genre: " + getGenre() + "\n" +
                "Director: " + getDirector() + "\n" +
                "Price: " + getPrice() + " tenge";
    }
}