package net.therap.iot.db.mapping.dbmapping.db.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.therap.iot.db.mapping.dbmapping.db.enums.DeviceType;
import net.therap.iot.db.mapping.dbmapping.db.firmware.Firmware;
import net.therap.iot.db.mapping.dbmapping.db.firmware.OtaToken;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author sumitchowdhury
 * @since 6/5/23
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"model_name"}))
@Getter
@Setter
public class DeviceModel {

    @Id
    @SequenceGenerator(name = "deviceModelSeq", sequenceName = "deviceModelSeq", allocationSize = 1)
    @GeneratedValue(generator = "deviceModelSeq")
    private long id;

    @NotNull
    @Column(name = "model_name")
    private String modelName;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private DeviceType deviceType;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated")
    private Date updated;

    @JsonIgnore
    @OneToMany(mappedBy = "deviceModel")
    private List<Device> deviceList;

    @JsonIgnore
    @OneToMany(mappedBy = "deviceModel")
    private List<OtaToken> otaTokenList;

    @JsonIgnore
    @OneToMany(mappedBy = "deviceModel")
    private List<Firmware> firmwareList;

    public DeviceModel() {
        deviceList = new ArrayList<>();
        otaTokenList = new ArrayList<>();
        firmwareList = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof DeviceModel)) {
            return false;
        }

        DeviceModel that = (DeviceModel) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
