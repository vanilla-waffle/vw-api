package com.waffle.services.entity;

import com.waffle.data.entities.admin.VehicleModeration;
import com.waffle.services.common.BasicService;
import com.waffle.services.common.PagingService;

/**
 * Vehicle moderation service.
 */
public interface VehicleModerationService extends
        BasicService<VehicleModeration>,
        PagingService<VehicleModeration> {
}
