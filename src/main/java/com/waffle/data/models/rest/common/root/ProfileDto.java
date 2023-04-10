package com.waffle.data.models.rest.common.root;

import com.waffle.data.constants.types.common.City;
import com.waffle.data.constants.types.common.TextSize;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * Common class for dto classes of Profile.
 */
@Data
public class ProfileDto {

    @NotEmpty
    @Length(max = TextSize.XS)
    private String username;
    @NotEmpty
    @Length(max = TextSize.XS)
    private String firstName;
    @NotEmpty
    @Length(max = TextSize.XS)
    private String lastName;
    private City city;
}
