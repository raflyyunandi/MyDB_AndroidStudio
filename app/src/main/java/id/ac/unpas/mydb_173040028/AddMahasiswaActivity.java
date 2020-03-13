package id.ac.unpas.mydb_173040028;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddMahasiswaActivity extends AppCompatActivity {
    EditText nrp;
    EditText nama;
    EditText prodi;
    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mahasiswa);

        nrp = (EditText) findViewById(R.id.nrpMhs);
        nama = (EditText) findViewById(R.id.namaMhs);
        prodi = (EditText) findViewById(R.id.prodi);
        insert = (Button) findViewById(R.id.btnInsert);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNrp = nrp.getText().toString().trim();
                String getNama = nama.getText().toString().trim();
                String getProdi = prodi.getText().toString().trim();
                DatabaseHelper databaseHelper = new DatabaseHelper(AddMahasiswaActivity.this);
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                databaseHelper.creatMahasiswaTable(database);
                databaseHelper.insertDataMahasiswa(database, getNrp, getNama, getProdi);

                Toast.makeText(AddMahasiswaActivity.this, "Insert Data Mahasiswa", Toast.LENGTH_LONG).show();

                nrp.setText("");
                nama.setText("");
                prodi.setText("");
            }
        });
    }
}
