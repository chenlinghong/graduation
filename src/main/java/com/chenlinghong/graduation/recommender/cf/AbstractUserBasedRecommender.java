package com.chenlinghong.graduation.recommender.cf;

import com.chenlinghong.graduation.recommender.AbstractGraduationMahoutRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import javax.sql.DataSource;

/**
 * @Description 基于用户的推荐
 * @Author chenlinghong
 * @Date 2019/4/27 22:45
 * @Version V1.0
 */
public abstract class AbstractUserBasedRecommender extends AbstractGraduationMahoutRecommender {

    /**
     * user similarity matrix
     */
    protected UserSimilarity userSimilarity;

    /**
     * neighborhood
     */
    protected UserNeighborhood userNeighborhood;

    /**
     * recommender
     */
    protected org.apache.mahout.cf.taste.recommender.Recommender recommender;

    /**
     * MySQL DataModel
     */
    protected DataModel dataModel;

    /**
     * data source
     */
    protected DataSource dataSource;

    /**
     * 邻居个数,默认20
     */
    protected Integer neighborhoodNumber;

}