public class Action extends Film {
    private String mainActor;

    public Action(String title, int releaseYear, String director, double price, String mainActor) {
        super(title, releaseYear, "Action", director, price);
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