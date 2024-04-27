package com.apu.mongodemo;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AuthorRepository extends MongoRepository<Author, Integer> {

    @Query(value="{'name': ?0}", fields="{name: 1, _id: 0, birthYear: 1}")
    List<Author> findNameAndExcludeId(String name);

    @Aggregation(pipeline = {"{$match:{'timestamp' : { $gte: ?0, $lte: ?1 }}}","{$group:{ _id: '$series_id', average: { $avg: '$value' }}}"})
    List<Author> x();

    @Aggregation(pipeline = {
        """
            {$match:{'timestamp' : { $gte: ?0, $lte: ?1 }}}",
            "{$group:{ _id: '$series_id', average: { $avg: '$value' }}}
                """
    })
    List<Author> m();

}
