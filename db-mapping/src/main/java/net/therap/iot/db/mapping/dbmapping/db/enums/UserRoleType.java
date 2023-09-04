package net.therap.iot.db.mapping.dbmapping.db.enums;

/**
 * @author duity
 * @since 5/9/22
 */

public enum UserRoleType {

    USER("User"),
    ADMIN("Admin");

    private String roleString;


    UserRoleType( String roleString) {
        this.roleString = roleString;
    }

    public String getRoleString() {
        return this.roleString;
    }
}
