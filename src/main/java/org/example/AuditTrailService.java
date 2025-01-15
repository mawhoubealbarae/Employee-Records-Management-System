package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditTrailService {

    @Autowired
    private AuditTrailRepository auditTrailRepository;

    public void logAction(String action, String performedBy) {
        AuditTrail auditTrail = new AuditTrail();
        auditTrail.setAction(action);
        auditTrail.setPerformedBy(performedBy);
        auditTrail.setTimestamp(LocalDateTime.now());
        auditTrailRepository.save(auditTrail);
    }
}