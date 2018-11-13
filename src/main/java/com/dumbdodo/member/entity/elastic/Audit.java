package com.dumbdodo.member.entity.elastic;

import com.dumbdodo.member.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Document(indexName = "audit", type = "history")
public class Audit extends BaseEntity{

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    Long entityId;

    String entityType;

    String beforeChange;

    String afterChange;

    String changedBy;
}
