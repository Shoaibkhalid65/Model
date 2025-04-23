package com.gshoaib998.model;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class DataRepo {
    Box<Note> noteBox;
    DataRepo(){
        noteBox=ObjectBox.getBox().boxFor(Note.class);
    }
    public void addNote(Note note){
        noteBox.put(note);
    }
    public List<Note> getAllNotes(){
        return noteBox.getAll();
    }
    public void deleteNote(Note note){
        noteBox.remove(note);
    }

}
