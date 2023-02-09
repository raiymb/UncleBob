public class Drama extends Film {
    private String mainActor;

    public Drama(String title, int releaseYear, String director, double price, String mainActor) {
        super(title, releaseYear, "Drama", director, price);
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