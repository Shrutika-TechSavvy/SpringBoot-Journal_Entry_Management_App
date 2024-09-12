package com.example.using_mongodb.service;

import com.example.using_mongodb.entity.JournalEntry;
import com.example.using_mongodb.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalEntryService {
    @Autowired
    JournalEntryRepository journalEntryRepository;

    public boolean saveEntry(JournalEntry journalEntry)
    {
        journalEntryRepository.save(journalEntry);
        return true;
    }

    public List<JournalEntry> getAllJournalEntries(){
        return journalEntryRepository.findAll();
    }
    public JournalEntry getJournalEntryById(String id){
        return journalEntryRepository.findById(id).get();
    }

    public void deleteJournalEntryById(String myId) {
        journalEntryRepository.deleteById(myId);
    }
}
