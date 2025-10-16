package com.maryed.hotel_admin_system.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelResponseDTO {
    private Integer idHotel;
    private String nombreHotel;
    private String direccion;
    private String telefono;
    private String email;
}
