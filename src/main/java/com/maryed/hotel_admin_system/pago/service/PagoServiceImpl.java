package com.maryed.hotel_admin_system.pago.service;

import com.maryed.hotel_admin_system.exception.PagoServiceException;
import com.maryed.hotel_admin_system.pago.dao.PagoDAO;
import com.maryed.hotel_admin_system.pago.dto.PagoRequestDTO;
import com.maryed.hotel_admin_system.pago.dto.PagoResponseDTO;
import com.maryed.hotel_admin_system.pago.mapper.PagoMapper;
import com.maryed.hotel_admin_system.pago.model.Pago;
import com.maryed.hotel_admin_system.reserva.dao.ReservaDAO;
import com.maryed.hotel_admin_system.reserva.model.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagoServiceImpl implements PagoService {
    private final PagoDAO repository;
    private final ReservaDAO reservaRepository;
    private final PagoMapper mapper;


    @Override
    public List<PagoResponseDTO> listarPorReserva(Integer idReserva) {
        List<Pago> pagos = repository.findByReservaIdReservaOrderByFechaPagoDesc(idReserva);
        if (pagos.isEmpty()) {
            throw new PagoServiceException("No existen pagos para la reserva con ID " + idReserva);
        }
        return pagos.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PagoResponseDTO> listarPorEstado(String estadoPago) {
        List<Pago> pagos = repository.findByEstadoPago(estadoPago);
        if (pagos.isEmpty()) {
            throw new PagoServiceException("No existen pagos con estado: " + estadoPago);
        }
        return pagos.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PagoResponseDTO obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new PagoServiceException("Pago no encontrado"));
    }

    @Override
    public PagoResponseDTO registrar(PagoRequestDTO dto) {
        Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                .orElseThrow(() -> new PagoServiceException("Reserva no encontrada"));

        if (dto.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
            throw new PagoServiceException("El monto debe ser mayor a cero");
        }

        if (dto.getMetodoPago() == null || dto.getMetodoPago().trim().isEmpty()) {
            throw new PagoServiceException("El método de pago es requerido");
        }

        Pago entity = mapper.toEntity(dto);
        entity.setReserva(reserva);
        Pago nuevoPago = repository.save(entity);
        return mapper.toDTO(nuevoPago);
    }

    @Override
    public PagoResponseDTO actualizar(Integer id, PagoRequestDTO dto) {
        Pago pago = repository.findById(id)
                .orElseThrow(() -> new PagoServiceException("Pago no encontrado"));

        if (dto.getIdReserva() != null) {
            Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                    .orElseThrow(() -> new PagoServiceException("Reserva no encontrada"));
            pago.setReserva(reserva);
        }

        if (dto.getMonto() != null) {
            if (dto.getMonto().compareTo(BigDecimal.ZERO) <= 0) {
                throw new PagoServiceException("El monto debe ser mayor a cero");
            }
            pago.setMonto(dto.getMonto());
        }

        if (dto.getMetodoPago() != null) {
            pago.setMetodoPago(dto.getMetodoPago());
        }

        if (dto.getEstadoPago() != null) {
            pago.setEstadoPago(dto.getEstadoPago());
        }

        Pago actualizado = repository.save(pago);
        return mapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new PagoServiceException("Pago no encontrado para eliminar");
        }
        repository.deleteById(id);
    }


    @Override
    public BigDecimal calcularTotalPagadoPorReserva(Integer idReserva) {
        List<Pago> pagos = repository.findByReservaIdReserva(idReserva);
        return pagos.stream()
                .map(Pago::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}