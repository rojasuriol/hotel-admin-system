package com.maryed.hotel_admin_system.reserva.service;

import com.maryed.hotel_admin_system.exception.ReservaServiceException;
import com.maryed.hotel_admin_system.habitacion.dao.HabitacionDAO;
import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import com.maryed.hotel_admin_system.hotel.dao.HotelDAO;
import com.maryed.hotel_admin_system.hotel.model.Hotel;
import com.maryed.hotel_admin_system.reserva.dao.ReservaDAO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaRequestDTO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaResponseDTO;
import com.maryed.hotel_admin_system.reserva.mapper.ReservaMapper;
import com.maryed.hotel_admin_system.reserva.model.Reserva;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {
    private final ReservaDAO repository;

    @Autowired
    private final HotelDAO hotelRepository;

    @Autowired
    private final HabitacionDAO habitacionRepository;

    private final ReservaMapper mapper;

    @Override
    public List<ReservaResponseDTO> listar(ReservaRequestDTO dto) {
        List<Reserva> reservas = repository.findAll();

        if (reservas.isEmpty()) {
            throw new ReservaServiceException("No existen reservas registradas en el sistema.");
        }

        List<Reserva> filtradas = reservas.stream()
                .filter(r -> dto.getIdHotel() == null ||
                        r.getHabitacion().getHotel().getIdHotel().equals(dto.getIdHotel()))
                .filter(r -> dto.getDNICliente() == null ||
                        r.getCliente().getDni().equalsIgnoreCase(dto.getDNICliente()))
                .filter(r -> dto.getEstado() == null ||
                        r.getEstado().equalsIgnoreCase(dto.getEstado()))
                .toList();

        if (filtradas.isEmpty()) {
            throw new ReservaServiceException("No existen reservas con los filtros especificados.");
        }

        return filtradas.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public ReservaResponseDTO registrar(ReservaRequestDTO dto) {
        Reserva entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public ReservaResponseDTO actualizar(Integer id, ReservaRequestDTO dto) {

        Reserva reserva = repository.findById(id)
                .orElseThrow(() -> new ReservaServiceException("Reserva no encontrada"));

        if (dto.getIdHabitacion() != null) {
            Habitacion habitacion = habitacionRepository.findById(dto.getIdHabitacion())
                    .orElseThrow(() -> new ReservaServiceException("Habitación no encontrada"));
            reserva.setHabitacion(habitacion);
        }

        if (dto.getIdHotel() != null) {
            Hotel hotel = hotelRepository.findById(dto.getIdHotel())
                    .orElseThrow(() -> new ReservaServiceException("Hotel no encontrado"));
            reserva.setHotel(hotel);
        }

        if (dto.getFechaEntrada() != null)
            reserva.setFechaEntrada(dto.getFechaEntrada());

        if (dto.getFechaSalida() != null)
            reserva.setFechaSalida(dto.getFechaSalida());

        if (dto.getTipoReserva() != null)
            reserva.setTipoReserva(dto.getTipoReserva());

        if (dto.getMontoTotal() != null)
            reserva.setMontoTotal(dto.getMontoTotal());

        if (dto.getEstado() != null)
            reserva.setEstado(dto.getEstado());

        Reserva actualizada = repository.save(reserva);
        return mapper.toDTO(actualizada);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        Reserva reserva = repository.findById(id)
                .orElseThrow(() -> new ReservaServiceException("Reserva no encontrada"));
        reserva.setEstado("C");
        repository.save(reserva);
    }
}