package dev.mudith.notes.controller;

import dev.mudith.notes.model.Note;
import dev.mudith.notes.payload.request.NoteRequest;
import dev.mudith.notes.repository.NoteRepository;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    /* Get all notes */
    @GetMapping("/note")
    public ResponseEntity<List<Note>> getAllNotes(){
        return ResponseEntity.ok(this.noteRepository.findAll());
    }

    /* Create note */
    @PostMapping("/note")
    public ResponseEntity<Note> createNote(@RequestBody NoteRequest noteRequest){
        Note note = new Note();
        note.setUser(noteRequest.getUser());
        note.setTitle(noteRequest.getTitle());
        note.setDescription(noteRequest.getDescription());

        return ResponseEntity.status(201).body(this.noteRepository.save(note));
    }

    /* Get a note */
    @GetMapping("/note/{noteId}")
    public ResponseEntity getNoteById(@PathVariable String noteId){

        Optional<Note> note = this.noteRepository.findById(noteId);

        if(note.isPresent()){
            return ResponseEntity.ok(note.get());
        }else {
            return ResponseEntity.ok("The Note with id: " + noteId + "was not found...");
        }
    }

    /* Update a note */

    @PutMapping("/note/{noteId}")
    public ResponseEntity<Note> updateNote(@RequestBody NoteRequest noteRequest, @PathVariable String noteId){
        Optional<Note> note = this.noteRepository.findById(noteId);

        if(note.isPresent()){
            Note newUpdateNote = note.get();
            newUpdateNote.setUser(noteRequest.getUser());
            newUpdateNote.setTitle(noteRequest.getTitle());
            newUpdateNote.setDescription(noteRequest.getDescription());

            return ResponseEntity.status(201).body(this.noteRepository.save(newUpdateNote));
        }else{
            return null;
        }
    }

    /* Delete a note */
    @DeleteMapping("/note/{noteId}")
    public ResponseEntity deleteNoteById(@PathVariable String noteId){
        Optional<Note> note = this.noteRepository.findById(noteId);

        if(note.isPresent()){
            this.noteRepository.deleteById(noteId);
            return ResponseEntity.ok("Note deleted successfully...");
        }else {
            return ResponseEntity.ok("The Note with id: " + noteId + "was not found...");
        }
    }
}
