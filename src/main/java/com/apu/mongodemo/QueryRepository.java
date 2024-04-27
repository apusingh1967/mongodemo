package com.apu.mongodemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Repository
public class QueryRepository {

    @Autowired
    private MongoTemplate template;

    public List<Author> getAuthors(String rgx) {
        Query q = new Query();
        q.addCriteria(Criteria.where("name").regex(rgx));
        return template.find(q, Author.class);
    }

    public List<Author> getAuthors(int y1, int y2) {
        Query q = new Query();
        q.with(Sort.by(Sort.Direction.ASC, "birthYear"))
                .addCriteria(Criteria.where("birthYear").gt(y1).lt(y2));
        return template.find(q, Author.class);
    }

    public List<User> findUsersBy(int age, boolean active, String eyeColor) {
        AggregationOperation isActive = match(Criteria.where("isActive").is(active));
        AggregationOperation eyeColorOp = match(Criteria.where("eyeColor").is(eyeColor));
        AggregationOperation gtAge = match(Criteria.where("age").gt(age));
        Aggregation agg = newAggregation(isActive, eyeColorOp, gtAge);
        AggregationResults<User> res = template.aggregate(agg, User.class, User.class);
        return res.getMappedResults();
    }

}
