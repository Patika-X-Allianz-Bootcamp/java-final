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
import com.demo.medicaltourismapp.model.requestDTO.AppointmentRequestDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-03T21:56:58+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.8 (JetBrains s.r.o.)"
)
@Component
public class AppointmentMapperImpl implements AppointmentMapper {

    @Override
    public AppointmentEntity dtoToEntity(AppointmentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setId( dto.getId() );
        appointmentEntity.setUuid( dto.getUuid() );
        appointmentEntity.setCreationDate( dto.getCreationDate() );
        appointmentEntity.setUpdatedDate( dto.getUpdatedDate() );
        appointmentEntity.setFlights( flightDTOListToFlightEntityList( dto.getFlights() ) );
        appointmentEntity.setHotel( hotelDTOToHotelEntity( dto.getHotel() ) );
        appointmentEntity.setDoctor( doctorDTOToDoctorEntity( dto.getDoctor() ) );
        appointmentEntity.setHospital( hospitalDTOToHospitalEntity( dto.getHospital() ) );
        appointmentEntity.setHotelStayDurationInDays( dto.getHotelStayDurationInDays() );
        appointmentEntity.setReservationStartDay( dto.getReservationStartDay() );
        appointmentEntity.setDoctorsNotes( dto.getDoctorsNotes() );

        return appointmentEntity;
    }

    @Override
    public AppointmentDTO entityToDto(AppointmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AppointmentDTO appointmentDTO = new AppointmentDTO();

        appointmentDTO.setId( entity.getId() );
        appointmentDTO.setUuid( entity.getUuid() );
        appointmentDTO.setCreationDate( entity.getCreationDate() );
        appointmentDTO.setUpdatedDate( entity.getUpdatedDate() );
        appointmentDTO.setFlights( flightEntityListToFlightDTOList( entity.getFlights() ) );
        appointmentDTO.setHotel( hotelEntityToHotelDTO( entity.getHotel() ) );
        appointmentDTO.setDoctor( doctorEntityToDoctorDTO( entity.getDoctor() ) );
        appointmentDTO.setHospital( hospitalEntityToHospitalDTO( entity.getHospital() ) );
        appointmentDTO.setHotelStayDurationInDays( entity.getHotelStayDurationInDays() );
        appointmentDTO.setReservationStartDay( entity.getReservationStartDay() );
        appointmentDTO.setDoctorsNotes( entity.getDoctorsNotes() );

        return appointmentDTO;
    }

    @Override
    public AppointmentEntity requestDtoToEntity(AppointmentRequestDTO requestDTO) {
        if ( requestDTO == null ) {
            return null;
        }

        AppointmentEntity appointmentEntity = new AppointmentEntity();

        appointmentEntity.setId( requestDTO.getId() );
        appointmentEntity.setUuid( requestDTO.getUuid() );
        appointmentEntity.setCreationDate( requestDTO.getCreationDate() );
        appointmentEntity.setUpdatedDate( requestDTO.getUpdatedDate() );
        appointmentEntity.setFlights( flightDTOListToFlightEntityList( requestDTO.getFlights() ) );
        appointmentEntity.setHotel( hotelDTOToHotelEntity( requestDTO.getHotel() ) );
        appointmentEntity.setDoctor( doctorDTOToDoctorEntity( requestDTO.getDoctor() ) );
        appointmentEntity.setHospital( hospitalDTOToHospitalEntity( requestDTO.getHospital() ) );
        appointmentEntity.setHotelStayDurationInDays( requestDTO.getHotelStayDurationInDays() );
        appointmentEntity.setReservationStartDay( requestDTO.getReservationStartDay() );
        appointmentEntity.setDoctorsNotes( requestDTO.getDoctorsNotes() );

        return appointmentEntity;
    }

