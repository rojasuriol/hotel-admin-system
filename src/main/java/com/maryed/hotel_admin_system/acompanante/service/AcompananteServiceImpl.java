package com.maryed.hotel_admin_system.acompanante.service;

import com.maryed.hotel_admin_system.acompanante.dao.AcompananteDAO;
import com.maryed.hotel_admin_system.acompanante.dto.AcompananteResponseDTO;
import com.maryed.hotel_admin_system.acompanante.dto.AcompananteRequestDTO;
import com.maryed.hotel_admin_system.acompanante.mapper.AcompananteMapper;
import com.maryed.hotel_admin_system.acompanante.model.Acompanante;
import com.maryed.hotel_admin_system.cliente.dao.ClienteDAO;
import com.maryed.hotel_admin_system.cliente.model.Cliente;
import com.maryed.hotel_admin_system.exception.AcompananteServiceException;
import com.maryed.hotel_admin_system.reserva.dao.ReservaDAO;
import com.maryed.hotel_admin_system.reserva.model.Reserva;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcompananteServiceImpl implements AcompananteService {
    private final AcompananteDAO repository;
    private final ReservaDAO reservaRepository;
    private final ClienteDAO clienteRepository;
    private final AcompananteMapper mapper;

    @Override
    public List<AcompananteResponseDTO> listarPorReserva(Integer idReserva) {
        List<Acompanante> acompanantes = repository.findByReservaIdReserva(idReserva);
        if (acompanantes.isEmpty()) {
            throw new AcompananteServiceException("No existen acompañantes para la reserva con ID " + idReserva);
        }
        return acompanantes.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AcompananteResponseDTO registrar(AcompananteRequestDTO dto) {
        Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                .orElseThrow(() -> new AcompananteServiceException("Reserva no encontrada"));

        validarDniNoEsCliente(dto.getDni());

        if (repository.findByDni(dto.getDni()).isPresent()) {
            throw new AcompananteServiceException("El DNI " + dto.getDni() + " ya está registrado como acompañante");
        }

        Acompanante entity = mapper.toEntity(dto);
        entity.setReserva(reserva);
        Acompanante nuevoAcompanante = repository.save(entity);
        return mapper.toDTO(nuevoAcompanante);
    }

    @Override
    public AcompananteResponseDTO actualizar(Integer id, AcompananteRequestDTO dto) {
        Acompanante acompanante = repository.findById(id)
                .orElseThrow(() -> new AcompananteServiceException("Acompañante no encontrado"));


        if (dto.getIdReserva() != null) {
            Reserva reserva = reservaRepository.findById(dto.getIdReserva())
                    .orElseThrow(() -> new AcompananteServiceException("Reserva no encontrada"));
            acompanante.setReserva(reserva);
        }

        if (dto.getDni() != null) {

            validarDniNoEsCliente(dto.getDni());

            Optional<Acompanante> acompananteConMismoDni = repository.findByDni(dto.getDni());
            if (acompananteConMismoDni.isPresent() && !acompananteConMismoDni.get().getIdAcompanante().equals(id)) {
                throw new AcompananteServiceException("El DNI " + dto.getDni() + " ya está registrado en otro acompañante");
            }

            acompanante.setDni(dto.getDni());
        }

        Acompanante actualizado = repository.save(acompanante);
        return mapper.toDTO(actualizado);
    }

    @Override
    public void eliminar(Integer id) {
        if (!repository.existsById(id)) {
            throw new AcompananteServiceException("Acompañante no encontrado para eliminar");
        }
        repository.deleteById(id);
    }

    private void validarDniNoEsCliente(String dni) {
        Optional<Cliente> clienteExistente = clienteRepository.findByDni(dni);
        if (clienteExistente.isPresent()) {
            throw new AcompananteServiceException(
                    "El DNI " + dni + " pertenece a un cliente registrado: " +
                            clienteExistente.get().getNombre() + " " + clienteExistente.get().getApellidos()
            );
        }
    }
}