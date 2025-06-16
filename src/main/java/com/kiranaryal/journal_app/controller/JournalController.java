package com.kiranaryal.journal_app.controller;

import com.kiranaryal.journal_app.entity.Journal;
import com.kiranaryal.journal_app.entity.User;
import com.kiranaryal.journal_app.repository.JournalRepository;
import com.kiranaryal.journal_app.service.JournalService;
import com.kiranaryal.journal_app.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @Autowired
    private JournalService journalService;

    @Autowired
    private UserService userService;

    @PostMapping("{username}")
    public ResponseEntity<Journal> createEntry(@RequestBody Journal journal, @PathVariable String username) {
        try {
            journalService.saveEntry(journal, username);
            return new ResponseEntity<>(journal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("{username}")
    public ResponseEntity<?> getAllJournalsOfUser(@PathVariable String username) {
        User user = userService.findByUsername(username);
        List<Journal> all = user.getJournals();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<?> getJournalById(@PathVariable ObjectId myId) {
        Optional<Journal> journal = journalService.findJournalById(myId);
        if (journal.isPresent()) {
            return new ResponseEntity<>(journal.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{username}/{myId}")
    public ResponseEntity<?> deleteJournalById(@PathVariable ObjectId myId, @PathVariable String username) {
        journalService.deleteById(myId, username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{username}/{myId}")
    public ResponseEntity<?> updateJournalById(
            @PathVariable ObjectId myId,
            @RequestBody Journal updatedJournal,
            @PathVariable String username
    ) {
        Journal oldJournal = journalService.findJournalById(myId).orElse(null);
        if (oldJournal != null) {
            oldJournal.setTitle(updatedJournal.getTitle() != null && !updatedJournal.equals("") ? updatedJournal.getTitle() : oldJournal.getTitle());
            oldJournal.setContent(updatedJournal.getContent() != null && !updatedJournal.equals("") ? updatedJournal.getContent() : oldJournal.getContent());
            journalService.saveEntry(oldJournal);
            return new ResponseEntity<>(oldJournal, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
