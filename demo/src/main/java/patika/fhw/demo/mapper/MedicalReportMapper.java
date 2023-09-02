package patika.fhw.demo.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import patika.fhw.demo.database.entity.MedicalReport;
import patika.fhw.demo.database.entity.Patient;
import patika.fhw.demo.database.repository.PatientRepository;
import patika.fhw.demo.model.dto.MedicalReportDTO;
import patika.fhw.demo.model.requestDTO.MedicalReportRequestDTO;
import patika.fhw.demo.model.requestDTO.PageDTO;
import patika.fhw.demo.util.BaseMapper;

@Component
public class MedicalReportMapper implements BaseMapper<MedicalReportDTO, MedicalReport, MedicalReportRequestDTO> {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public MedicalReportDTO entityToDTO(MedicalReport entity) {
        MedicalReportDTO dto = new MedicalReportDTO();
        dto.setId(entity.getId());
        dto.setPatientId(entity.getPatient().getId().toString());
        dto.setDiagnosis(entity.getReportDetails());
        dto.setReportDate(entity.getCreatedAt());
        dto.setDoctorId(entity.getPatient().getDoctors().getClass().toString());
        dto.setTreatmentPlan("Sample Treatment Plan");
        dto.setNotes("Sample Notes");
        return dto;
    }

    @Override
    public MedicalReport dtoToEntity(MedicalReportDTO dto) {
        MedicalReport entity = new MedicalReport();
        entity.setId(dto.getId());
        Patient patient = patientRepository.findById(Long.parseLong(dto.getPatientId())).orElse(null);
        entity.setPatient(patient);
        entity.setReportDetails(dto.getDiagnosis());
        return entity;
    }

    @Override
    public List<MedicalReportDTO> entityListToDTOList(List<MedicalReport> entityList) {
        return entityList.stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public List<MedicalReport> dtoListTOEntityList(List<MedicalReportDTO> dtoList) {
        return dtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public MedicalReport requestDTOToEntity(MedicalReportRequestDTO requestDTO) {
        MedicalReport entity = new MedicalReport();
        entity.setReportDetails(requestDTO.getDescription());
        entity.setReportTitle(requestDTO.getDiagnosis());
        return entity;
    }

    @Override
    public List<MedicalReport> requestDtoListTOEntityList(List<MedicalReportRequestDTO> requestDTOList) {
        return requestDTOList.stream().map(this::requestDTOToEntity).collect(Collectors.toList());
    }

    @Override
    public MedicalReport requestDtoToExistEntity(MedicalReport entity, MedicalReportRequestDTO requestDTO) {
        entity.setReportDetails(requestDTO.getDescription());
        entity.setReportTitle(requestDTO.getDiagnosis());
        return entity;
    }

    @Override
    public PageDTO<MedicalReportDTO> pageEntityToPageDTO(Page<MedicalReport> entityPage) {
        PageDTO<MedicalReportDTO> pageDTO = new PageDTO<>();
        pageDTO.setContent(entityListToDTOList(entityPage.getContent()));
        pageDTO.setTotalPages(entityPage.getTotalPages());
        pageDTO.setTotalElements(entityPage.getTotalElements());
        pageDTO.setCurrentPage(entityPage.getNumber());
        pageDTO.setSize(entityPage.getSize());
        return pageDTO;
    }
}
