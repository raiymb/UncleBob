public abstract class Film implements FilmInformation {
    private String title;
    private int releaseYear;
    private String genre;
    private String director;
    private double price;

    public Film(String title, int releaseYear, String genre, String director, double price) {
        setTitle(title);
        setReleaseYear(releaseYear);
        setGenre(genre);
        setDirector(director);
        setPrice(price);
    }

     public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
