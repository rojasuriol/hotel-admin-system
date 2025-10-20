package com.maryed.hotel_admin_system.cliente.service;

import com.maryed.hotel_admin_system.cliente.dao.ClienteDAO;
import com.maryed.hotel_admin_system.cliente.dto.ClientelRequestDTO;
import com.maryed.hotel_admin_system.cliente.dto.ClienteResponseDTO;
import com.maryed.hotel_admin_system.cliente.mapper.ClienteMapper;
import com.maryed.hotel_admin_system.cliente.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    private final ClienteDAO repository;
    private final ClienteMapper mapper;

    @Override
    public List<ClienteResponseDTO> listar(ClientelRequestDTO dto) {
        List<Cliente> clientes = repository.findAll();

        return clientes.stream()
                .filter(c -> dto.getNombre() == null || c.getNombre().toLowerCase().contains(dto.getNombre().toLowerCase()))
                .filter(c -> dto.getApellidos() == null || c.getApellidos().toLowerCase().contains(dto.getApellidos().toLowerCase()))
                .filter(c -> dto.getDni() == null || c.getDni().equalsIgnoreCase(dto.getDni()))
                .filter(c -> dto.getTipoCliente() == null || c.getTipoCliente().equalsIgnoreCase(dto.getTipoCliente()))
                .filter(c -> dto.getTelefono() == null || c.getTelefono().contains(dto.getTelefono()))
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("cliente no encontrado con id: " + id));
    }

    @Override
    public ClienteResponseDTO obtenerPorDni(String dni) {
        return repository.findByDni(dni)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("cliente no encontrado con DNI: ".concat(dni)));
    }

    @Override
    public ClienteResponseDTO registrar(ClientelRequestDTO dto) {
        Cliente entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public ClienteResponseDTO actualizar(Integer id, ClientelRequestDTO dto) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("cliente no encontrado"));

        cliente.setIdCliente(cliente.getIdCliente());
        cliente.setNombre(dto.getNombre());
        cliente.setApellidos(dto.getApellidos());
        cliente.setDni(dto.getDni());
        cliente.setTipoCliente(dto.getTipoCliente().toUpperCase());
        cliente.setTelefono(dto.getTelefono());

        return mapper.toDTO(repository.save(cliente));
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
