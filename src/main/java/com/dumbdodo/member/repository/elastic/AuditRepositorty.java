package com.dumbdodo.member.repository.elastic;

import com.dumbdodo.member.entity.elastic.Audit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditRepositorty extends ElasticsearchRepository<Audit, String> {
}
