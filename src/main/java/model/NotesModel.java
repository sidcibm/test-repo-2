package model;

import model.note.Note;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class NotesModel {
    private static final String NOTES_DIRECTORY = "./data/", NOTE_FILE_EXTENSION = ".txt";

    private final List<Note> notes = new ArrayList<>();
    private Function<Note, String> noteKey = Note::getId;

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }

    private void sortNotes() {
        notes.sort(Comparator.comparing(noteKey));
    }

    public void sortNotesByKey(Function<Note, String> newNoteKey) {
        noteKey = newNoteKey;
        sortNotes();
    }

    public Note findNoteById(String noteId) {
        for(Note note : notes) {
            if(note.getId().equals(noteId)) {
                return note;
            }
        }

        return null;
    }

    private void updateNotesDirectory(Note newNote) {
        try(PrintWriter noteFileWriter = new PrintWriter(NOTES_DIRECTORY + newNote.getId() + NOTE_FILE_EXTENSION)) {
            noteFileWriter.println(newNote.getName());
            noteFileWriter.println(newNote.getUrl());
            noteFileWriter.println(newNote.getImage());
            noteFileWriter.print(newNote.getText());
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void updateNotesDataStructure(Note newNote) {
        Note note = findNoteById(newNote.getId());

        if(note != null) {
            note.setName(newNote.getName());
            note.setUrl(newNote.getUrl());
            note.setImage(newNote.getImage());
            note.setText(newNote.getText());
        }
        else {
            notes.add(newNote);
        }

        sortNotes();
    }

    public void updateNotes(Note newNote) {
        updateNotesDirectory(newNote);
        updateNotesDataStructure(newNote);
    }

    private void deleteFromNotesDirectory(String noteId) {
        if(new File(NOTES_DIRECTORY + noteId + NOTE_FILE_EXTENSION).delete()) {
            System.out.println("Deleted " + noteId + NOTE_FILE_EXTENSION);
        }
    }

    private void deleteFromNotesDataStructure(String noteId) {
        notes.removeIf(note -> note.getId().equals(noteId));
    }

    public void deleteNoteById(String noteId) {
        deleteFromNotesDirectory(noteId);
        deleteFromNotesDataStructure(noteId);
    }

    private void readNoteFile(File noteFile) {
        try(Scanner noteFileScanner = new Scanner(noteFile)) {
            String name = noteFileScanner.nextLine();
            String url = noteFileScanner.nextLine();
            String image = noteFileScanner.nextLine();
            StringBuilder text = new StringBuilder();

            while(noteFileScanner.hasNextLine()) {
                text.append(noteFileScanner.nextLine());

                if(noteFileScanner.hasNextLine()) {
                    text.append("\n");
                }
            }

            String id = noteFile.getName().substring(0, noteFile.getName().lastIndexOf('.'));
            notes.add(new Note(id, name, url, image, text.toString()));
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readNotesDirectory() {
        File[] noteFiles = new File(NOTES_DIRECTORY).listFiles();

        if(noteFiles != null) {
            for(File noteFile : noteFiles) {
                if(!noteFile.isHidden()) {
                    readNoteFile(noteFile);
                }
            }

            sortNotes();
        }
    }
}
