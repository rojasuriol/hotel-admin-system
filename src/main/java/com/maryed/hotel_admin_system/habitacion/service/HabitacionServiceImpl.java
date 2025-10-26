package com.maryed.hotel_admin_system.habitacion.service;


import com.maryed.hotel_admin_system.exception.HabitacionServiceException;
import com.maryed.hotel_admin_system.habitacion.dao.HabitacionDAO;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionRequestDTO;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;
import com.maryed.hotel_admin_system.habitacion.mapper.HabitacionMapper;

import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HabitacionServiceImpl implements HabitacionService {
    private final HabitacionDAO repository;
    private final HabitacionMapper mapper;

    @Override
    public List<HabitacionResponseDTO> listar(Integer idHotel) {
        List<Habitacion> habitaciones;

        if (idHotel != null) {
            habitaciones = repository.findByHotelIdHotel(idHotel);
            if (habitaciones.isEmpty()) {
                throw new HabitacionServiceException("No existen habitaciones registradas para el hotel con ID " + idHotel);
            }
        } else {
            habitaciones = repository.findAll();
            if (habitaciones.isEmpty()) {
                throw new HabitacionServiceException("No existen habitaciones registradas en el sistema.");
            }
        }

        return habitaciones.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HabitacionResponseDTO obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new HabitacionServiceException("Habitacion no encontrado"));
    }

    @Override
    public HabitacionResponseDTO registrar(HabitacionRequestDTO dto) {
        Habitacion entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public HabitacionResponseDTO actualizar(Integer id, HabitacionRequestDTO dto) {
        Habitacion habitacion = repository.findById(id)
                .orElseThrow(() -> new HabitacionServiceException("Habitacion no encontrado"));

       // habitacion.setHotel(dto.getIdHotel());
        habitacion.setNumeroHabitacion(dto.getNumeroHabitacion());
        habitacion.setTipoHabitacion(dto.getTipoHabitacion());
        habitacion.setDescripcionHabitacion(dto.getDescripcionHabitacion());
        habitacion.setEstado(dto.getEstado());
        habitacion.setTiempoReservado(dto.getTiempoReservado());
        return mapper.toDTO(repository.save(habitacion));
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}