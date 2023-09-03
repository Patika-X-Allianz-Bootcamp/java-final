package com.demo.medicaltourismapp.mapper;

import com.demo.medicaltourismapp.database.entity.AppointmentEntity;
import com.demo.medicaltourismapp.database.entity.DoctorEntity;
import com.demo.medicaltourismapp.database.entity.FlightEntity;
import com.demo.medicaltourismapp.database.entity.HospitalEntity;
import com.demo.medicaltourismapp.database.entity.HotelEntity;
import com.demo.medicaltourismapp.model.AppointmentDTO;
import com.demo.medicaltourismapp.model.DoctorDTO;
import com.demo.medicaltourismapp.model.FlightDTO;
import com.demo.medicaltourismapp.model.HospitalDTO;
import com.demo.medicaltourismapp.model.HotelDTO;
import com.demo.medicaltourismapp.model.PageDTO;
import com.demo.medicaltourismapp.model.requestDTO.DoctorRequestDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T21:56:59+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8 (JetBrains s.r.o.)"
)
@Component
public class DoctorMapperImpl implements DoctorMapper {

    @Override
    public DoctorEntity dtoToEntity(DoctorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId( dto.getId() );
        doctorEntity.setUuid( dto.getUuid() );
        doctorEntity.setCreationDate( dto.getCreationDate() );
        doctorEntity.setUpdatedDate( dto.getUpdatedDate() );
        doctorEntity.setHospital( hospitalDTOToHospitalEntity( dto.getHospital() ) );
        doctorEntity.setDoctorSpecialtyEnum( dto.getDoctorSpecialtyEnum() );
        doctorEntity.setAppointmentList( appointmentDTOListToAppointmentEntityList( dto.getAppointmentList() ) );

        return doctorEntity;
    }

    @Override
    public DoctorDTO entityToDto(DoctorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setId( entity.getId() );
        doctorDTO.setUuid( entity.getUuid() );
        doctorDTO.setCreationDate( entity.getCreationDate() );
        doctorDTO.setUpdatedDate( entity.getUpdatedDate() );
        doctorDTO.setHospital( hospitalEntityToHospitalDTO( entity.getHospital() ) );
        doctorDTO.setDoctorSpecialtyEnum( entity.getDoctorSpecialtyEnum() );
        doctorDTO.setAppointmentList( appointmentEntityListToAppointmentDTOList( entity.getAppointmentList() ) );

        return doctorDTO;
    }

    @Override
    public DoctorEntity requestDtoToEntity(DoctorRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId( requestDTO.getId() );
        doctorEntity.setUuid( requestDTO.getUuid() );
        doctorEntity.setCreationDate( requestDTO.getCreationDate() );
        doctorEntity.setUpdatedDate( requestDTO.getUpdatedDate() );
        doctorEntity.setHospital( hospitalDTOToHospitalEntity( requestDTO.getHospital() ) );
        doctorEntity.setDoctorSpecialtyEnum( requestDTO.getDoctorSpecialtyEnum() );
        doctorEntity.setAppointmentList( appointmentDTOListToAppointmentEntityList( requestDTO.getAppointmentList() ) );

        return doctorEntity;
    }

    @Override
    public DoctorRequestDTO entityToRequestDto(DoctorEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DoctorRequestDTO doctorRequestDTO = new DoctorRequestDTO();

        doctorRequestDTO.setId( entity.getId() );
        doctorRequestDTO.setUuid( entity.getUuid() );
        doctorRequestDTO.setCreationDate( entity.getCreationDate() );
        doctorRequestDTO.setUpdatedDate( entity.getUpdatedDate() );
        doctorRequestDTO.setHospital( hospitalEntityToHospitalDTO( entity.getHospital() ) );
        doctorRequestDTO.setDoctorSpecialtyEnum( entity.getDoctorSpecialtyEnum() );
        doctorRequestDTO.setAppointmentList( appointmentEntityListToAppointmentDTOList( entity.getAppointmentList() ) );

        return doctorRequestDTO;
    }

    @Override
    public List<DoctorEntity> requestDtoListToEntityList(List<DoctorRequestDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DoctorEntity> list = new ArrayList<DoctorEntity>( dtoList.size() );
        for ( DoctorRequestDTO doctorRequestDTO : dtoList ) {
            list.add( requestDtoToEntity( doctorRequestDTO ) );
        }

        return list;
    }

