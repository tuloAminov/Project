package ru.students.startup.project.services;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.students.startup.project.dto.Room;

import java.util.logging.Logger;

@Repository
public class RoomRepository implements ProjectRepository<Room>, ApplicationContextAware {

    private final Logger logger = Logger.getLogger(String.valueOf(RoomRepository.class));
    private ApplicationContext context;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public RoomRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void store(Room room) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("question",room.getQuestion());
        parameterSource.addValue("variants",room.getVariants());
        jdbcTemplate.update("INSERT INTO rooms(question,variants) VALUES(:question, :variants)",parameterSource);
        logger.info("store new book: " + room);
    }

    @Override
    public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext) throws BeansException {

    }

    public void defaultInit(){
        logger.info("default INIT in book repo bean");
    }

    public void defaultDestroy(){
        logger.info("default DESTROY in book repo bean");
    }
}
