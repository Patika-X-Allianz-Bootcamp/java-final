package patika.fhw.demo.database.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import patika.fhw.demo.database.entity.MedicalReport;
import patika.fhw.demo.util.dbutil.BaseRepository;
@Repository
public interface MedicalReportRepository extends BaseRepository<MedicalReport> {
    List<MedicalReport> findAllByPatientId(Long patientId);
    
}
