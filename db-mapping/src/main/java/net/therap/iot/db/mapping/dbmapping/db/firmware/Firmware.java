package net.therap.iot.db.mapping.dbmapping.db.firmware;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.therap.iot.db.mapping.dbmapping.db.enums.DeviceType;
import net.therap.iot.db.mapping.dbmapping.db.inventory.DeviceModel;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author duity
 * @author sumitchowdhury
 * @since 5/10/22
 */
@Getter
@Setter
@NoArgsConstructor
@Table
@Entity
public class Firmware implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "firmwareSeq", sequenceName = "firmwareSeq", allocationSize = 1)
    @GeneratedValue(generator = "firmwareSeq")
    private long id;

    @NotNull
    @Column(name = "file_name")
    private String fileName;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private DeviceType deviceType;

    @ManyToOne
    private DeviceModel deviceModel;

    @NotNull
    @Column(name = "version")
    private String version;

    @Lob
    @Column(name = "bin_file")
    private byte[] file;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated")
    private Date updated;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Firmware that = (Firmware) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
