package com.waffle.data.entities.admin;

import com.waffle.data.entities.VehiclePassport;
import com.waffle.data.entities.root.ModerationEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vw_vehicles_moderation_requests")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VehicleModeration extends ModerationEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passport_id", nullable = false)
    private VehiclePassport passport;
}
