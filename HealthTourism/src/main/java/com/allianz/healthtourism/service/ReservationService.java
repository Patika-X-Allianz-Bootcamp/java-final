package com.allianz.healthtourism.service;

import com.allianz.healthtourism.database.entity.ReservationEntity;
import com.allianz.healthtourism.database.repository.ReservationRepository;
import com.allianz.healthtourism.mapper.ReservationMapper;
import com.allianz.healthtourism.model.DTO.ReservationDTO;
import com.allianz.healthtourism.model.requestDTO.ReservationRequestDTO;
import com.allianz.healthtourism.util.BaseRepository;
import com.allianz.healthtourism.util.BaseService;
import com.allianz.healthtourism.util.IBaseMapper;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends BaseService<ReservationEntity, ReservationDTO, ReservationRequestDTO,
        ReservationMapper, ReservationRepository> {

    private final ReservationMapper reservationMapper;

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationMapper reservationMapper, ReservationRepository reservationRepository) {
        this.reservationMapper = reservationMapper;
        this.reservationRepository = reservationRepository;
    }

    @Override
    protected ReservationMapper getMapper() {
        return reservationMapper;
    }

    @Override
    protected ReservationRepository getRepository() {
        return reservationRepository;
    }
}
