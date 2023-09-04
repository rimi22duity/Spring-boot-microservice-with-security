package net.therap.iot.db.mapping.dbmapping.db.enums;

import lombok.Getter;

/**
 * @author sumitchowdhury
 * @since 3/8/23
 */
@Getter
public enum Threshold {

    CONNECTION_TIME_THRESHOLD(60000),
    DATA_CONNECTIVITY_THRESHOLD(10);

    private int value;

    Threshold(int value) {
        this.value = value;
    }
}
