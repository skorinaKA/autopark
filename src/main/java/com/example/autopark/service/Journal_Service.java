package com.example.autopark.service;

import com.example.autopark.entity.Journal;

import java.sql.Timestamp;
import java.text.ParseException;

public interface Journal_Service {
    Iterable<Journal> listJournal();
    Journal getJournal(Long journal_pk_id);
    Journal setJournal(String timestamp, String timestamp1) throws ParseException;
    void putNewAuto(Long journal_pk_id, Long auto_id);
    void putNewRoute(Long journal_pk_id, Long route_id);
    Journal putJournal(Long id, String timestamp, String timestamp1) throws ParseException;
    void deleteJournal(Long journal_pk_id);
}
