package id.ac.unpas.mydb_173040028;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditMahasiswaActivity extends AppCompatActivity {
    EditText nrp;
    EditText nama;
    EditText prodi;
    Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_mahasiswa);

        nrp = (EditText) findViewById(R.id.nrpMhs);
        nama = (EditText) findViewById(R.id.namaMhs);
        prodi = (EditText) findViewById(R.id.prodi);
        edit = (Button) findViewById(R.id.btnEdit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNrp = nrp.getText().toString().trim();
                String getNama = nama.getText().toString().trim();
                String getProdi = prodi.getText().toString().trim();
                DatabaseHelper databaseHelper = new DatabaseHelper(EditMahasiswaActivity.this);
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                databaseHelper.updateDataMahasiswa(database, getNrp, getNama, getProdi);

                Toast.makeText(EditMahasiswaActivity.this, "Update Data Mahasiswa", Toast.LENGTH_LONG).show();
            }
        });
    }



}
