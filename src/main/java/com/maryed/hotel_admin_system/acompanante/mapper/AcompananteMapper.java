package com.maryed.hotel_admin_system.acompanante.mapper;

import com.maryed.hotel_admin_system.acompanante.dto.AcompananteResponseDTO;
import com.maryed.hotel_admin_system.acompanante.dto.AcompananteRequestDTO;
import com.maryed.hotel_admin_system.acompanante.model.Acompanante;
import org.springframework.stereotype.Component;

@Component
public class AcompananteMapper {

        public Acompanante toEntity(AcompananteRequestDTO dto) {
            Acompanante entity = new Acompanante();
            entity.setDni(dto.getDni());
            return entity;
        }

        public AcompananteResponseDTO toDTO(Acompanante entity) {
            AcompananteResponseDTO dto = new AcompananteResponseDTO();
            dto.setIdAcompanante(entity.getIdAcompanante());
            dto.setDni(entity.getDni());
            dto.setIdReserva(entity.getReserva().getIdReserva());
            return dto;
        }
    }

