package dev.siraev.models;

public enum Permission {
    GAMES_READ("games:read"),
    GAMES_WRITE("games:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
