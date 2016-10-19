package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class MainGenerator {

    private static final String PROJECT_DIR = System.getProperty("user.dir");

    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.example.jhon.abogadosapp.db");
        schema.enableKeepSectionsByDefault();
        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, PROJECT_DIR + "/app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        Entity abogado = addAbogado(schema);
        Entity titulo = addTitulo(schema);
        Property abogadoId = titulo.addLongProperty("abogadoId").notNull().getProperty();
        abogado.addToMany(titulo,abogadoId,"abogadoTitulos");
    }

    private static Entity addTitulo(Schema schema) {
        Entity titulo = schema.addEntity("Titulo");
        titulo.addIdProperty().primaryKey().autoincrement();
        titulo.addStringProperty("nombre").notNull();
        titulo.addStringProperty("descripcion").notNull();
        return titulo;
    }

    private static Entity addAbogado(Schema schema) {
        Entity abogado = schema.addEntity("Abogado");
        abogado.addIdProperty().primaryKey().autoincrement();
        abogado.addStringProperty("nombre").notNull();
        abogado.addStringProperty("cargo").notNull();
        abogado.addStringProperty("descripcion");
        return abogado;
    }
}
