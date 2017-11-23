package com.example.inventorymaterial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.inventorymaterial.ui.dependency.DependecyActivity;
import com.example.inventorymaterial.ui.inventory.InventoryActivity;
import com.example.inventorymaterial.ui.prefs.AccountSettingActivity;
import com.example.inventorymaterial.ui.prefs.GeneralSettingActivity;
import com.example.inventorymaterial.ui.product.ProductActivity;
import com.example.inventorymaterial.ui.sector.SectorActivity;

/*
Esta activity gestiona el menus DashBoard con los distintos modulos de Inventory
    @author Juan Francisco
    @version 17.10.20

 */
public class DashboardActivity extends AppCompatActivity {

    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        gridDashboard=(GridLayout) findViewById(R.id.gridLayout);

        //Definir un array de int, que contendrá el id de las imágenes Inventory, Product, Dependenicas, Secciones y Preferencias
        int[] images = {
                R.drawable.inventory,
                R.drawable.product,
                R.drawable.dependencies,
                R.drawable.sections,
                R.drawable.preferences
                };

        // Usar arrays en Java/Android no es eficiente. Mejor Vector/Colecciones ->  ImageView[] imageViews = new ImageView[images.length];

      //Y esto tampoco por que no trabajamos con hilos y no se requiere sincronizacion ->  Vector<ImageView> vectorImageViews = new Vector<ImageView>();
/*
        ArrayList arrayImageList = new ArrayList();

        for(int i = 0; i<images.length;i++)
        {
            arrayImageList.add(new ImageView(this));
            if(arrayImageView.get(i) instanceof ImageView
            ((ImageView)arrayImageList.get(i)).setImageResource(images[i]);
            }
      */
        listenerDashboard = new ClickListenerDashboard();
        ImageView imageView;
        float width= getResources().getDimension(R.dimen.imgDashboardWidth);
        float heigth= getResources().getDimension(R.dimen.imgDashboardHeith);
        float margin = getResources().getDimension(R.dimen.imgDashboardMargin);

        for(int i = 0; i<images.length;i++)
        {
            imageView = new ImageView(this);
            //generateId() ->Metodo que ha usado lourdes, para guardar en una variable este id y usando en el Swith
            imageView.setId((images[i]));
            imageView.setImageResource(images[i]);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height= (int) heigth;
            params.setMargins((int)margin,(int)margin,(int)margin,(int)margin);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED,GridLayout.FILL,1f);
            imageView.setLayoutParams(params);
            imageView.setOnClickListener(listenerDashboard);
            gridDashboard.addView(imageView);
        }
    }

    class ClickListenerDashboard implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=null;
            switch (v.getId()){
                case R.drawable.inventory:
                    intent = new Intent(DashboardActivity.this, InventoryActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.product:
                    intent= new Intent(DashboardActivity.this, ProductActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.dependencies:
                    intent = new Intent(DashboardActivity.this, DependecyActivity.class);
                    startActivity(intent);
                    break;
                case R.drawable.sections:
                    intent = new Intent(DashboardActivity.this, SectorActivity.class);
                    startActivity(intent);
                    break;
            }
          //startActivity(intent);
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_dashboard,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_general_setting:
                startActivity(new Intent(DashboardActivity.this, GeneralSettingActivity.class));
            break;
            case R.id.action_account_setting:
                startActivity(new Intent(DashboardActivity.this, AccountSettingActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
