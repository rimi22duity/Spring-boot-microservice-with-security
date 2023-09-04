package net.therap.iot.db.mapping.dbmapping.db.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import net.therap.iot.db.mapping.dbmapping.db.data.DeviceData;
import net.therap.iot.db.mapping.dbmapping.db.enums.UserRoleType;
import net.therap.iot.db.mapping.dbmapping.db.inventory.Device;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
@Table( name = "users",
        uniqueConstraints = {
            @UniqueConstraint(name = "uk_user_id", columnNames = {"user_id"}),
            @UniqueConstraint(name = "uk_user_name", columnNames = {"user_name"}),
            @UniqueConstraint(name = "uk_email", columnNames = {"email"})
})
@Entity
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "userSeq", sequenceName = "userSeq", allocationSize = 1)
    @GeneratedValue(generator = "userSeq")
    private long id;

    @Column(name = "user_id")
    private String userId;

    @NotNull
    @Column(name = "user_name")
    @Size(min = 8, message = "Username's size cannot be less than 8 characters.")
    private String userName;

    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "password")
    private String password;

    @Size(min = 24, max = 24)
    @Column(name = "access_token")
    private String accessToken;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRoleType role;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "created_date")
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;

    @Column(name = "refresh_url")
    private String refreshUrl;

    @OneToMany(mappedBy = "assignedUser")
    @JsonIgnore
    private List<Device> assignedDeviceList;

    @OneToMany(mappedBy = "createdByUser")
    @JsonIgnore
    private List<Device> createdDeviceList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<DeviceData> deviceDataList;

    @Transient
    @JsonIgnore
    private String confirmPassword;

    @Transient
    @JsonIgnore
    private String adminSecretKey;

    public Users() {
        assignedDeviceList = new ArrayList<>();
        createdDeviceList = new ArrayList<>();
        deviceDataList = new ArrayList<>();
    }

    @JsonIgnore
    public boolean isAdmin() {
        return this.role.getRoleString().equals("Admin");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Users)) {
            return false;
        }

        Users user = (Users) o;

        return Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}