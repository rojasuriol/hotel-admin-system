package com.maryed.hotel_admin_system.reserva.mapper;

import com.maryed.hotel_admin_system.cliente.dto.ClienteResponseDTO;
import com.maryed.hotel_admin_system.cliente.model.Cliente;
import com.maryed.hotel_admin_system.habitacion.dto.HabitacionResponseDTO;
import com.maryed.hotel_admin_system.habitacion.model.Habitacion;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.model.Hotel;
import com.maryed.hotel_admin_system.reserva.dto.ReservaRequestDTO;
import com.maryed.hotel_admin_system.reserva.dto.ReservaResponseDTO;
import com.maryed.hotel_admin_system.reserva.model.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {

    public Reserva toEntity(ReservaRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Cliente cliente = Cliente.builder().idCliente(dto.getIdCliente()).build();
        Habitacion habitacion = Habitacion.builder().idHabitacion(dto.getIdHabitacion()).build();
        Hotel hotel = Hotel.builder().idHotel(dto.getIdHotel()).build();

        return Reserva.builder()
                .cliente(cliente)
                .habitacion(habitacion)
                .hotel(hotel)
                .fechaEntrada(dto.getFechaEntrada())
                .fechaSalida(dto.getFechaSalida())
                .tipoReserva(dto.getTipoReserva())
                .montoTotal(dto.getMontoTotal())
                .estado(dto.getEstado())
                .build();
    }

    public ReservaResponseDTO toDTO(Reserva entity) {
        if (entity == null) {
            return null;
        }

        ClienteResponseDTO clienteDTO = null;
        if (entity.getCliente() != null) {
            clienteDTO = ClienteResponseDTO.builder()
                    .idCliente(entity.getCliente().getIdCliente())
                    .nombre(entity.getCliente().getNombre())
                    .apellidos(entity.getCliente().getApellidos())
                    .dni(entity.getCliente().getDni())
                    .telefono(entity.getCliente().getTelefono())
                    .build();
        }

        HabitacionResponseDTO habitacionDTO = null;
        if (entity.getHabitacion() != null) {
            habitacionDTO = HabitacionResponseDTO.builder()
                    .idHabitacion(entity.getHabitacion().getIdHabitacion())
                    .numeroHabitacion(entity.getHabitacion().getNumeroHabitacion())
                    .tipoHabitacion(entity.getHabitacion().getTipoHabitacion())
                    .estado(entity.getHabitacion().getEstado())
                    .build();
        }

        HotelResponseDTO hotelDTO = null;
        if (entity.getHotel() != null) {
            hotelDTO = HotelResponseDTO.builder()
                    .idHotel(entity.getHotel().getIdHotel())
                    .nombreHotel(entity.getHotel().getNombreHotel())
                    .direccion(entity.getHotel().getDireccion())
                    .telefono(entity.getHotel().getTelefono())
                    .email(entity.getHotel().getEmail())
                    .build();
        }

        return ReservaResponseDTO.builder()
                .idReserva(entity.getIdReserva())
                .cliente(clienteDTO)
                .habitacion(habitacionDTO)
                .hotel(hotelDTO)
                .fechaEntrada(entity.getFechaEntrada())
                .fechaSalida(entity.getFechaSalida())
                .tipoReserva(entity.getTipoReserva())
                .montoTotal(entity.getMontoTotal())
                .estadoReserva(entity.getEstado())
                .build();
    }
}