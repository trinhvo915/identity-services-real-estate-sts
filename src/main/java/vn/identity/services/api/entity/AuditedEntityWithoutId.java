package vn.identity.services.api.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;



@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class AuditedEntityWithoutId {

    @Column(name = "CreationTime", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date creationTime;

    @Column(name = "CreatorUserId")
    private String creatorUserId;

    @Column(name = "DeletionTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletionTime;

    @Column(name = "DeletionUserId")
    private String deletionUserId;

    @Column(name = "LastModificationTime")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date lastModificationTime;

    @Column(name = "LastModifierUserId")
    private String lastModifierUserId;

    @Column(name = "IsDeleted", columnDefinition = "bit default 0", nullable = false)
    @Builder.Default
    private Boolean isDeleted = false;

    @PrePersist
    public void defaultValue() {
        if(Objects.isNull(isDeleted)){
            isDeleted = false;
        }
    }

}