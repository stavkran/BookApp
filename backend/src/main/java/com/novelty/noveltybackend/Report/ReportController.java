package com.novelty.noveltybackend.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/report")
public class ReportController {
    private final ReportService  reportService;

    @Autowired
    public ReportController(ReportService reportService){
        this.reportService = reportService;
    }
    @GetMapping
    public List<Report> getAllReports(){
        return reportService.getReports();
    }

    @GetMapping(path = "{reportId}")
    public Report getReport(@PathVariable("reportId") Long id){
        return reportService.getReport(id);
    }

    @PostMapping
    public void createReport(@RequestBody Report report){
        reportService.addNewReport(report);
    }

    @DeleteMapping(path = "{reportId}")
    public void deleteReport(@PathVariable("reportId") Long id ){
        reportService.deleteReport(id);
    }

    @PutMapping(path = "{reportId}")
    public void updateUser(@PathVariable("reportId") Long id, @RequestBody(required = false) Report report){
        reportService.updateRepository(id, report.getReason(), report.getComment());
    }
}
