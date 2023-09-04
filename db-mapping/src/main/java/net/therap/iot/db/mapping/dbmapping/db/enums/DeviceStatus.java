package net.therap.iot.db.mapping.dbmapping.db.enums;

import lombok.Getter;

/**
 * @author sumitchowdhury
 * @since 3/6/23
 */
@Getter
public enum DeviceStatus {

    PLUGGED(1, "Plugged"),
    UNPLUGGED(2, "Unplugged"),
    DISCONNECTED(3, "Disconnected"),
    UNASSIGNED(4, "Unassigned");

    private final String name;

    private final int code;

    DeviceStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
