package com.example.inventorymaterial.ui.dependency;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.adapter.DependencyAdapter;
import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyContrat;
import com.example.inventorymaterial.ui.dependency.presenter.ListDependencyPresenterImpl;
import com.example.inventorymaterial.ui.utils.ConfirmationDialog;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment implements ListDependencyContrat.View {

    public static final String TAG = "listdependency";
    private ListDependencyListener callback;
    private ListDependencyContrat.Presenter presenter;
    private DependencyAdapter dependencyAdapter;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContrat.Presenter) presenter;
    }

    interface ListDependencyListener {
        void addNewDependency(Bundle bnd);
    }

    /**
     * Menu contextual que se muestra al realizar una pulsación larga sobre la lista.
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opciones Lista Dependencia");
        getActivity().getMenuInflater().inflate(R.menu.menu_fragment_listdependency, menu);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener) activity;
        } catch (ClassCastException e) {
            // throw new ClassCastException(activity.toString()+" must implements ListDependencyListener");
        }
    }

    /**
     * Implementar las diferentes acciones a realizar en las opciones del menú contextual
     *
     * @param item
     * @return
     */

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.action_listdependency_delete:
                Bundle bnd = new Bundle();
                bnd.putString(ConfirmationDialog.MESSAGE, "¿Desea eliminar la dependencia?");
                bnd.putString(ConfirmationDialog.TITLE, "Eliminar dependencia");
                Dialog dialog = ConfirmationDialog.showConfirmDialog(bnd, getActivity(),(Dependency)getListView().getItemAtPosition(info.position),presenter,ConfirmationDialog.DELETE);
                dialog.show();
                break;
        }
        return super.onContextItemSelected(item);
    }



    public static Fragment newInstance(Bundle arguments) {
        ListDependency listDependency = new ListDependency();
        if(arguments!=null)
        {
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.dependencyAdapter = new DependencyAdapter(getActivity());
        setRetainInstance(true);

    }

    public ListDependency() {}

    @Override
    public void onDetach() {
        super.onDetach();
        callback=null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        dependencyAdapter=null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

            this.presenter= new ListDependencyPresenterImpl(this);

        //Como el fragment mantiene el estado/y sólo elimina la vista)
        //se debe reinicializar el presenter cuando se crea la vista
        View rootView = inflater.inflate(R.layout.fragment_list_dependency,container,false);
        setHasOptionsMenu(true);
        //Como se encuentra en el fragment, usamos rootView
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        ListView listView = (ListView)rootView.findViewById(android.R.id.list);
        //Si el floatingActionButton se encontrara en el xml de la activity
        //FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              callback.addNewDependency(null);
            }
        });
        presenter.loadDependency();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(dependencyAdapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bnd = new Bundle();
                bnd.putParcelable(Dependency.TAG, (Dependency)adapterView.getItemAtPosition(i));
                callback.addNewDependency(bnd);
            }
        });
        //Registramos el menú contextual
        registerForContextMenu(getListView());
    }

    public void showDependency(List<Dependency> list)
    {
        dependencyAdapter.clear();
        dependencyAdapter.addAll(list);
    }

    @Override
    public void showDeleteDependency() {
        showMessageList(getResources().getString(R.string.successDeleteDependency));
    }

    @Override
    public void showMessageList(String message) {
        Snackbar.make(getActivity().findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("presenter",presenter);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_orderby, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_listdependency_orderById:

                break;
            case R.id.action_listdependency_orderByName:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
