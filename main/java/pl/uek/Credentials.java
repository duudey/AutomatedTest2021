package pl.uek;

public class Credentials {

    public static final Credentials ADMIN_PANEL = new Credentials(
            Configuration.INSTANCE.getValue("app.admin.login"),
            Configuration.INSTANCE.getValue("app.admin.password"));

    public static final Credentials FAKE_USER = new Credentials(
            Configuration.INSTANCE.getValue("app.fake.login"),
            Configuration.INSTANCE.getValue("app.fake.password"));

    private String login;
    private String password;

    public Credentials(String login, String password) {
        this.login = login;
        this.password = password;
    }


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
