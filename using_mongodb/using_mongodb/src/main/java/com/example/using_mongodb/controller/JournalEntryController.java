package com.example.using_mongodb.controller;

import com.example.using_mongodb.entity.JournalEntry;
import com.example.using_mongodb.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    private final JournalEntryService journalEntryService;


    //@GetMapping("/hello")
    //public String hello()
    //{
      //     return "Hello World";
    //}


    public JournalEntryController(JournalEntryService journalEntryService) {
        this.journalEntryService = journalEntryService;
    }

    //working
    @GetMapping("/getAllEntries")
    public List<JournalEntry> getAllJournalEntries() {
        return journalEntryService.getAllJournalEntries();
    }

    //add the new entry->Working
    @PostMapping
    public boolean addJournalEntry(@RequestBody JournalEntry journalEntry) {
        journalEntry.setDate(LocalDateTime.now());
        return journalEntryService.saveEntry(journalEntry);
    }

    //Working
    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable String myId) {
        return journalEntryService.getJournalEntryById(myId);
    }
    /*
    @PutMapping("/id/{myId}")
    public JournalEntry updateJournalEntry(@PathVariable String myId,@RequestBody JournalEntry newJournalEntry) {
        //journalEntry.setDate(LocalDateTime.now());

        JournalEntry old=journalEntryService.getJournalEntryById(myId);
        if(old==null)
        {

        }
    }*/


    //Working...
    //deletes the currently present entry from db
    @DeleteMapping("/id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable String myId) {
        journalEntryService.deleteJournalEntryById(myId);
        return true;
    }
}
