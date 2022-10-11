package it.fabioformosa.labs.existingquartzandstorage.config;

import org.quartz.simpl.SimpleJobFactory;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class LocalSchedulerConfig {

    @Bean
    public JobFactory jobFactory(){
        return new SimpleJobFactory();
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Primary
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean( JobFactory jobFactory, Properties quartzProperties) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(jobFactory);
        factory.setQuartzProperties(quartzProperties);
        factory.setAutoStartup(true);
        return factory;
    }

//    @Bean(name = "primaryScheduler")
//    public SchedulerFactoryBean localSchedulerFactoryBean( JobFactory jobFactory, Properties quartzProperties) {
//        SchedulerFactoryBean factory = new SchedulerFactoryBean();
//        factory.setJobFactory(jobFactory);
//        factory.setQuartzProperties(quartzProperties);
//        factory.setAutoStartup(true);
//        return factory;
//    }
//
//    @Bean(name = "secondaryScheduler")
//    public SchedulerFactoryBean secondaryScheduler(JobFactory jobFactory, Properties quartzProperties) {
//        SchedulerFactoryBean factory = new SchedulerFactoryBean();
//        factory.setJobFactory(jobFactory);
//        factory.setQuartzProperties(quartzProperties);
//        factory.setAutoStartup(true);
//        return factory;
//    }


}
