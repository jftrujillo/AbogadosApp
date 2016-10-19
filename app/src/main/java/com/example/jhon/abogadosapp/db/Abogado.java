package com.example.jhon.abogadosapp.db;

import java.util.List;
import com.example.jhon.abogadosapp.db.DaoSession;
import de.greenrobot.dao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "ABOGADO".
 */
public class Abogado {

    private Long id;
    /** Not-null value. */
    private String nombre;
    /** Not-null value. */
    private String cargo;
    private String descripcion;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient AbogadoDao myDao;

    private List<Titulo> abogadoTitulos;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Abogado() {
    }

    public Abogado(Long id) {
        this.id = id;
    }

    public Abogado(Long id, String nombre, String cargo, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.descripcion = descripcion;
    }

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getAbogadoDao() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getNombre() {
        return nombre;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** Not-null value. */
    public String getCargo() {
        return cargo;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Titulo> getAbogadoTitulos() {
        if (abogadoTitulos == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TituloDao targetDao = daoSession.getTituloDao();
            List<Titulo> abogadoTitulosNew = targetDao._queryAbogado_AbogadoTitulos(id);
            synchronized (this) {
                if(abogadoTitulos == null) {
                    abogadoTitulos = abogadoTitulosNew;
                }
            }
        }
        return abogadoTitulos;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void resetAbogadoTitulos() {
        abogadoTitulos = null;
    }

    /** Convenient call for {@link AbstractDao#delete(Object)}. Entity must attached to an entity context. */
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.delete(this);
    }

    /** Convenient call for {@link AbstractDao#update(Object)}. Entity must attached to an entity context. */
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.update(this);
    }

    /** Convenient call for {@link AbstractDao#refresh(Object)}. Entity must attached to an entity context. */
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }    
        myDao.refresh(this);
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}