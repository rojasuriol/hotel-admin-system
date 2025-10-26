package com.maryed.hotel_admin_system.hotel.service;

import com.maryed.hotel_admin_system.exception.HabitacionServiceException;
import com.maryed.hotel_admin_system.exception.HotelServiceException;
import com.maryed.hotel_admin_system.hotel.dao.HotelDAO;
import com.maryed.hotel_admin_system.hotel.dto.HotelRequestDTO;
import com.maryed.hotel_admin_system.hotel.dto.HotelResponseDTO;
import com.maryed.hotel_admin_system.hotel.mapper.HotelMapper;
import com.maryed.hotel_admin_system.hotel.model.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelDAO repository;
    private final HotelMapper mapper;

    @Override
    public List<HotelResponseDTO> listar() {
        List<Hotel> hotels;
        hotels = repository.findAll();
        if (hotels.isEmpty()) {
            throw new HabitacionServiceException("No existen hoteles registradas en el sistema.");
        }
        return hotels.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public HotelResponseDTO obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new HotelServiceException("Hotel no encontrado"));
    }

    @Override
    public HotelResponseDTO registrar(HotelRequestDTO dto) {
        Hotel entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public HotelResponseDTO actualizar(Integer id, HotelRequestDTO dto) {
        Hotel hotel = repository.findById(id)
                .orElseThrow(() -> new HotelServiceException("Hotel no encontrado"));

        hotel.setNombreHotel(dto.getNombreHotel());
        hotel.setDireccion(dto.getDireccion());
        hotel.setTelefono(dto.getTelefono());
        hotel.setEmail(dto.getEmail());

        return mapper.toDTO(repository.save(hotel));
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
