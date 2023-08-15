package ru.practicum.shareit.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class GetBookingUserDto {
    private Long id;
}