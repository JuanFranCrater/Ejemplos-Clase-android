package com.example.inventorymaterial.data.db.repository;

import com.example.inventorymaterial.data.db.model.Dependency;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by
 * @creator Juan Francisco
 */

public class DependencyRepository {

    //Declaracion
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;


    //Inicializacion
    //Inicializar todos los atributos de ámbito statico o de clase
    static {
        dependencyRepository = new DependencyRepository();
    }


    //El metodo ha de ser privado para garantizar que sólo hay una instancia de Repository
    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        initialize();
    }

    //Metodos

    private void initialize() {
        addDependency(new Dependency(2, "2 Cliclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1 Cliclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1 Cliclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2 Cliclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2 Cliclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1 Cliclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));

    }

    public static DependencyRepository getInstance() {
        if (dependencyRepository == null)
            dependencyRepository = new DependencyRepository();
        return dependencyRepository;
    }


    /**
     * Método que añade una dependencia
     *
     * @param dependency
     */
    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);

    }

    public ArrayList<Dependency> getDependencies()
    {
        Collections.sort(dependencies);
        //Collections.sort(dependencies, new Dependency.DependencyOrderByShortName());
        return dependencies;
    }
}
