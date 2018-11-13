package com.dumbdodo.member.dao.elastic;

import com.dumbdodo.member.entity.elastic.Audit;
import com.dumbdodo.member.repository.elastic.AuditRepositorty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuditDao {

    @Autowired
    private AuditRepositorty auditRepositorty;

    @Transactional
    @Async
    public Audit save(Audit audit) {
        return auditRepositorty.save(audit);
    }
}