    @Override
    public List<DoctorRequestDTO> entityListToRequestDtoList(List<DoctorEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DoctorRequestDTO> list = new ArrayList<DoctorRequestDTO>( entityList.size() );
        for ( DoctorEntity doctorEntity : entityList ) {
            list.add( entityToRequestDto( doctorEntity ) );
        }

        return list;
    }

    @Override
    public List<DoctorEntity> dtoListToEntityList(List<DoctorDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DoctorEntity> list = new ArrayList<DoctorEntity>( dtoList.size() );
        for ( DoctorDTO doctorDTO : dtoList ) {
            list.add( dtoToEntity( doctorDTO ) );
        }

        return list;
    }

    @Override
    public List<DoctorDTO> entityListToDtoList(List<DoctorEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DoctorDTO> list = new ArrayList<DoctorDTO>( entityList.size() );
        for ( DoctorEntity doctorEntity : entityList ) {
            list.add( entityToDto( doctorEntity ) );
        }

        return list;
    }

    @Override
    public DoctorEntity requestDtoToExistEntity(DoctorRequestDTO requestDTO, DoctorEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setId( requestDTO.getId() );
        entity.setUuid( requestDTO.getUuid() );
        entity.setCreationDate( requestDTO.getCreationDate() );
        entity.setUpdatedDate( requestDTO.getUpdatedDate() );
        if ( requestDTO.getHospital() != null ) {
            if ( entity.getHospital() == null ) {
                entity.setHospital( new HospitalEntity() );
            }
            hospitalDTOToHospitalEntity1( requestDTO.getHospital(), entity.getHospital() );
        }
        else {
            entity.setHospital( null );
        }
        entity.setDoctorSpecialtyEnum( requestDTO.getDoctorSpecialtyEnum() );
        if ( entity.getAppointmentList() != null ) {
            List<AppointmentEntity> list = appointmentDTOListToAppointmentEntityList( requestDTO.getAppointmentList() );
            if ( list != null ) {
                entity.getAppointmentList().clear();
                entity.getAppointmentList().addAll( list );
            }
            else {
                entity.setAppointmentList( null );
            }
        }
        else {
            List<AppointmentEntity> list = appointmentDTOListToAppointmentEntityList( requestDTO.getAppointmentList() );
            if ( list != null ) {
                entity.setAppointmentList( list );
            }
        }

        return entity;
    }

    @Override
    public PageDTO<DoctorDTO> pageEntityToPageDTO(Page<DoctorEntity> entityPage) {
        if ( entityPage == null ) {
            return null;
        }

        PageDTO<DoctorDTO> pageDTO = new PageDTO<DoctorDTO>();

        pageDTO.setNumber( entityPage.getNumber() );
        pageDTO.setSize( entityPage.getSize() );
        pageDTO.setTotalPages( entityPage.getTotalPages() );
        pageDTO.setTotalElements( entityPage.getTotalElements() );
        if ( entityPage.hasContent() ) {
            pageDTO.setContent( entityListToDtoList( entityPage.getContent() ) );
        }
        pageDTO.setSort( entityPage.getSort() );

        return pageDTO;
    }

    protected HospitalEntity hospitalDTOToHospitalEntity(HospitalDTO hospitalDTO) {
        if ( hospitalDTO == null ) {
            return null;
        }

        HospitalEntity hospitalEntity = new HospitalEntity();

        hospitalEntity.setId( hospitalDTO.getId() );
        hospitalEntity.setUuid( hospitalDTO.getUuid() );
        hospitalEntity.setCreationDate( hospitalDTO.getCreationDate() );
        hospitalEntity.setUpdatedDate( hospitalDTO.getUpdatedDate() );
        hospitalEntity.setName( hospitalDTO.getName() );
        List<DoctorEntity> list = hospitalDTO.getDoctorList();
        if ( list != null ) {
            hospitalEntity.setDoctorList( new ArrayList<DoctorEntity>( list ) );
        }
        hospitalEntity.setCity( hospitalDTO.getCity() );

        return hospitalEntity;
    }

