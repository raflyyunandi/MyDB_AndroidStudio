package id.ac.unpas.mydb_173040028;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String arrMenu[] = {"Add Data", "View Data", "Edit Data", "Delete Data", "Logout"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.isView);
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1 , arrMenu));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id ){
                switch (position) {
                    case 0 :
                        startActivity(new Intent(MainActivity.this, AddMahasiswaActivity.class));
                        break;
                    case 1 :
                        startActivity(new Intent(MainActivity.this, ViewMahasiswaActivity.class));
                        break;
                    case 2 :
                        startActivity(new Intent(MainActivity.this, EditMahasiswaActivity.class));
                        break;
                    case 3 :
                        startActivity(new Intent(MainActivity.this, DeleteMahasiswaActivity.class));
                        break;
                    case 4 :
                        Session.logout(MainActivity.this);
                        startActivity(new Intent(MainActivity.this, SignInActivity.class));
                        finish();
                        break;
                }
            }
        });
    }
}
