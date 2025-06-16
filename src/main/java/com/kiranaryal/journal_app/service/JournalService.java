package com.kiranaryal.journal_app.service;

import com.kiranaryal.journal_app.entity.Journal;
import com.kiranaryal.journal_app.entity.User;
import com.kiranaryal.journal_app.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(Journal journal, String username) {
        try {
            User user = userService.findByUsername(username);
            journal.setDate(LocalDate.now());
            Journal saved = journalRepository.save(journal);
            user.getJournals().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occurred while saving the entry.", e);
        }

    }

    public void saveEntry(Journal journal) {
        journalRepository.save(journal);
    }


    public List<Journal> getAll() {
        return journalRepository.findAll();
    }

    public Optional<Journal> findJournalById(ObjectId myId) {
        return journalRepository.findById(myId);
    }

    public void deleteById(ObjectId myId, String username) {
        User user = userService.findByUsername(username);
        user.getJournals().removeIf(x -> x.getId().equals(myId));
        userService.saveUser(user);
        journalRepository.deleteById(myId);
    }
}
