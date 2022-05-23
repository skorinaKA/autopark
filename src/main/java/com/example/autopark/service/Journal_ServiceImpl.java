package com.example.autopark.service;

import com.example.autopark.entity.Journal;
import com.example.autopark.exception.JournalNotFoundException;
import com.example.autopark.repository.AutoRepository;
import com.example.autopark.repository.JournalRepository;
import com.example.autopark.repository.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class Journal_ServiceImpl implements Journal_Service{

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private AutoRepository autoRepository;

    @Autowired
    private RoutesRepository routesRepository;

    @Override
    public Iterable<Journal> listJournal() {
        return journalRepository.findAll();
    }

    @Override
    public Journal getJournal(Long journal_pk_id) {
        Optional<Journal> optionalJournal = journalRepository.findById(journal_pk_id);
        if(optionalJournal.isPresent()){
            return optionalJournal.get();
        }else{
            throw new JournalNotFoundException("Journal not found!");
        }
    }

    @Override
    public Journal setJournal(String timestamp, String timestamp1) throws ParseException {
        timestamp = timestamp.replace('T', ' ');
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = dateFormat.parse(timestamp);
        Timestamp realTimestamp = new Timestamp(parsedDate.getTime());
        timestamp1 = timestamp1.replace('T', ' ');
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate1 = dateFormat1.parse(timestamp1);
        Timestamp realTimestamp1 = new Timestamp(parsedDate1.getTime());

        Journal journal = new Journal();
        journal.setTime_out(realTimestamp);
        journal.setTime_in(realTimestamp1);
        return journalRepository.save(journal);
    }

    @Override
    public void putNewAuto(Long journal_pk_id, Long auto_id){
        Journal journal = journalRepository.findById(journal_pk_id).get();
        journal.setAuto(autoRepository.findById(auto_id).get());
        journalRepository.save(journal);
    }

    @Override
    public void putNewRoute(Long journal_pk_id, Long route_id){
        Journal journal = journalRepository.findById(journal_pk_id).get();
        journal.setRoutes(routesRepository.findById(route_id).get());
        journalRepository.save(journal);
    }

    @Override
    public Journal putJournal(Long id, String timestamp, String timestamp1) throws ParseException {
        timestamp = timestamp.replace('T', ' ');
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate = dateFormat.parse(timestamp);
        Timestamp realTimestamp = new Timestamp(parsedDate.getTime());
        timestamp1 = timestamp1.replace('T', ' ');
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date parsedDate1 = dateFormat1.parse(timestamp1);
        Timestamp realTimestamp1 = new Timestamp(parsedDate1.getTime());

        Journal journal = journalRepository.findById(id).get();
        journal.setJournal_pk_id(id);
        journal.setTime_out(realTimestamp);
        journal.setTime_in(realTimestamp1);
        return journalRepository.save(journal);
    }

    @Override
    public void deleteJournal(Long journal_pk_id) {
        journalRepository.deleteById(journal_pk_id);
    }
}
