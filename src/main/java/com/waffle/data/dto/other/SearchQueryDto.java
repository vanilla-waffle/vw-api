package com.waffle.data.dto.other;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Search query dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchQueryDto {
    private List<SearchCriteria> criteria;
}
