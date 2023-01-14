package dev.siraev.models.auth;

public enum Permission {
    GAMES_READ("games:read"),
    GAMES_WRITE("games:write"),
    GAMES_DELETE("games:delete");
    private final String permission;
    Permission(String permission){
        this.permission = permission;
    }
    public String getPermission(){
        return permission;
    }
}
