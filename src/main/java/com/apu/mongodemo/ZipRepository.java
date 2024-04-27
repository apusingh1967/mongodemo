package com.apu.mongodemo;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class ZipRepository {

    @Autowired private MongoTemplate template;

    public Zip findById(String id){
        return template.findById(id, Zip.class);
    }

    public List<Document> findPopByState(long pop){
        GroupOperation gp = group("state").sum("pop").as("state_population");
        MatchOperation mtc = match(Criteria.where("state_population").gt(pop));
        Aggregation agg = newAggregation(gp, mtc);
        AggregationResults<Document>r = template.aggregate(agg, "zips", Document.class);
        return r.getMappedResults();
    }

    public List<Document> findAvgPopByState(){
        GroupOperation gp = group("state", "city").sum("pop").as("pop");
        GroupOperation avg = group("_id.state").avg("pop").as("avgpop");
        SortOperation srt = sort(Sort.Direction.DESC, "avgpop");
        LimitOperation li = limit(10);
        ProjectionOperation pr = project().andExpression("_id").as("state")
            .andExpression("avgpop").as("average_pop");
        Aggregation agg = newAggregation(gp, avg, srt, li, pr);
        AggregationResults<Document>r = template.aggregate(agg, "zips", Document.class);
        return r.getMappedResults();
    }

    public Document findMinMxPop() {
        GroupOperation sumZips = group("state").count().as("zipCount");
        SortOperation sortByCount = sort(Sort.Direction.ASC, "zipCount");
        GroupOperation groupFirstAndLast = group().first("_id").as("minZipState")
        .first("zipCount").as("minZipCount").last("_id").as("maxZipState")
        .last("zipCount").as("maxZipCount");
        Aggregation aggregation = newAggregation(sumZips, sortByCount, groupFirstAndLast);
        AggregationResults<Document> result = template.aggregate(aggregation, "zips", Document.class);
        return result.getUniqueMappedResult();
    }

}
