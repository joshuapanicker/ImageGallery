public class Settings {
    private int speed;
    private String rootDir;
    public static final int SPEED_FAST =   1000; // 2x speed
    public static final int SPEED_NORMAL = 2000; // 1x speed
    public static final int SPEED_SLOW =   4000;

    public Settings() {
        this(SPEED_NORMAL, ".");
    }

    public Settings(int speed, String rootDir) {
        this.speed = speed;
        this.rootDir = rootDir;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public int getSpeed() {
        return speed;
    }
}