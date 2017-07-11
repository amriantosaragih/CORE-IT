package com.internship.del.jparesearch.servicesImpl;

import com.internship.del.jparesearch.Repositories.LogRepository;
import com.internship.del.jparesearch.model.Log;
import com.internship.del.jparesearch.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amrianto on 03/07/2017.
 */
@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private LogRepository logRepository;

    @Override
    @Transactional
    public Log saveLog(Log log) {
        if(logRepository.findOne(log.getId())==null){
            return logRepository.save(log);
        }else {
            return null;
        }
    }

    @Override
    @Transactional
    public Log deleteLog(int id) {
        Log log = logRepository.findOne(id);
        if(log!=null){
            logRepository.delete(id);
            return log;
        }else {
            return null;
        }
    }

    @Override
    public List<Log> getAllLog() {
        List<Log> logList = logRepository.findAll();
        return logList;
    }

    @Override
    public Log findOne(int id) {
        return logRepository.findOne(id);
    }
}
