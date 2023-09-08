package com.waffle.data.models.rest.response.user.root.profile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.waffle.data.models.rest.common.ProfileDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Profile public response dto.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ProfilePublicResponseDto extends ProfileDto {

    @Override
    @JsonIgnore
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    @JsonIgnore
    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }
}
