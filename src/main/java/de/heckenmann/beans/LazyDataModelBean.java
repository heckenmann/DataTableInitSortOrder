package de.heckenmann.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import de.heckenmann.BeispielEntity;
import de.heckenmann.MyLazyDataModel;

@Named
@SessionScoped
public class LazyDataModelBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private LazyDataModel<BeispielEntity> ldm;

    @PostConstruct
    public void init() {
        this.ldm = MyLazyDataModel.getTestInstance();
    }

    public LazyDataModel<BeispielEntity> getLdm() {
        return this.ldm;
    }

    public void setLdm(final LazyDataModel<BeispielEntity> ldm) {
        this.ldm = ldm;
    }

}