    protected FlightEntity flightDTOToFlightEntity(FlightDTO flightDTO) {
        if ( flightDTO == null ) {
            return null;
        }

        FlightEntity flightEntity = new FlightEntity();

        flightEntity.setId( flightDTO.getId() );
        flightEntity.setUuid( flightDTO.getUuid() );
        flightEntity.setCreationDate( flightDTO.getCreationDate() );
        flightEntity.setUpdatedDate( flightDTO.getUpdatedDate() );
        flightEntity.setFlightNo( flightDTO.getFlightNo() );
        flightEntity.setCapacity( flightDTO.getCapacity() );
        flightEntity.setFromCity( flightDTO.getFromCity() );
        flightEntity.setToCity( flightDTO.getToCity() );

        return flightEntity;
    }

    protected List<FlightEntity> flightDTOListToFlightEntityList(List<FlightDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<FlightEntity> list1 = new ArrayList<FlightEntity>( list.size() );
        for ( FlightDTO flightDTO : list ) {
            list1.add( flightDTOToFlightEntity( flightDTO ) );
        }

        return list1;
    }

    protected HotelEntity hotelDTOToHotelEntity(HotelDTO hotelDTO) {
        if ( hotelDTO == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( hotelDTO.getId() );
        hotelEntity.setUuid( hotelDTO.getUuid() );
        hotelEntity.setCreationDate( hotelDTO.getCreationDate() );
        hotelEntity.setUpdatedDate( hotelDTO.getUpdatedDate() );
        hotelEntity.setName( hotelDTO.getName() );
        hotelEntity.setCapacity( hotelDTO.getCapacity() );
        hotelEntity.setCity( hotelDTO.getCity() );

        return hotelEntity;
    }

    protected AppointmentEntity appointmentDTOToAppointmentEntity(AppointmentDTO appointmentDTO) {
        if ( appointmentDTO == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setId( appointmentDTO.getId() );
        appointmentEntity.setUuid( appointmentDTO.getUuid() );
        appointmentEntity.setCreationDate( appointmentDTO.getCreationDate() );
        appointmentEntity.setUpdatedDate( appointmentDTO.getUpdatedDate() );
        appointmentEntity.setFlights( flightDTOListToFlightEntityList( appointmentDTO.getFlights() ) );
        appointmentEntity.setHotel( hotelDTOToHotelEntity( appointmentDTO.getHotel() ) );
        appointmentEntity.setDoctor( dtoToEntity( appointmentDTO.getDoctor() ) );
        appointmentEntity.setHospital( hospitalDTOToHospitalEntity( appointmentDTO.getHospital() ) );
        appointmentEntity.setHotelStayDurationInDays( appointmentDTO.getHotelStayDurationInDays() );
        appointmentEntity.setReservationStartDay( appointmentDTO.getReservationStartDay() );
        appointmentEntity.setDoctorsNotes( appointmentDTO.getDoctorsNotes() );

        return appointmentEntity;
    }

    protected List<AppointmentEntity> appointmentDTOListToAppointmentEntityList(List<AppointmentDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentEntity> list1 = new ArrayList<AppointmentEntity>( list.size() );
        for ( AppointmentDTO appointmentDTO : list ) {
            list1.add( appointmentDTOToAppointmentEntity( appointmentDTO ) );
        }

        return list1;
    }

    protected HospitalDTO hospitalEntityToHospitalDTO(HospitalEntity hospitalEntity) {
        if ( hospitalEntity == null ) {
            return null;
        }

        HospitalDTO hospitalDTO = new HospitalDTO();

        hospitalDTO.setId( hospitalEntity.getId() );
        hospitalDTO.setUuid( hospitalEntity.getUuid() );
        hospitalDTO.setCreationDate( hospitalEntity.getCreationDate() );
        hospitalDTO.setUpdatedDate( hospitalEntity.getUpdatedDate() );
        hospitalDTO.setName( hospitalEntity.getName() );
        hospitalDTO.setCity( hospitalEntity.getCity() );
        List<DoctorEntity> list = hospitalEntity.getDoctorList();
        if ( list != null ) {
            hospitalDTO.setDoctorList( new ArrayList<DoctorEntity>( list ) );
        }

        return hospitalDTO;
    }

    protected FlightDTO flightEntityToFlightDTO(FlightEntity flightEntity) {
        if ( flightEntity == null ) {
            return null;
        }

        FlightDTO flightDTO = new FlightDTO();

        flightDTO.setId( flightEntity.getId() );
        flightDTO.setUuid( flightEntity.getUuid() );
        flightDTO.setCreationDate( flightEntity.getCreationDate() );
        flightDTO.setUpdatedDate( flightEntity.getUpdatedDate() );
        flightDTO.setFlightNo( flightEntity.getFlightNo() );
        flightDTO.setCapacity( flightEntity.getCapacity() );
        flightDTO.setFromCity( flightEntity.getFromCity() );
        flightDTO.setToCity( flightEntity.getToCity() );

        return flightDTO;
    }

    protected List<FlightDTO> flightEntityListToFlightDTOList(List<FlightEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<FlightDTO> list1 = new ArrayList<FlightDTO>( list.size() );
        for ( FlightEntity flightEntity : list ) {
            list1.add( flightEntityToFlightDTO( flightEntity ) );
        }

        return list1;
    }

    protected HotelDTO hotelEntityToHotelDTO(HotelEntity hotelEntity) {
        if ( hotelEntity == null ) {
            return null;
        }

        HotelDTO hotelDTO = new HotelDTO();

        hotelDTO.setId( hotelEntity.getId() );
        hotelDTO.setUuid( hotelEntity.getUuid() );
        hotelDTO.setCreationDate( hotelEntity.getCreationDate() );
        hotelDTO.setUpdatedDate( hotelEntity.getUpdatedDate() );
        hotelDTO.setName( hotelEntity.getName() );
        hotelDTO.setCapacity( hotelEntity.getCapacity() );
        hotelDTO.setCity( hotelEntity.getCity() );

        return hotelDTO;
    }

    protected AppointmentDTO appointmentEntityToAppointmentDTO(AppointmentEntity appointmentEntity) {
        if ( appointmentEntity == null ) {
            return null;
        }

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setId( appointmentEntity.getId() );
        appointmentDTO.setUuid( appointmentEntity.getUuid() );
        appointmentDTO.setCreationDate( appointmentEntity.getCreationDate() );
        appointmentDTO.setUpdatedDate( appointmentEntity.getUpdatedDate() );
        appointmentDTO.setFlights( flightEntityListToFlightDTOList( appointmentEntity.getFlights() ) );
        appointmentDTO.setHotel( hotelEntityToHotelDTO( appointmentEntity.getHotel() ) );
        appointmentDTO.setDoctor( entityToDto( appointmentEntity.getDoctor() ) );
        appointmentDTO.setHospital( hospitalEntityToHospitalDTO( appointmentEntity.getHospital() ) );
        appointmentDTO.setHotelStayDurationInDays( appointmentEntity.getHotelStayDurationInDays() );
        appointmentDTO.setReservationStartDay( appointmentEntity.getReservationStartDay() );
        appointmentDTO.setDoctorsNotes( appointmentEntity.getDoctorsNotes() );

        return appointmentDTO;
    }

    protected List<AppointmentDTO> appointmentEntityListToAppointmentDTOList(List<AppointmentEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<AppointmentDTO> list1 = new ArrayList<AppointmentDTO>( list.size() );
        for ( AppointmentEntity appointmentEntity : list ) {
            list1.add( appointmentEntityToAppointmentDTO( appointmentEntity ) );
        }

        return list1;
    }

    protected void hospitalDTOToHospitalEntity1(HospitalDTO hospitalDTO, HospitalEntity mappingTarget) {
        if ( hospitalDTO == null ) {
            return;
        }

        mappingTarget.setId( hospitalDTO.getId() );
        mappingTarget.setUuid( hospitalDTO.getUuid() );
        mappingTarget.setCreationDate( hospitalDTO.getCreationDate() );
        mappingTarget.setUpdatedDate( hospitalDTO.getUpdatedDate() );
        mappingTarget.setName( hospitalDTO.getName() );
        if ( mappingTarget.getDoctorList() != null ) {
            List<DoctorEntity> list = hospitalDTO.getDoctorList();
            if ( list != null ) {
                mappingTarget.getDoctorList().clear();
                mappingTarget.getDoctorList().addAll( list );
            }
            else {
                mappingTarget.setDoctorList( null );
            }
        }
        else {
            List<DoctorEntity> list = hospitalDTO.getDoctorList();
            if ( list != null ) {
                mappingTarget.setDoctorList( new ArrayList<DoctorEntity>( list ) );
            }
        }
        mappingTarget.setCity( hospitalDTO.getCity() );
    }
}
