package id.ac.unpas.mydb_173040028;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteMahasiswaActivity extends AppCompatActivity {
    EditText nrp;
    Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_mahasiswa);

        nrp = (EditText) findViewById(R.id.nrpMhs);
        delete = (Button) findViewById(R.id.btnDelete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getNrp = nrp.getText().toString().trim();
                DatabaseHelper databaseHelper = new DatabaseHelper(DeleteMahasiswaActivity.this);
                SQLiteDatabase database = databaseHelper.getWritableDatabase();
                databaseHelper.deleteDataMahasiswa(database, getNrp);

                Toast.makeText(DeleteMahasiswaActivity.this, "Delete Data Mahasiswa", Toast.LENGTH_LONG).show();
            }
        });
    }

}
