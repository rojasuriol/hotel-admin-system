package com.maryed.hotel_admin_system.consumo.service;

import com.maryed.hotel_admin_system.consumo.dao.ConsumoDAO;
import com.maryed.hotel_admin_system.consumo.dto.ConsumoRequestDTO;
import com.maryed.hotel_admin_system.consumo.dto.ConsumoResponseDTO;
import com.maryed.hotel_admin_system.consumo.mapper.ConsumoMapper;
import com.maryed.hotel_admin_system.consumo.model.Consumo;
import com.maryed.hotel_admin_system.exception.ConsumoServiceException;
import com.maryed.hotel_admin_system.reserva.dao.ReservaDAO;
import com.maryed.hotel_admin_system.reserva.model.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConsumoServiceImpl implements ConsumoService {
    private final ConsumoDAO repository;
    private final ReservaDAO reservaRepository;
    private final ConsumoMapper mapper;

    @Override
    public List<ConsumoResponseDTO> listarPorReserva(Integer idReserva) {
        List<Consumo> consumos = repository.findByReservaIdReservaOrderByFechaConsumoDesc(idReserva);
        if (consumos.isEmpty()) {
            throw new ConsumoServiceException("No existen consumos para la reserva con ID " + idReserva);
        }
        return consumos.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ConsumoResponseDTO obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ConsumoServiceException("Consumo no encontrado"));
    }

    @Override
    public ConsumoResponseDTO registrar(ConsumoRequestDTO dto) {
        Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                .orElseThrow(() -> new ConsumoServiceException("Reserva no encontrada"));

        if (!"Activa".equals(reserva.getEstado()) && !"Check-in Realizado".equals(reserva.getEstado())) {
            throw new ConsumoServiceException("No se pueden registrar consumos para una reserva " + reserva.getEstado());
        }

        if (dto.getPrecioUnitario().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ConsumoServiceException("El precio unitario debe ser mayor a cero");
        }

        if (dto.getCantidad() <= 0) {
            throw new ConsumoServiceException("La cantidad debe ser mayor a cero");
        }

        Consumo entity = mapper.toEntity(dto);
        entity.setReserva(reserva);
        Consumo nuevoConsumo = repository.save(entity);
        return mapper.toDTO(nuevoConsumo);
    }

    @Override
    public ConsumoResponseDTO actualizar(Integer id, ConsumoRequestDTO dto) {
        Consumo consumo = repository.findById(id)
                .orElseThrow(() -> new ConsumoServiceException("Consumo no encontrado"));

        if (dto.getIdReserva() != null) {
            Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                    .orElseThrow(() -> new ConsumoServiceException("Reserva no encontrada"));
            consumo.setReserva(reserva);
        }

        if (dto.getProducto() != null) {
            consumo.setProducto(dto.getProducto());
        }
        if (dto.getCantidad() != null) {
            consumo.setCantidad(dto.getCantidad());
        }
        if (dto.getPrecioUnitario() != null) {
            consumo.setPrecioUnitario(dto.getPrecioUnitario());
        }

        Consumo actualizado = repository.save(consumo);
        return mapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new ConsumoServiceException("Consumo no encontrado para eliminar");
        }
        repository.deleteById(id);
    }

    @Override
    public BigDecimal calcularTotalConsumosPorReserva(Integer idReserva) {
        List<Consumo> consumos = repository.findByReservaIdReserva(idReserva);
        return consumos.stream()
                .map(Consumo::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}