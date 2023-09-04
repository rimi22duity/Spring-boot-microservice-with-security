package net.therap.iot.db.mapping.dbmapping.db.data;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import net.therap.iot.db.mapping.dbmapping.db.enums.DeviceStatus;
import net.therap.iot.db.mapping.dbmapping.db.inventory.Device;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

import static net.therap.iot.db.mapping.dbmapping.db.enums.DeviceStatus.UNASSIGNED;

/**
 * @author duity
 * @author sumitchowdhury
 * @since 5/9/22
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class SmartPlugData extends DeviceData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_status")
    private DeviceStatus deviceStatus;

    @NotNull
    @Column(name = "current_amp",
            columnDefinition = "NUMBER(10,2)",
            precision = 6,
            scale = 2)
    private double currentAmp;

    public SmartPlugData(Device device) {
        super(device);
        this.currentAmp = 0.0;
        this.deviceStatus = UNASSIGNED;
    }
}