    @Override
    public AppointmentRequestDTO entityToRequestDto(AppointmentEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AppointmentRequestDTO appointmentRequestDTO = new AppointmentRequestDTO();

        appointmentRequestDTO.setId( entity.getId() );
        appointmentRequestDTO.setUuid( entity.getUuid() );
        appointmentRequestDTO.setCreationDate( entity.getCreationDate() );
        appointmentRequestDTO.setUpdatedDate( entity.getUpdatedDate() );
        appointmentRequestDTO.setFlights( flightEntityListToFlightDTOList( entity.getFlights() ) );
        appointmentRequestDTO.setHotel( hotelEntityToHotelDTO( entity.getHotel() ) );
        appointmentRequestDTO.setDoctor( doctorEntityToDoctorDTO( entity.getDoctor() ) );
        appointmentRequestDTO.setHospital( hospitalEntityToHospitalDTO( entity.getHospital() ) );
        appointmentRequestDTO.setHotelStayDurationInDays( entity.getHotelStayDurationInDays() );
        appointmentRequestDTO.setReservationStartDay( entity.getReservationStartDay() );
        appointmentRequestDTO.setDoctorsNotes( entity.getDoctorsNotes() );

        return appointmentRequestDTO;
    }

    @Override
    public List<AppointmentEntity> requestDtoListToEntityList(List<AppointmentRequestDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AppointmentEntity> list = new ArrayList<AppointmentEntity>( dtoList.size() );
        for ( AppointmentRequestDTO appointmentRequestDTO : dtoList ) {
            list.add( requestDtoToEntity( appointmentRequestDTO ) );
        }

        return list;
    }

    @Override
    public List<AppointmentRequestDTO> entityListToRequestDtoList(List<AppointmentEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AppointmentRequestDTO> list = new ArrayList<AppointmentRequestDTO>( entityList.size() );
        for ( AppointmentEntity appointmentEntity : entityList ) {
            list.add( entityToRequestDto( appointmentEntity ) );
        }

        return list;
    }

    @Override
    public List<AppointmentEntity> dtoListToEntityList(List<AppointmentDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AppointmentEntity> list = new ArrayList<AppointmentEntity>( dtoList.size() );
        for ( AppointmentDTO appointmentDTO : dtoList ) {
            list.add( dtoToEntity( appointmentDTO ) );
        }

        return list;
    }

    @Override
    public List<AppointmentDTO> entityListToDtoList(List<AppointmentEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AppointmentDTO> list = new ArrayList<AppointmentDTO>( entityList.size() );
        for ( AppointmentEntity appointmentEntity : entityList ) {
            list.add( entityToDto( appointmentEntity ) );
        }

        return list;
    }

    @Override
    public AppointmentEntity requestDtoToExistEntity(AppointmentRequestDTO requestDTO, AppointmentEntity entity) {
        if ( requestDTO == null ) {
            return entity;
        }

        entity.setId( requestDTO.getId() );
        entity.setUuid( requestDTO.getUuid() );
        entity.setCreationDate( requestDTO.getCreationDate() );
        entity.setUpdatedDate( requestDTO.getUpdatedDate() );
        if ( entity.getFlights() != null ) {
            List<FlightEntity> list = flightDTOListToFlightEntityList( requestDTO.getFlights() );
            if ( list != null ) {
                entity.getFlights().clear();
                entity.getFlights().addAll( list );
            }
            else {
                entity.setFlights( null );
            }
        }
        else {
            List<FlightEntity> list = flightDTOListToFlightEntityList( requestDTO.getFlights() );
            if ( list != null ) {
                entity.setFlights( list );
            }
        }
        if ( requestDTO.getHotel() != null ) {
            if ( entity.getHotel() == null ) {
                entity.setHotel( new HotelEntity() );
            }
            hotelDTOToHotelEntity1( requestDTO.getHotel(), entity.getHotel() );
        }
        else {
            entity.setHotel( null );
        }
        if ( requestDTO.getDoctor() != null ) {
            if ( entity.getDoctor() == null ) {
                entity.setDoctor( new DoctorEntity() );
            }
            doctorDTOToDoctorEntity1( requestDTO.getDoctor(), entity.getDoctor() );
        }
        else {
            entity.setDoctor( null );
        }
        if ( requestDTO.getHospital() != null ) {
            if ( entity.getHospital() == null ) {
                entity.setHospital( new HospitalEntity() );
            }
            hospitalDTOToHospitalEntity1( requestDTO.getHospital(), entity.getHospital() );
        }
        else {
            entity.setHospital( null );
        }
        entity.setHotelStayDurationInDays( requestDTO.getHotelStayDurationInDays() );
        entity.setReservationStartDay( requestDTO.getReservationStartDay() );
        entity.setDoctorsNotes( requestDTO.getDoctorsNotes() );

        return entity;
    }

