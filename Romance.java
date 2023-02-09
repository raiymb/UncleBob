public class Romance extends Film {
    private String mainActor;

    public Romance(String title, int releaseYear, String director, double price, String mainActor) {
        super(title, releaseYear, "Romance", director, price);
        this.mainActor = mainActor;
    }

    public String getMainActor() {
        return mainActor;
    }

    @Override
    public String getInformation() {
        return super.getInformation() + "\n" +
                "Main Actor: " + getMainActor();
    }
}
