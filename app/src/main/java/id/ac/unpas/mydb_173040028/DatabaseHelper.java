package id.ac.unpas.mydb_173040028;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "DataMahasiswa";
    public final static String TABLES[] = {"nrp", "nama" , "produi"};
    private final static String NAMA_TABLE = "table_mahasiswa";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {

    }

    public void creatMahasiswaTable(SQLiteDatabase database){
        database.execSQL("CREATE TABLE if not exists " + NAMA_TABLE +"(nrp TEXT PRIMARY KEY, nama TEXT, prodi TEXT);");
        Log.e("Message", "Success");
    }

    public void insertDataMahasiswa(SQLiteDatabase database, String nrp, String nama, String prodi){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nrp",nrp);
        contentValues.put("nama",nama);
        contentValues.put("prodi",prodi);
        database.insert(NAMA_TABLE, null, contentValues);
        Log.e("Messange", "Success");

    }

    public void deleteDataMahasiswa(SQLiteDatabase database, String nrp){
        database.delete(NAMA_TABLE, "nrp =" +nrp, null);
    }

    public Cursor getAll(SQLiteDatabase database){
        return database.query(NAMA_TABLE, TABLES, null, null,null,null,null);
    }
}
