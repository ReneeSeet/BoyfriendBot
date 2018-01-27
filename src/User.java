public class User {
    private long chat_id;
    boolean asked = false;
    boolean stop = false;

    public User(long id) {
        chat_id = id;
    }

    public long getChatId() {
        return chat_id;
    }
    public boolean getAsked() {
        return asked;
    }
    public boolean getStopped() {return stop;}

    public void setAsked(boolean set) {
        asked = set;
    }
    public void setStop(boolean set) {
        stop = set;
    }

}
