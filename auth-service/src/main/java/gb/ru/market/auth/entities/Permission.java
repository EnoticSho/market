package gb.ru.market.auth.entities;

public enum Permission {
    VIEW("view"),
    EDITING("editing"),
    USERS("users");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
