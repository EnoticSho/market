package gb.ru.market.entity;

public enum Permission {
    PRODUCTS("products"),
    USERS("users"),
    CREATEUSER("createUser");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
