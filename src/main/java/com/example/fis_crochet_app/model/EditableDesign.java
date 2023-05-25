package com.example.fis_crochet_app.model;

import javafx.scene.control.Button;

public class EditableDesign {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Button getEdit() {
        return Edit;
    }

    public void setEdit(Button edit) {
        Edit = edit;
    }

    private Button Edit;

    public EditableDesign(String name, Button edit) {
        this.name = name;
        Edit = edit;
    }

    public EditableDesign(){}
}
