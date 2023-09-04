package net.therap.iot.db.mapping.dbmapping.db.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.therap.iot.db.mapping.dbmapping.db.data.DeviceData;
import net.therap.iot.db.mapping.dbmapping.db.enums.DeviceType;
import net.therap.iot.db.mapping.dbmapping.db.user.Users;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author duity
 * @author sumitchowdhury
 * @since May 09, 2022
 */
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"device_mac_address"}))
@Entity
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "deviceSeq", sequenceName = "deviceSeq", allocationSize = 1)
    @GeneratedValue(generator = "deviceSeq")
    private long id;

    @NotNull
    @Pattern(regexp = "^(?:[0-9A-Za-z]{2}[:-]){5}(?:[0-9A-Za-z]{2})$", message = "Pattern doesn't match")
    @Column(name = "device_mac_address", unique = true)
    private String deviceMacAddress;

    @Column(name = "device_name")
    private String deviceName;

    @Column(name = "firmware_version")
    private String firmwareVersion;

    @Column(name = "device_id")
    private String deviceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private DeviceType deviceType;

    @Column(name = "data_sending_topic_name")
    private String dataSendingTopicName;

    @Column(name = "auth_info_topic_name")
    private String authInfoTopicName;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated")
    private Date updated;

    @OneToMany(mappedBy = "device")
    @JsonIgnore
    private List<DeviceData> dataList;

    @ManyToOne
    private Users assignedUser;

    @ManyToOne
    private Users createdByUser;

    @NotNull
    @ManyToOne
    private DeviceModel deviceModel;

    @Transient
    private String adminSecretKey;

    public Device() {
        dataList = new ArrayList<>();
    }

    public void clearAssignedUser() {
        this.assignedUser = null;
    }

    public void clearDeviceName() {
        this.deviceName = null;
    }

    public void clearDataSendingTopic() {
        this.dataSendingTopicName = null;
    }

    public void clearAuthInfoTopic() {
        this.authInfoTopicName = null;
    }

    public void clearFirmwareVersion() {
        this.firmwareVersion = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Device)) {
            return false;
        }

        Device that = (Device) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
