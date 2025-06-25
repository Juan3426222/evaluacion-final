package adapter;

public class ExternalTask {
    private String title;
    private int level;

    public ExternalTask(String title, int level) {
        this.title = title;
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public int getLevel() {
        return level;
    }
}