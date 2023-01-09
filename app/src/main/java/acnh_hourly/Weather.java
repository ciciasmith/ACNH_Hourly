package acnh_hourly;

public enum Weather {
    SUNNY (""),
    RAINY ("Rainy "),
    SNOWY ("Snowy ");

    private String text;
    public PlayerArray tracks;

    private Weather(String s) {
        this.text = s;
        tracks = new PlayerArray(this);
    }

    @Override
    public String toString() {
        return text;
    }

}
