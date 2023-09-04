package net.therap.iot.db.mapping.dbmapping.db.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.therap.iot.db.mapping.dbmapping.db.inventory.Device;
import net.therap.iot.db.mapping.dbmapping.db.user.Users;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author duity
 * @author sumitchowdhury
 * @since 5/9/22
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class DeviceData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "deviceDataSeq", sequenceName = "deviceDataSeq", allocationSize = 1)
    @GeneratedValue(generator = "deviceDataSeq")
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated")
    private Date updated;

    @ManyToOne
    private Device device;

    @ManyToOne
    private Users user;

    @Transient
    private long updatedDateEpoch;

    public DeviceData(Device device) {
        this.device = device;
        this.user = device.getAssignedUser();
        this.updated = new Date();
    }

    public long getUpdatedDateEpoch() {
        return updated.getTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof DeviceData)) {
            return false;
        }

        DeviceData deviceData = (DeviceData) o;

        return Objects.equals(getId(), deviceData.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}