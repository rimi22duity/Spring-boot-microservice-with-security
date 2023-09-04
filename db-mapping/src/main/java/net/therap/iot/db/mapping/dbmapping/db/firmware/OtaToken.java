package net.therap.iot.db.mapping.dbmapping.db.firmware;

import lombok.Getter;
import lombok.Setter;
import net.therap.iot.db.mapping.dbmapping.db.enums.DeviceType;
import net.therap.iot.db.mapping.dbmapping.db.inventory.DeviceModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author sumitchowdhury
 * @since 2/22/23
 */
@Getter
@Setter
@Entity
@Table
public class OtaToken implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "otaTokenSeq", sequenceName = "otaTokenSeq", allocationSize = 1)
    @GeneratedValue(generator = "otaTokenSeq")
    private long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "device_type")
    private DeviceType deviceType;

    @ManyToOne
    private DeviceModel deviceModel;

    @NotNull
    @Size(max = 22)
    @Column(name = "token")
    private String token;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OtaToken otaToken = (OtaToken) o;

        return id == otaToken.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
