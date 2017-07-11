package com.internship.del.jparesearch.services;

import com.internship.del.jparesearch.model.Log;

import java.util.List;

/**
 * Created by amrianto on 03/07/2017.
 */
public interface LogService {
    public Log saveLog(Log log);
    public Log deleteLog(int id);
    public List<Log> getAllLog();
    public Log findOne(int id);
}
