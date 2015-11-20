package de.heckenmann.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import de.heckenmann.BeispielEntity;

@Named
@RequestScoped
public class Bean {

    private final DataModel<BeispielEntity> dataModel;

    public Bean() {
        // Testdaten erstellen.
        final List<BeispielEntity> inhalt = new ArrayList<>();
        inhalt.add(new BeispielEntity("Toller", "Wert"));
        inhalt.add(new BeispielEntity("Schlechter", "Inhalt"));
        this.dataModel = new ListDataModel<>(inhalt);
    }

    public DataModel<BeispielEntity> getDataModel() {
        return this.dataModel;
    }
}