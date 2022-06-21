package model;

// This class gives access to the model to any other class that needs it
// Calling the static method getNotesModel() returns an initialised NotesModel object
// This limits the program to one model object which is returned whenever getNotesModel() is called
public class NotesModelFactory {
    private static NotesModel notesModel;

    public static NotesModel getNotesModel() {
        if(notesModel == null) {
            notesModel = new NotesModel();
            notesModel.readNotesDirectory();
        }
        return notesModel;
    }
}
