package com.maryed.hotel_admin_system.reserva.service;


import com.maryed.hotel_admin_system.reserva.dao.ReservaDAO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaRequestDTO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaResponseDTO;
import com.maryed.hotel_admin_system.reserva.mapper.ReservaMapper;
import com.maryed.hotel_admin_system.reserva.model.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {
    private final ReservaDAO repository;
    private final ReservaMapper mapper;

    //@Override
    public List<ReservaResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

  //  @Override
    public ReservaResponseDTO obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrado"));
    }

/*    @Override
    public List<ReservaResponseDTO> obtenerReservasByDNI(String dniCliente) {
        return repository.findByClienteDni(dniCliente)
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

    }*/

 //   @Override
    public ReservaResponseDTO registrar(ReservaRequestDTO dto) {
        Reserva entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

/*    @Override
    public ReservaResponseDTO actualizar(Integer id, ReservaRequestDTO dto) {
        Reserva habitacion = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrado"));

        habitacion.setIdHotel(dto.getIdHotel());
        habitacion.setNumeroHabitacion(dto.getNumeroHabitacion());
        habitacion.setTipoHabitacion(dto.getTipoHabitacion());
        habitacion.setDescripcionHabitacion(dto.getDescripcionHabitacion());
        habitacion.setEstado(dto.getEstado());
        habitacion.setTiempoReservado(dto.getTiempoReservado());
        return mapper.toDTO(repository.save(habitacion));
    }*/

   // @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}