    @Override
    public PageDTO<AppointmentDTO> pageEntityToPageDTO(Page<AppointmentEntity> entityPage) {
        if ( entityPage == null ) {
            return null;
        }

        PageDTO<AppointmentDTO> pageDTO = new PageDTO<AppointmentDTO>();

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

    protected DoctorEntity doctorDTOToDoctorEntity(DoctorDTO doctorDTO) {
        if ( doctorDTO == null ) {
            return null;
        }

        DoctorEntity doctorEntity = new DoctorEntity();

        doctorEntity.setId( doctorDTO.getId() );
        doctorEntity.setUuid( doctorDTO.getUuid() );
        doctorEntity.setCreationDate( doctorDTO.getCreationDate() );
        doctorEntity.setUpdatedDate( doctorDTO.getUpdatedDate() );
        doctorEntity.setHospital( hospitalDTOToHospitalEntity( doctorDTO.getHospital() ) );
        doctorEntity.setDoctorSpecialtyEnum( doctorDTO.getDoctorSpecialtyEnum() );
        doctorEntity.setAppointmentList( dtoListToEntityList( doctorDTO.getAppointmentList() ) );

        return doctorEntity;
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

    protected DoctorDTO doctorEntityToDoctorDTO(DoctorEntity doctorEntity) {
        if ( doctorEntity == null ) {
            return null;
        }

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO.setId( doctorEntity.getId() );
        doctorDTO.setUuid( doctorEntity.getUuid() );
        doctorDTO.setCreationDate( doctorEntity.getCreationDate() );
        doctorDTO.setUpdatedDate( doctorEntity.getUpdatedDate() );
        doctorDTO.setHospital( hospitalEntityToHospitalDTO( doctorEntity.getHospital() ) );
        doctorDTO.setDoctorSpecialtyEnum( doctorEntity.getDoctorSpecialtyEnum() );
        doctorDTO.setAppointmentList( entityListToDtoList( doctorEntity.getAppointmentList() ) );

        return doctorDTO;
    }

    protected void hotelDTOToHotelEntity1(HotelDTO hotelDTO, HotelEntity mappingTarget) {
        if ( hotelDTO == null ) {
            return;
        }

        mappingTarget.setId( hotelDTO.getId() );
        mappingTarget.setUuid( hotelDTO.getUuid() );
        mappingTarget.setCreationDate( hotelDTO.getCreationDate() );
        mappingTarget.setUpdatedDate( hotelDTO.getUpdatedDate() );
        mappingTarget.setName( hotelDTO.getName() );
        mappingTarget.setCapacity( hotelDTO.getCapacity() );
        mappingTarget.setCity( hotelDTO.getCity() );
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

    protected void doctorDTOToDoctorEntity1(DoctorDTO doctorDTO, DoctorEntity mappingTarget) {
        if ( doctorDTO == null ) {
            return;
        }

        mappingTarget.setId( doctorDTO.getId() );
        mappingTarget.setUuid( doctorDTO.getUuid() );
        mappingTarget.setCreationDate( doctorDTO.getCreationDate() );
        mappingTarget.setUpdatedDate( doctorDTO.getUpdatedDate() );
        if ( doctorDTO.getHospital() != null ) {
            if ( mappingTarget.getHospital() == null ) {
                mappingTarget.setHospital( new HospitalEntity() );
            }
            hospitalDTOToHospitalEntity1( doctorDTO.getHospital(), mappingTarget.getHospital() );
        }
        else {
            mappingTarget.setHospital( null );
        }
        mappingTarget.setDoctorSpecialtyEnum( doctorDTO.getDoctorSpecialtyEnum() );
        if ( mappingTarget.getAppointmentList() != null ) {
            List<AppointmentEntity> list = dtoListToEntityList( doctorDTO.getAppointmentList() );
            if ( list != null ) {
                mappingTarget.getAppointmentList().clear();
                mappingTarget.getAppointmentList().addAll( list );
            }
            else {
                mappingTarget.setAppointmentList( null );
            }
        }
        else {
            List<AppointmentEntity> list = dtoListToEntityList( doctorDTO.getAppointmentList() );
            if ( list != null ) {
                mappingTarget.setAppointmentList( list );
            }
        }
    }
}
