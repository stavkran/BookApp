package com.novelty.noveltybackend.Report;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository){
        this.reportRepository = reportRepository;
    }

    public List<Report> getReports(){
        return reportRepository.findAll();
    }

    public Report getReport(Long id){
        Optional<Report> report = reportRepository.findById(id);
        if(report.isPresent()){
            return report.get();
        }else{
            throw new IllegalStateException("Report with ID "+id+" does not exist");
        }
    }

    public void deleteReport(Long id){
        if(reportRepository.existsById(id)){
            reportRepository.deleteById(id);
        }else{
            throw new IllegalStateException("Report with ID "+id+" does not exist");
        }
    }

    public void addNewReport(Report report){
        reportRepository.save(report);
    }

    @Transactional
    public void updateRepository(Long id, String reason, String comment){
        Optional<Report> user = reportRepository.findById(id);
        if(user.isPresent()){
            if(reason != null){
                user.get().setReason(reason);
            }
            if(comment != null){
                user.get().setComment(comment);
            }
        }else{
            throw new IllegalStateException("Report with ID "+id+" does not exist");
        }
    }
}
