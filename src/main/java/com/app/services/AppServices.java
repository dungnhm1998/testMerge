package com.app.services;

//import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.app.models.ClipServices;

//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;

//extends HibernateDaoSupport 
public class AppServices implements LoggerInterface {

//    private List listBlackkey;
    private ClipServices clipServices;
    private static volatile AppServices instance = null;
//    private MongoOperations mongoOperations;
//    private RedisTemplate redisTemplate;

    public AppServices() {
//        if (clipServices == null) {
//            clipServices = (ClipServices) AppContext.getApplicationContext().getBean("clipServices");
//        }
//        if (mongoOperations == null) {
//            mongoOperations = (MongoOperations) AppContext.getApplicationContext().getBean("mongoTemplate");
//        }
//        if (redisTemplate == null) {
//            redisTemplate = (RedisTemplate) AppContext.getApplicationContext().getBean("redisTemplate");
//        }

    }

    public static AppServices getInstance() {
        if (instance == null) {
            logger.info("AppServices init");
            synchronized (AppServices.class) {
                instance = new AppServices();
            }
        }
        return instance;
    }

    public ClipServices getClipServices() {
        return clipServices;
    }

    public void setClipServices(ClipServices clipServices) {
        this.clipServices = clipServices;
    }

//    public MongoOperations getMongoOperations() {
//        return mongoOperations;
//    }
//
//    public void setMongoOperations(MongoOperations mongoOperations) {
//        this.mongoOperations = mongoOperations;
//    }
//
//    public RedisTemplate getRedisTemplate() {
//        return redisTemplate;
//    }
//
//    public void setRedisTemplate(RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//    }
}
