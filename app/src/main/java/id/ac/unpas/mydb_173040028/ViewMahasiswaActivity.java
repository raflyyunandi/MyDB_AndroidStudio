package id.ac.unpas.mydb_173040028;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ViewMahasiswaActivity extends AppCompatActivity {
    ListView myListView;
    protected DatabaseHelper databaseHelper;
    protected SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mahasiswa);
        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        try {
            loadDataMahasiswa();
        } catch (Exception e){
            Log.e("Masuk" , "->" + e.getMessage());
        }
    }

    private void loadDataMahasiswa() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getAllData());
        myListView.setAdapter(adapter);
    }

    private List<String> getAllData() {
        List<String> names = new ArrayList<String>();
        Cursor cursor = databaseHelper.getAll(database);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String data = cursor.getString(0) + " - "
                    + cursor.getString(1) + " - "
                    + cursor.getString(2);
            names.add(data);
            cursor.moveToNext();
        }
        cursor.close();
        Collections.sort(names);
        return names;
    }
}
